package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.persist.Letter;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.form.*;
import sb_email.views.abstr.layouts.HtmlTableLayout;
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
    private HtmlForm form = new HtmlForm("POST", ViewSettings.sendLetterAction);

    private HtmlTextArea letterBody;
    private HtmlInput receiver = new HtmlInput("receiver", ViewSettings.receiverInput, InputType.text);
    private HtmlInput subject = new HtmlInput("subject", ViewSettings.subjectInput, InputType.text);
    private HtmlHiddenInput hiddenInput = new HtmlHiddenInput("sessionId");

    public P_Letter(String sessionId, String tytle) {
        super(ViewSettings.grandTytle);
        this.sessionId = sessionId;
        form.setAttribute("class", "sendLetterForm");
        form.setLayout(new HtmlTableLayout());
        form.addInput(receiver);
        form.addInput(new HtmlInput("subject", ViewSettings.subjectInput, InputType.text));
        letterBody = new HtmlTextArea("letterBody");
        letterBody.setAttribute("class", "letterBodyArea");
        form.addElement(letterBody);
        hiddenInput.setAttribute("value", sessionId);
        form.addInput(hiddenInput);
        form.setSubmitComandName(ViewSettings.sendLetterButtonName);

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

        this.letterBody.setValue(letterBody);

        return this;
    }

    public P_Letter setletter(Letter letter) {
        setReceiver(letter.getReceiver());
        setSubject(letter.getSubject());
        setLetterBody(letter.getBody());

        return this;
    }

    public void setSubject(String subject) {

        this.subject.setAttribute("value", subject);

    }

    public void setReceiver(String receiver) {
        this.receiver.setAttribute("value", receiver);

    }
}
