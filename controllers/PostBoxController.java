package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sb_email.controllers.manager.Bag;
import sb_email.controllers.manager.PostBoxManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Сергей on 06.02.2017.
 */
@Controller
@Scope(value = "request")
@RequestMapping(value = "/postbox")
public class PostBoxController {
    @Autowired
    Bag bag;

    @RequestMapping(value = "/received", method = RequestMethod.GET)
    @ResponseBody
    public String received (String sessionId){
        PostBoxManager pbManager = bag.getManager(sessionId);
        return pbManager.getPostBoxPage().getPage();

    }

    @RequestMapping(value = "/sent", method = RequestMethod.GET)
    @ResponseBody
    public String sent (String sessionId){
        PostBoxManager pbManager = bag.getManager(sessionId);
        return pbManager.getPostBoxPage().getPage();

    }



}
