package sb_email.views.abstr.bodyelemants;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 27.02.2017.
 */
public class HtmlA extends HtmlElement {
    private String content;
    private String action;
    public HtmlA(String content) {
        super("a");
        this.content = content;
      }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        return content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
        super.setAttribute("href", action);
    }
}
