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

import java.util.List;

/**
 * Created by Сергей on 27.01.2017.
 */
@Controller
@Scope(value = "request")
public class WelcomeController {



    @Autowired
    PostBoxDao postBoxDao;
    private String login;
    private String password;
    private String name;
    private PostBox usersBox;
    private WelcomePage wp = new WelcomePage();

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String create(String usersLogin, String usersPassword, String usersName) {
        if (usersLogin == null || usersPassword == null||usersName==null) {
            return wp.setWarning("some parameter(s) wasnt get").getPage();
        }
        login = usersLogin;



        if (postBoxDao.findByLogin(login) != null) {
            return wp.setWarning("user "+login+" already exists").getPage();
        }

        password = usersPassword;
        name = usersName;

        usersBox = new PostBox();
        usersBox.setLogin(login);
        usersBox.setPassword(password);
        usersBox.setName(name);

        postBoxDao.save(usersBox);


        return wp.setInfo("User successfully added").getPage();
    }


}
