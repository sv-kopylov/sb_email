package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sb_email.controllers.manager.Bag;
import sb_email.controllers.manager.PostBoxManager;
import sb_email.dao.LetterDao;
import sb_email.dao.LettersBoxBunchDao;
import sb_email.dao.PostBoxDao;
import sb_email.persist.Letter;
import sb_email.persist.LetterBoxBunch;
import sb_email.persist.PostBox;
import sb_email.persist.Relation;
import sb_email.views.conc.LetterPage;
import sb_email.views.conc.PostBoxPage;
import sb_email.views.conc.WelcomePage;
import sb_email.views.conc.reachdesign.pages.P_Letter;
import sb_email.views.conc.reachdesign.pages.P_Welcome;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.*;

/**
 * Created by Сергей on 06.02.2017.
 */
@Controller
@Scope(value = "request")
@RequestMapping(value = "/letter")
public class LetterController {
    Letter letter = new Letter();
    @Autowired
    private LetterDao letterDao;
    @Autowired
    private LettersBoxBunchDao lettersBoxBunchDao;
    @Autowired
    private PostBoxDao postBoxDao;
    @Autowired
    private Bag bag;
    private P_Letter letterPage;

    private static TreeSet<String> parceReceiver(String initial) {
        TreeSet<String> receivers = new TreeSet<>();
        String receiver;
        int i;
        while (true) {
            i = initial.indexOf(',');
            if (i == -1) {
                receiver = initial.trim();
                if (receiver.length() > 0)
                    receivers.add(receiver);
                break;
            }
            receiver = initial.substring(0, i).trim();
            initial = initial.substring(i + 1);
            if (receiver.length() > 0)
                receivers.add(receiver);
        }

        return receivers;
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public String send(@WebParam String sessionId,
                       @WebParam String subject,
                       @WebParam String letterBody,
                       @WebParam String receiver) {
        if (sessionId == null) {
            return new P_Welcome().setWarning("no session id received").getPage();

        } else {
            letterPage = new P_Letter(sessionId, bag.getManager(sessionId).getPostBox().getTytle());
        }

        if (subject != null) {

            letterPage.setSubject(subject);
            letter.setSubject(subject);

        }
        if (letterBody != null) {

            letterPage.setLetterBody(letterBody);
            letter.setBody(letterBody);
        } else {
            System.out.println("letters body is null");
        }
        if (receiver == null) {
            return letterPage.setWarning("Please enter receiver").getPage();
        }

//   собственно отправка
        String result = insertNecessary(letter, receiver, sessionId);

        if (result.equals("nullpointer")){
            return new P_Welcome().setWarning("nullpointer in insertNecessary").getPage();
        }

        if (result.equals("timeout")){
            return new P_Welcome().setWarning("no postBoxManager in context, perhaps deleted by timeout").getPage();
        }


        return bag.getManager(sessionId).getPostBoxPage().setInfo(result).getPage();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String prepareLetterPage (@RequestParam(value = "sessionId", required = false) String sessionId){
        if(bag.getManager(sessionId)==null){
            return new P_Welcome().getPage();
        }
        return new P_Letter(sessionId, bag.getManager(sessionId).getPostBox().getTytle()).getPage();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public String delete (@WebParam String sessionId,
                          @WebParam String letterId
    )  {
        PostBoxManager pbmngr = bag.getManager(sessionId);
        if (pbmngr==null) return new P_Welcome().getPage();

        PostBox pb = pbmngr.getPostBox();
        Letter letter =letterDao.findOne(Long.parseLong(letterId));
        Relation relation=Relation.RECEIVED;

        List<LetterBoxBunch> bunches = lettersBoxBunchDao.findByPostBox(pb);
        for (int i=0; i<bunches.size(); i++){
           if(bunches.get(i).getLetter().equals(letter)){
               bunches.get(i).setDeleted(true);
               lettersBoxBunchDao.save(bunches.get(i));
               relation = bunches.get(i).getRelation();
               break;
              }

        }

        bunches = lettersBoxBunchDao.findByLetter(letter);
        int cnt=0;
        for(int i=0; i<bunches.size(); i++){
            if (!bunches.get(i).isDeleted()){
                cnt++;
            }
        }
        if(cnt==0){
            lettersBoxBunchDao.delete(bunches);
            letterDao.delete(letter);
        }

        if(relation.equals(Relation.SENT)){
           pbmngr.setSentLetters(lettersBoxBunchDao);
        return pbmngr.getPostBoxPage().getPage();
        } else {
            pbmngr.setReceivedLetters(lettersBoxBunchDao);
            return pbmngr.getPostBoxPage().getPage();
        }
    }

    @Transactional
    private String insertNecessary(Letter let, String receivers, String sessionId) {
        StringBuilder sb = new StringBuilder();
        if (let == null ||  receivers == null || sessionId == null) {
            sb.append("nullpointer");
            return sb.toString();
        }
        PostBoxManager postBoxManager = bag.getManager(sessionId);
//   System.out.println("insertNecwssaty meth, session id is "+sessionId);
        PostBox ownerBox;
        if (postBoxManager == null) {
            sb.append("timeout");
            return sb.toString();
        } else {
            ownerBox = postBoxManager.getPostBox();
        }
        TreeSet<String> logins = parceReceiver(receivers);
        ArrayList<PostBox> boxes = new ArrayList<>();
        PostBox findBox;
        StringBuilder stb= new StringBuilder();
        for (String s : logins) {
            findBox = postBoxDao.findByLogin(s);
            if (findBox != null) {
                boxes.add(findBox);
                stb.append(findBox.getLogin());
                stb.append(", ");
                } else {
                sb.append("Account " + s + " not found<br>");
            }
        } if (stb.length()>0){
            let.setReceiver(stb.substring(0, stb.length()-2));
        }
        if (boxes.size() == 0) {
            return sb.toString();
        }
//      save letter
        let.setSender(ownerBox.getLogin());
        let = letterDao.save(let);

//      save sent letter
        Date dt = GregorianCalendar.getInstance().getTime();

        LetterBoxBunch lbBunch = new LetterBoxBunch();
        lbBunch.setLetter(let);
        lbBunch.setPostBox(ownerBox);
        lbBunch.setRelation(Relation.SENT);
        lbBunch.setDate(dt);
        lettersBoxBunchDao.save(lbBunch);
        lbBunch = null;

//       save received letters
        for (PostBox pb : boxes) {
            lbBunch = new LetterBoxBunch();
            lbBunch.setLetter(let);
            lbBunch.setPostBox(pb);
            lbBunch.setRelation(Relation.RECEIVED);
            lbBunch.setDate(dt);
            lettersBoxBunchDao.save(lbBunch);
            lbBunch = null;
            sb.append("letter to " + pb.getName() + " (" + pb.getLogin() + ") successfully sent<br>");


        }

        return sb.toString();
    }


}
