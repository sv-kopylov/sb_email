package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sb_email.dao.PostBoxDao;
import sb_email.persist.PostBox;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@WebParam String login, @WebParam String password, @WebParam String name) {
        if (login == null || password == null||name==null) {
            return wp.setWarning("some parameter(s) wasnt get").getPage();
        }
        userLogin = login;



        if (postBoxDao.findByLogin(login) != null) {
            return wp.setWarning("user "+login+" already exists").getPage();
        }

       userPassword = password;
        userName = name;

        usersBox = new PostBox();
        usersBox.setLogin(login);
        usersBox.setPassword(password);
        usersBox.setName(name);

        postBoxDao.save(usersBox);


        return wp.setInfo("User successfully added").getPage();
    }


}
