package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlBody;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.form.*;
import sb_email.views.abstr.layouts.HtmlTableLayout;
import sb_email.views.conc.reachdesign.parts.Notifycation;
import sb_email.views.conc.reachdesign.parts.PostBoxPageBodyHeader;
import sb_email.views.conc.reachdesign.parts.P_MasterTemplate;
import sb_email.views.conc.reachdesign.parts.SimpleBodyHeader;

/**
 * Created by Сергей on 08.03.2017.
 */
public class P_CreatingBox extends P_MasterTemplate {


    public P_CreatingBox() {
        super(ViewSettings.grandTytle);
        HtmlForm form = new HtmlForm("POST", ViewSettings.createBoxFormAction);
        form.addInput(new HtmlInput("name",ViewSettings.nameInput, InputType.text));
        form.addInput(new HtmlInput("login",ViewSettings.loginInput, InputType.text));
        form.addInput(new HtmlInput("password", ViewSettings.passwordInput, InputType.text));
        form.setSubmitComandName(ViewSettings.createBoxButtonName);
        form.setLayout(new HtmlTableLayout());
        getBody().addElement(form);
    }

    @Override
    protected HtmlElement setBodyHeader() {
        return new SimpleBodyHeader();
    }
}
