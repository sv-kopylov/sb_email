package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TreeSet;

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
    private LetterPage letterPage = new LetterPage();

    private static TreeSet<String> parceReceiver(String initial){
        TreeSet<String> receivers = new TreeSet<>();
        String receiver;
        int i;
        while (true){
            i = initial.indexOf(',');
            if (i==-1) {
                receiver = initial.trim();
                if (receiver.length()>0)
                    receivers.add(receiver);
                break;
            }
            receiver = initial.substring(0, i).trim();
            initial = initial.substring(i+1);
            if (receiver.length()>0)
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
            return new WelcomePage().getPage();

        } else {letterPage.setSessionId(sessionId);}

        if (subject != null) {
            letterPage.setSubject(subject);
            letter.setSubject(subject);
        }
        if (letterBody != null) {
            letterPage.setLetterBody(letterBody);
            letter.setBody(letterBody);
        }
        if (receiver!=null){
            letterPage.setReceiver(receiver);
        } else
            return letterPage.setWarning("Please enter receiver").getPage();






            return new PostBoxPage().getPage();
        }

    private PostBox findReceiver(String receiver){
            return postBoxDao.findByLogin(receiver);
        }

        @Transactional
        private String insertNecessary (Letter let, PostBox sender, String receivers, String sessionId){
        StringBuilder sb = new StringBuilder();
        if (let==null||sender==null||receivers==null||sessionId==null){
            sb.append("nullpointer");
            return sb.toString();
        }
        PostBoxManager postBoxManager = bag.getManager(sessionId);
            PostBox ownerBox;
        if (postBoxManager==null){
            sb.append("timeout");
            return sb.toString();
        } else {
            ownerBox = postBoxManager.getPostBox();
        }
            TreeSet<String> logins = parceReceiver(receivers);
            ArrayList<PostBox> boxes = new ArrayList<>();
            PostBox findBox;
            for(String s: logins){
                findBox =postBoxDao.findByLogin(s);
                if (findBox!=null){
                    boxes.add(findBox);
                } else {
                    sb.append("Account "+s+" not found<br>");
                }
            }
            if (boxes.size()==0) return sb.toString();
//      save letter
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
            for(PostBox pb: boxes){
                lbBunch = new LetterBoxBunch();
                lbBunch.setLetter(let);
                lbBunch.setPostBox(pb);
                lbBunch.setRelation(Relation.RECEIVED);
                lbBunch.setDate(dt);
                lettersBoxBunchDao.save(lbBunch);
                lbBunch = null;
                sb.append("letter to "+pb.getName()+" ("+pb.getLogin()+") successfully sent<br>");


            }

        return sb.toString();
        }



    }
