package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.persist.LetterBoxBunch;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.bodyelemants.HtmlA;
import sb_email.views.conc.reachdesign.parts.LettersTable;
import sb_email.views.conc.reachdesign.parts.P_MasterTemplate;
import sb_email.views.conc.reachdesign.parts.PostBoxPageAside;
import sb_email.views.conc.reachdesign.parts.PostBoxPageBodyHeader;

import java.util.List;

/**
 * Created by Сергей on 09.03.2017.
 */
public class P_PostBox extends P_MasterTemplate {

    private String sessionId;
    private PostBoxPageBodyHeader header;
    private PostBoxPageAside aside = new PostBoxPageAside();
    private LettersTable lettersTable = new LettersTable();
    private HtmlA sendLinc;

    public P_PostBox(String tytle) {
        super(ViewSettings.grandTytle);
        header = new PostBoxPageBodyHeader(tytle);
        aside.enableSendAction();
        super.getBody().setBodyHeader(header);
        super.getBody().setDodyAside(aside);
        super.getBody().addElement(lettersTable);
    }


    @Override
    protected HtmlElement setBodyHeader() {
        return header;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
        header.setSessionId(sessionId);
        aside.setSessionId(sessionId);
        lettersTable.setSessionId(sessionId);
    }
    public void setLetters(List<LetterBoxBunch> list){
        lettersTable.setLetters(list);

    }
}
