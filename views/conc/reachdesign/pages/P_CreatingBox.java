package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlBody;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.form.*;
import sb_email.views.abstr.layouts.HtmlTableLayout;
import sb_email.views.conc.reachdesign.parts.*;

/**
 * Created by Сергей on 08.03.2017.
 */
public class P_CreatingBox extends P_MasterTemplate {
private CreatingBoxAside creatingBoxAside;

    public P_CreatingBox() {
        super(ViewSettings.grandTytle);
       creatingBoxAside = new CreatingBoxAside();
        getBody().setDodyAside(creatingBoxAside);
    }

    @Override
    protected HtmlElement setBodyHeader() {
        return new SimpleBodyHeader();
    }
}
