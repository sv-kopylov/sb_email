package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlHiddenInput;

/**
 * Created by Сергей on 03.03.2017.
 */
public class OtherPagesBodyHeader extends HtmlElement {
    HtmlForm logoutForm;
    HtmlHiddenInput sessionIdHidden = new HtmlHiddenInput("sessionId");
    private String userName;

    public OtherPagesBodyHeader() {
        super("header");
        logoutForm = new HtmlForm("POST", ViewSettings.logoutFormAction);
        logoutForm.addInput(sessionIdHidden);
        logoutForm.setAction(ViewSettings.logoutFormAction);
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        sb.append(Wraper.h1(ViewSettings.grandTytle));
        sb.append(Wraper.br());
        if(userName!=null) sb.append(Wraper.h2(userName));
        return sb.toString();

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSessionId(String sessionId){
        sessionIdHidden.setAttribute("value", sessionId);
    }


}
