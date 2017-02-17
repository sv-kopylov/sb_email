package sb_email.views.abstr.form;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 15.02.2017.
 */
public class HtmlInput extends HtmlElement {
    private String label;
    public HtmlInput(String name, InputType type) {
        super("input");
        super.setAttribute("type", type.toString());
        super.setAttribute("name", name);
        super.setAttribute("id", name);
        label = name;
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
