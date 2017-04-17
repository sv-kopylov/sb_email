package sb_email.views.abstr.form;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 16.02.2017.
 */
public class HtmlTextArea extends HtmlElement {
    String value = "";
    public HtmlTextArea(String name) {
        super("textarea");
        setAttribute("name",name);
    }
    @Override
    protected boolean hasCloseTag() {
        return true;
    }



    @Override
    protected String content() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
