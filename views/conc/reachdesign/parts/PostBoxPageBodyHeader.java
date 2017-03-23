package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlHiddenInput;

/**
 * Created by Сергей on 03.03.2017.
 */
public class PostBoxPageBodyHeader extends HtmlElement {
    private HtmlForm logoutForm;
    private String tytle;
    private HtmlHiddenInput sessionIdHidden = new HtmlHiddenInput("sessionId");


    public PostBoxPageBodyHeader(String tytle) {
        super("header");
        this.tytle = tytle;
        logoutForm = new HtmlForm("POST", ViewSettings.logoutFormAction);
        logoutForm.addInput(sessionIdHidden);
        logoutForm.setAction(ViewSettings.logoutFormAction);
        logoutForm.setSubmitComandName(ViewSettings.logoutButtonName);
//        logoutForm.setAttribute();
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        sb.append(Wraper.h1(tytle));

        sb.append(Wraper.div(logoutForm.toString(), "logout"));
         return sb.toString();

    }

    public void setSessionId(String sessionId){
        sessionIdHidden.setAttribute("value", sessionId);
    }


}
