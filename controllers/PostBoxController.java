package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sb_email.controllers.manager.Bag;
import sb_email.controllers.manager.PostBoxManager;
import sb_email.dao.LetterDao;
import sb_email.dao.LettersBoxBunchDao;
import sb_email.persist.Letter;
import sb_email.views.conc.reachdesign.pages.P_Letter;
import sb_email.views.conc.reachdesign.pages.P_Welcome;

import javax.jws.WebParam;

/**
 * Created by Сергей on 06.02.2017.
 */
@Controller
@Scope(value = "request")
@RequestMapping(value = "/postbox")
public class PostBoxController {
    @Autowired
    Bag bag;
    @Autowired
    private LetterDao letterDao;
    @Autowired
    private LettersBoxBunchDao lettersBoxBunchDao;


    @RequestMapping(value = "/received", method = RequestMethod.GET)
    @ResponseBody
    public String received(@RequestParam(value = "sessionId", required = false) String sessionId) {

        if (sessionId != null) {
            PostBoxManager pbm = bag.getManager(sessionId);
                if (pbm == null) return new P_Welcome().getPage();
            pbm.setReceivedLetters(lettersBoxBunchDao);
            return pbm.getPostBoxPage().setInfo("Received letters").getPage();

        } else return new P_Welcome().getPage();

    }


    @RequestMapping(value = "/sent", method = RequestMethod.GET)
    @ResponseBody
    public String sent(String sessionId) {
        if (sessionId != null) {
            PostBoxManager pbm = bag.getManager(sessionId);
                if (pbm == null) return new P_Welcome().getPage();
            pbm.setSentLetters(lettersBoxBunchDao);
            return pbm.getPostBoxPage().setInfo("Sent letters").getPage();

        } else return new P_Welcome().setInfo("session expired").getPage();

    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    @ResponseBody
    public String view(@WebParam String sessionId,
                       @WebParam String letterId
    ) {
        if (sessionId == null || letterId == null) {
            return new P_Welcome().getPage();

        }
        if(bag.getManager(sessionId)==null){
            return new P_Welcome().getPage();
        }
        P_Letter letterPage = new P_Letter(sessionId, bag.getManager(sessionId).getPostBox().getTytle());
        Letter letter = letterDao.findOne(Long.parseLong(letterId));

        return letterPage.setLetter(letter).getPage();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST )
    @ResponseBody
    public String logout(@WebParam String sessionId) {
        bag.removeManager(sessionId);
        return new P_Welcome().getPage();

        }

}
