package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.bodyelemants.Section;
import sb_email.views.abstr.bodyelemants.TextElement;
import sb_email.views.abstr.form.Form;
import sb_email.views.abstr.form.TextInput;
import sb_email.views.abstr.form.TextInputType;

/**
 * Created by Сергей on 28.01.2017.
 */
public class WelcomePage extends Page{
    private Message warningMess = new Message("");
    private Message infoMess = new Message("");
    private Body body = new Body();
    private String action = "/welcome";

    public WelcomePage() {
        super("welcome");
        Message greeting = new Message("Enter login, password and your name for register post box");
        Form loginForm = new Form("POST");
        TextInput loginLogin = new TextInput("login", TextInputType.text);
        TextInput passwordLogin = new TextInput("password", TextInputType.text);

        Form create = new Form("POST");


        warningMess.setStyle("color: red; font-size: 2em");
        infoMess.setStyle("color: black; font-size: 2em");
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
