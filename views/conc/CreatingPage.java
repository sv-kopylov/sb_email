package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.bodyelemants.TextElement;
import sb_email.views.abstr.form.*;

/**
 * Created by Сергей on 02.02.2017.
 */
public class CreatingPage extends Page {
    private Message warningMess = new Message("");
    private Message infoMess = new Message("");
    private Body body = new Body();
    private String action = "/create";

    public CreatingPage() {
        super("create");
        warningMess.setStyle("color: red; font-size: 2em");
        infoMess.setStyle("color: black; font-size: 2em");

        Form form = new Form("POST");
        form.setAction(action);
        form.addInput(new TextInput("name", TextInputType.text));
        form.addInput(new TextInput("login", TextInputType.text));
        form.addInput(new TextInput("password", TextInputType.text));

        form.addInput(new ExecutiveInput("create", ExecutiveInputType.submit));

        body.addElement(new TextElement("Enter your details for create"));
        body.addElement(form);

        super.setBody(body);

    }
    public CreatingPage setWarning (String warning){
        warningMess.setMessage(warning);
        body.setMessage(warningMess);
        return this;
    }
    public CreatingPage setInfo (String info){
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
