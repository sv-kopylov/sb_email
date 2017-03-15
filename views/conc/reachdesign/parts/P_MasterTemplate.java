package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlBody;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.HtmlHead;
import sb_email.views.abstr.Page;
import sb_email.views.conc.reachdesign.pages.P_Welcome;

/**
 * Created by Сергей on 08.03.2017.
 */
public abstract class P_MasterTemplate extends Page {
    private HtmlBody body = new HtmlBody();
    private Notifycation info = new Notifycation();
    private Notifycation warning = new Notifycation();
    public P_MasterTemplate(String tytle) {
        super(tytle);
        super.setHead(new HtmlHead(tytle));
        body.setBodyHeader(setBodyHeader());
        info.setAttribute("class", "info");
        warning.setAttribute("class","warning");
        body.addElement(warning);
        body.addElement(info);
        super.setBody(body);

    }

    protected abstract HtmlElement setBodyHeader();

    public P_MasterTemplate setWarning(String text){
        warning.setText(text);
        return this;
    }

    public P_MasterTemplate setInfo(String text){
        info.setText(text);
        return this;
    }

    public HtmlBody getBody(){
        return body;
    }

}
