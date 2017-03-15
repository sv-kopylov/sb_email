package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlBody;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.HtmlHead;
import sb_email.views.abstr.Page;
import sb_email.views.conc.reachdesign.parts.Notifycation;
import sb_email.views.conc.reachdesign.parts.P_MasterTemplate;
import sb_email.views.conc.reachdesign.parts.WelcomeBodyHeader;

/**
 * Created by Сергей on 06.03.2017.
 */
public class P_Welcome extends P_MasterTemplate {



    public P_Welcome() {
        super(ViewSettings.grandTytle);
    }

    @Override
    protected HtmlElement setBodyHeader() {
        return new WelcomeBodyHeader();
    }
}
