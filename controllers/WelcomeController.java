package sb_email.controllers;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sb_email.controllers.manager.Bag;
import sb_email.controllers.manager.IdGen;
import sb_email.controllers.manager.PostBoxManager;
import sb_email.dao.PostBoxDao;
import sb_email.persist.PostBox;
import sb_email.views.conc.PostBoxPage;
import sb_email.views.conc.WelcomePage;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Сергей on 27.01.2017.
 */
@Controller
@Scope(value = "request")
@RequestMapping(value = "/welcome", method = RequestMethod.GET)
public class WelcomeController {

    private static Logger logger = LogManager.getLogger(WelcomeController.class);


    @Autowired
    PostBoxDao postBoxDao;
    @Autowired
    private Bag bag;

    private String userLogin;
    private String userPassword;
    private String userName;
    private PostBox usersBox;
    private WelcomePage wp = new WelcomePage();
    private PostBoxPage pbp = new PostBoxPage();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login (@RequestParam(value = "login", required = false) String login,
                         @RequestParam(value = "password", required = false) String password) {

        System.out.println("request received");

        if (login == null || password == null) {
            return wp.setInfo("Please enter your login & password for enter").getPage();
        }

        if ((usersBox=postBoxDao.findByLogin(login)) != null) {
            if (password.equals(usersBox.getPassword())){
                PostBoxManager pbm = new PostBoxManager(IdGen.getId(login), usersBox);
                bag.addManager(pbm);
       logger.debug("heree postBox manager should be added into the Bag");
//       System.out.println("heree postBox manager should be added into the Bag "+pbm.getSessionId());
                return pbm.getPostBoxPage().setInfo("Perhaps tou are logged in").getPage();
            } else  return wp.setWarning("password is incorrect").getPage();
        } else return wp.setWarning("user "+login+" does not exists").getPage();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String welcome (){
        return wp.getPage();
    }

}
