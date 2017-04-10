package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.bodyelemants.HtmlA;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlHiddenInput;

import java.util.ArrayList;

/**
 * Created by Сергей on 09.03.2017.
 */
public class PostBoxPageAside extends HtmlElement {


    private HtmlHiddenInput sessionIdHidden = new HtmlHiddenInput("sessionId");

    private HtmlA sentLettersLink = new HtmlA(ViewSettings.viewSentLettersLink);
    private HtmlA receivedLettersLink = new HtmlA(ViewSettings.viewReceivedLettersLink);
    private boolean sendActionEnabled=false;
    private HtmlA sendAction = new HtmlA(ViewSettings.newLetterLink);
    private String sessionId;

    public PostBoxPageAside() {
        super("aside");
        sendAction.setAttribute("class","sendActionLink");


    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        if(sendActionEnabled){
            sb.append(sendAction.toString());
            sb.append(Wraper.br());
        }
        sb.append(sentLettersLink.toString());
        sb.append(Wraper.br());
        sb.append(receivedLettersLink.toString());
        return sb.toString();
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
        receivedLettersLink.setAction(ViewSettings.viewReceivedLettersAction+ "?"+"sessionId="+sessionId);
        sentLettersLink.setAction(ViewSettings.viewSentLettersAction+ "?"+"sessionId="+sessionId);
        sendAction.setAction(ViewSettings.newLetterAction+ "?"+"sessionId="+sessionId);
        sessionIdHidden.setAttribute("value", sessionId);
    }

    public void enableSendAction() {
        sendActionEnabled = true;
    }
}
