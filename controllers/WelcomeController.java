package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sb_email.dao.PostBoxDao;
import sb_email.persist.PostBox;
import sb_email.views.conc.PostBoxPage;
import sb_email.views.conc.WelcomePage;

import javax.jws.WebParam;
import java.util.List;

/**
 * Created by Сергей on 27.01.2017.
 */
@Controller
@Scope(value = "request")
public class WelcomeController {



    @Autowired
    PostBoxDao postBoxDao;
    private String userLogin;
    private String userPassword;
    private String userName;
    private PostBox usersBox;
    private WelcomePage wp = new WelcomePage();
    private PostBoxPage pbp = new PostBoxPage();

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login (@RequestParam("login") String login,
                         @RequestParam("password") String password) {

        System.out.println(login);
        System.out.println(password);
        if (login == null || password == null) {
            return wp.setInfo("Please enter your login & password for enter").getPage();
        }


        if ((usersBox=postBoxDao.findByLogin(login)) != null) {
            if (password.equals(usersBox.getPassword())){
                return pbp.getPage();
            } else  return wp.setWarning("password is incorrect").getPage();
        } else return wp.setWarning("user "+login+" does not exists").getPage();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    @ResponseBody
    public String welcome (){
        return wp.getPage();
    }

}
