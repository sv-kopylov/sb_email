package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.bodyelemants.TextElement;
import sb_email.views.abstr.form.*;

/**
 * Created by Сергей on 28.01.2017.
 */
public class WelcomePage extends Page{
    private Message warningMess = new Message("");
    private Message infoMess = new Message("");
    private Body body = new Body();
    private String action = "/welcome/login";

    public WelcomePage() {
        super("welcome");
        warningMess.setStyle("color: red; font-size: 2em");
        infoMess.setStyle("color: black; font-size: 2em");

        Form loginForm = new Form("POST");
        loginForm.setAction(action);
        loginForm.addInput(new TextInput("login", TextInputType.text));
        loginForm.addInput(new TextInput("password", TextInputType.text));
        loginForm.addInput(new ExecutiveInput("login", ExecutiveInputType.submit));


        body.addElement(loginForm);
        body.addElement(new TextElement(Wraper.a("Create new post box","/create")));

        super.setBody(body);
    }
    public WelcomePage setWarning (String warning){
        warningMess.setMessage(warning);
        body.setMessage(warningMess);
        return this;
    }
    public WelcomePage setInfo (String info){
        infoMess.setMessage(info);
        body.setMessage(infoMess);
        return this;
    }
    public String getAction() {
        return action;
    }
    public void setAction(String action) {
        this.action = action;
    }
}
