package sb_email.views.conc;

import sb_email.persist.Letter;
import sb_email.views.abstr.Body;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.bodyelemants.HtmlA;
import sb_email.views.abstr.bodyelemants.HtmlUnorderedList;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.form.ExecutiveInput;
import sb_email.views.abstr.form.ExecutiveInputType;
import sb_email.views.abstr.form.Form;
import sb_email.views.abstr.form.HiddenInput;

import java.util.ArrayList;

/**
 * Created by Сергей on 03.02.2017.
 */
public class PostBoxPage extends Page {
    private final String sendLetterAction = "/letter/";
    private final String viewLetterAction = "/postbox/view";
    private final String viewSentLettersAction = "/postbox/sent";
    private final String viewReceivedLettersAction = "/postbox/received";

    HtmlA sentLettersLink = new HtmlA("Sent letters");
    HtmlA receivedLettersLink = new HtmlA("Received letters");

    HiddenInput hiddenInput = new HiddenInput("sessionId");
    Body body = new Body();
    Message mess = new Message("You successfuly logged in, or send message");
    private String sessionId;
    private Message warningMess = new Message("");
    private Message infoMess = new Message("");
    private HtmlUnorderedList lettersList = new HtmlUnorderedList();

    public PostBoxPage (){
        super("YourPostbox");
        warningMess.setStyle("color: red; font-size: 2em");
        infoMess.setStyle("color: black; font-size: 2em");
        Form sendLetterForm = new Form("POST");
        sendLetterForm.setAction(sendLetterAction);
        sendLetterForm.addInput(hiddenInput);
        sendLetterForm.addInput(new ExecutiveInput("create", ExecutiveInputType.submit));
        body.addElement(sendLetterForm);
        body.addElement(receivedLettersLink);
        body.addElement(sentLettersLink);
        body.addElement(lettersList);
        super.setBody(body);
    }
    public PostBoxPage setSentLetters(ArrayList<Letter> letters){
        lettersList.clear();
        SentLetterItem item = new SentLetterItem(viewLetterAction);
        for(Letter let:letters){
           item.setletter(let);
           lettersList.addElement(item.toStrring());
        }
        return this;
    }

    public PostBoxPage setReceivedLetters(ArrayList<Letter> letters, String sessId){
        lettersList.clear();
        ReceivedLetterItem item = new ReceivedLetterItem(viewLetterAction, sessId);
        for(Letter let:letters){
            item.setletter(let);
            lettersList.addElement(item.toString());
            }
        return this;
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
        receivedLettersLink.setAction(viewReceivedLettersAction+ "?"+"sessionId="+sessionId);
        sentLettersLink.setAction(viewSentLettersAction+ "?"+"sessionId="+sessionId);
        return this;
    }
}
