package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlInput;
import sb_email.views.abstr.form.InputType;
import sb_email.views.abstr.layouts.HtmlTableLayout;

/**
 * Created by Сергей on 28.03.2017.
 */
public class CreatingBoxAside extends HtmlElement {
    HtmlForm form;

    public CreatingBoxAside() {
        super("aside");
        form = new HtmlForm("POST", ViewSettings.createBoxFormAction);
        form.addInput(new HtmlInput("name",ViewSettings.nameInput, InputType.text));
        form.addInput(new HtmlInput("login",ViewSettings.loginInput, InputType.text));
        form.addInput(new HtmlInput("password", ViewSettings.passwordInput, InputType.text));
        form.setSubmitComandName(ViewSettings.createBoxButtonName);
        form.setLayout(new HtmlTableLayout());
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        sb.append(form.toString());
        return sb.toString();
    }
}
