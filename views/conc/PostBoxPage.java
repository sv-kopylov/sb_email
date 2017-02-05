package sb_email.views.conc;

import sb_email.views.abstr.Body;
import sb_email.views.abstr.Page;
import sb_email.views.abstr.bodyelemants.Message;

/**
 * Created by Сергей on 03.02.2017.
 */
public class PostBoxPage extends Page {
    Body body = new Body();
    Message mess = new Message("You successfyly create post box, or logined in it");

    public PostBoxPage (){
        super("YourPostbox");
        body.addElement(mess);
        super.setBody(body);
    }
}
