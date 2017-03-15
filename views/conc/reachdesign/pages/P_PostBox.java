package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.conc.reachdesign.parts.P_MasterTemplate;
import sb_email.views.conc.reachdesign.parts.PostBoxPageAside;
import sb_email.views.conc.reachdesign.parts.PostBoxPageBodyHeader;

/**
 * Created by Сергей on 09.03.2017.
 */
public class P_PostBox extends P_MasterTemplate {

    private PostBoxPageBodyHeader header = new PostBoxPageBodyHeader();
    private PostBoxPageAside aside = new PostBoxPageAside();
    private String sessionId;
    public P_PostBox() {
        super(ViewSettings.grandTytle);
        super.getBody().setDodyAside(aside);
    }


    @Override
    protected HtmlElement setBodyHeader() {
        return header;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
        header.setSessionId(sessionId);
        aside.setSessionId(sessionId);
    }
}
