package sb_email.views.abstr.form;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 16.02.2017.
 */
public class HtmlTextArea extends HtmlElement {
     String value = "";
    protected HtmlTextArea() {
        super("textarea");
    }

    @Override
    protected boolean hasCloseTag() {
        return false;
    }

    @Override
    protected String content() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
