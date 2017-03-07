package sb_email.views.conc.reachdesign.parts;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 06.03.2017.
 */
public class Notifycation extends HtmlElement {
    private String text;
    public Notifycation() {
        super("div");
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        if(text==null) return "";
        String s = text;
        text = null;
        return s;
    }

    public void setText(String text) {
        this.text = text;
    }
}
