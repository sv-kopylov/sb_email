package sb_email.views.conc.reachdesign.parts;

import sb_email.views.abstr.HtmlHead;

/**
 * Created by Сергей on 02.03.2017.
 */
public class Headtemplate extends HtmlHead {
    public Headtemplate() {
        super("sb_email");
        super.addItem("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
    }
}
