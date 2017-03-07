package sb_email.views.conc.reachdesign.pages;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlBody;
import sb_email.views.abstr.HtmlHead;
import sb_email.views.abstr.Page;
import sb_email.views.conc.reachdesign.parts.Notifycation;
import sb_email.views.conc.reachdesign.parts.WelcomeBodyHeader;

/**
 * Created by Сергей on 06.03.2017.
 */
public class P_Welcome extends Page {
    HtmlBody body = new HtmlBody();
    Notifycation info = new Notifycation();
    Notifycation warning = new Notifycation();
    public P_Welcome() {
        super(ViewSettings.grandTytle);
        super.setHead(new HtmlHead(ViewSettings.grandTytle));
        body.setBodyHeader(new WelcomeBodyHeader());
        info.setAttribute("class", "info");
        warning.setAttribute("class","warning");
        body.addElement(warning);
        body.addElement(info);
        super.setBody(body);

    }
    public P_Welcome setWarning(String text){
        warning.setText(text);
        return this;
    }

    public P_Welcome setInfo(String text){
        info.setText(text);
        return this;
    }
}
