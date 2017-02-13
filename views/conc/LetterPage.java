package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.form.*;

/**
 * Created by Сергей on 06.02.2017.
 */
public class LetterPage extends Page {
    private String action = "/letter/send";
    private Body body = new Body();
    private Message warningMess = new Message("");
    private Message infoMess = new Message("");
    private Form form = new Form("POST");
    private TextInput receiver = new TextInput("receiver", TextInputType.text);
    private TextInput subject = new TextInput("subject", TextInputType.text);
    private TextInput letterBody = new TextInput("letterBody", TextInputType.textarea);
    private HiddenInput inputSessionId = new HiddenInput("sessionId");
    private ExecutiveInput sendButton = new ExecutiveInput("send", ExecutiveInputType.submit);


    public LetterPage() {
        super("send");

        form.setAction(action);
        form.addInput(inputSessionId);
        form.addInput(sendButton);
        form.addInput(receiver);
        form.addInput(subject);
        form.addInput(letterBody);


        body.addElement(form);
        super.setBody(body);

    }

    public LetterPage setWarning(String warning) {
        warningMess.setMessage(warning);
        body.setMessage(warningMess);
        return this;
    }

    public LetterPage setInfo(String info) {
        infoMess.setMessage(info);
        body.setMessage(infoMess);
        return this;
    }

    public LetterPage setLetterBody(String letterBody) {

        this.letterBody.setValue(letterBody);

        return this;
    }

    public void setSessionId(String sessionId) {

        inputSessionId.setValue(sessionId);

    }

    public void setSubject(String subject) {

        this.subject.setValue(subject);

    }

    public void setReceiver(String receiver) {
        this.receiver.setValue(receiver);

    }

}
