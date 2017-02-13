package sb_email.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sb_email.controllers.manager.Bag;
import sb_email.controllers.manager.PostBoxManager;
import sb_email.dao.PostBoxDao;
import sb_email.persist.PostBox;
import sb_email.views.conc.CreatingPage;
import sb_email.views.conc.PostBoxPage;
import sb_email.views.conc.WelcomePage;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Сергей on 03.02.2017.
 */
@Controller
@Scope(value = "request")
public class CreateController {
    @Autowired
    PostBoxDao postBoxDao;

    @Autowired
    private Bag bag;
    private String userLogin;
    private String userPassword;
    private String userName;
    private PostBox usersBox;
    private CreatingPage creatingPage = new CreatingPage();


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(HttpServletRequest req, @WebParam String login, @WebParam String password, @WebParam String name) {
        if (login == null || password == null||name==null) {
            return creatingPage.setInfo("Enter your details for register postbox").getPage();
        }

        if (postBoxDao.findByLogin(login) != null) {
            return creatingPage.setWarning("user "+login+" already exists").getPage();
        }

        usersBox = new PostBox();
        usersBox.setLogin(login);
        usersBox.setPassword(password);
        usersBox.setName(name);

        postBoxDao.save(usersBox);

        return new WelcomePage().setInfo("Post box successfully created," +
                " please login for access to your account").getPage();

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public String getEmptyForm (){
        return creatingPage.setInfo("Enter your details for register postbox").getPage();
    }


}
