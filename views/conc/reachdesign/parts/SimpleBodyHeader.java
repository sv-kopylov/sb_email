package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.Wraper;

/**
 * Created by Сергей on 08.03.2017.
 */
public class SimpleBodyHeader extends HtmlElement {
    public SimpleBodyHeader() {
        super("header");
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        return Wraper.h1(ViewSettings.grandTytle);
      }
}
