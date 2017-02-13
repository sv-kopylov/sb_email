package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.form.ExecutiveInput;
import sb_email.views.abstr.form.ExecutiveInputType;
import sb_email.views.abstr.form.Form;
import sb_email.views.abstr.form.HiddenInput;

/**
 * Created by Сергей on 03.02.2017.
 */
public class PostBoxPage extends Page {
    private final String sendLetterAction = "/letter/";
    HiddenInput hiddenInput = new HiddenInput("sessionId");
    Body body = new Body();
    Message mess = new Message("You successfuly logged in, or send message");
    private String sessionId;
    private Message warningMess = new Message("");
    private Message infoMess = new Message("");

    public PostBoxPage (){
        super("YourPostbox");
        warningMess.setStyle("color: red; font-size: 2em");
        infoMess.setStyle("color: black; font-size: 2em");
        Form sendLetterForm = new Form("POST");
        sendLetterForm.setAction(sendLetterAction);
        sendLetterForm.addInput(hiddenInput);
        sendLetterForm.addInput(new ExecutiveInput("create", ExecutiveInputType.submit));
        body.addElement(sendLetterForm);



        super.setBody(body);
    }

    public PostBoxPage setWarning (String warning){
        warningMess.setMessage(warning);
        body.setMessage(warningMess);
        return this;
    }
    public PostBoxPage setInfo (String info){
        infoMess.setMessage(info);
        body.setMessage(infoMess);
        return this;
    }

    public PostBoxPage setSessionId(String sessionId)  {
        this.sessionId = sessionId;
        hiddenInput.setValue(sessionId);

        return this;
    }
}
