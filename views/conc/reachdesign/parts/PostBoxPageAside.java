package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.bodyelemants.HtmlA;

import java.util.ArrayList;

/**
 * Created by Сергей on 09.03.2017.
 */
public class PostBoxPageAside extends HtmlElement {

    private HtmlA sentLettersLink = new HtmlA(ViewSettings.viewSentLettersLink);
    private HtmlA receivedLettersLink = new HtmlA(ViewSettings.viewReceivedLettersLink);
    private String sessionId;

    public PostBoxPageAside() {
        super("aside");
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        sb.append(sentLettersLink.toString());
        sb.append(receivedLettersLink.toString());
        return sb.toString();
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
        receivedLettersLink.setAction(ViewSettings.viewReceivedLettersAction+ "?"+"sessionId="+sessionId);
        sentLettersLink.setAction(ViewSettings.viewSentLettersAction+ "?"+"sessionId="+sessionId);
    }
}
