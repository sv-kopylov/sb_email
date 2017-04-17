package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.bodyelemants.HtmlA;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlInput;
import sb_email.views.abstr.form.InputType;
import sb_email.views.abstr.layouts.HtmlTableLayout;

/**
 * Created by Сергей on 03.03.2017.
 */
public class WelcomeBodyHeader extends HtmlElement {

    HtmlForm loginForm;
    HtmlA linkToCreate;

    public WelcomeBodyHeader() {
        super("header");
        loginForm = new HtmlForm("POST", ViewSettings.loginFormAction);
        loginForm.setLayout(new HtmlTableLayout());
        loginForm.addInput(new HtmlInput("login",ViewSettings.loginInput, InputType.text));
        loginForm.addInput(new HtmlInput("password",ViewSettings.passwordInput, InputType.text));
        loginForm.setSubmitComandName(ViewSettings.loginButtonName);
        linkToCreate = new HtmlA(ViewSettings.createPostBoxLink);
        linkToCreate.setAction(ViewSettings.linkToCreate);
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        sb.append(Wraper.h1(ViewSettings.grandTytle));
        sb.append(loginForm.toString());
        sb.append(Wraper.p(linkToCreate.toString()));
        return sb.toString();
    }
}
