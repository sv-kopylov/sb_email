package sb_email.views.abstr.form;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 15.02.2017.
 */
public class HtmlInput extends HtmlElement {
    private String label;
    public HtmlInput(String id, String label, InputType type) {
        super("input");
        super.setAttribute("type", type.toString());
        super.setAttribute("name", id);
        super.setAttribute("id", id);
        this.label = label;
    }

    @Override
    protected boolean hasCloseTag() {
        return false;
    }

    @Override
    protected String content() {
        return "";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
