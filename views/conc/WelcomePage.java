package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.bodyelemants.Message;
import sb_email.views.abstr.Page;

/**
 * Created by Сергей on 28.01.2017.
 */
public class WelcomePage extends Page{
    Message warningMess = new Message("");
    Message infoMess = new Message("");
    Body body = new Body();

    public WelcomePage() {
        super("welcome");
        warningMess.setStyle("color: red; font-size: 2em");
        infoMess.setStyle("color: black; font-size: 2em");
        super.setBody(body);

    }
    public WelcomePage setWarning (String warning){
        warningMess.setMessage(warning);
        body.setMessage(warningMess);
        return this;


    }
    public WelcomePage setInfo (String info){
        infoMess.setMessage(info);
        body.setMessage(infoMess);
        return this;
    }

}
