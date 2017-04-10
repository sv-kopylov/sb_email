package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.persist.Letter;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.conc.reachdesign.parts.HtmlLetterCreateOrViewForm;
import sb_email.views.conc.reachdesign.parts.P_MasterTemplate;
import sb_email.views.conc.reachdesign.parts.PostBoxPageAside;
import sb_email.views.conc.reachdesign.parts.PostBoxPageBodyHeader;

/**
 * Created by Сергей on 28.03.2017.
 */

public class P_Letter extends P_MasterTemplate {

    private String sessionId;
    private PostBoxPageBodyHeader header;
    private PostBoxPageAside aside = new PostBoxPageAside();
    private HtmlLetterCreateOrViewForm form = new HtmlLetterCreateOrViewForm();



    public P_Letter(String sessionId, String tytle) {
        super(ViewSettings.grandTytle);
        this.sessionId = sessionId;
        form.setSessionId(sessionId);
        header = new PostBoxPageBodyHeader(tytle);
        aside.setSessionId(sessionId);
        super.getBody().setDodyAside(aside);
        super.getBody().setBodyHeader(header);
        super.getBody().addElement(form);
    }




    @Override
    protected HtmlElement setBodyHeader() {
        return header;
    }

    public P_Letter setLetterBody(String letterBody) {

        this.form.setLetterBody(letterBody);

        return this;
    }

    public P_Letter setLetter(Letter letter) {
        setReceiver(letter.getReceiver());
        setSubject(letter.getSubject());
        setLetterBody(letter.getBody());

        return this;
    }

    public void setSubject(String subject) {

        this.form.setSubject(subject);

    }

    public void setReceiver(String receiver) {
        this.form.setReceiver(receiver);

    }


}
