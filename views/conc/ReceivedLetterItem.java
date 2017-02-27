package sb_email.views.conc;

import sb_email.persist.Letter;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlHiddenInput;
import sb_email.views.abstr.form.HtmlInput;
import sb_email.views.abstr.form.InputType;
import sb_email.views.abstr.layouts.HtmlPlainFormLayout;

/**
 * Created by Сергей on 21.02.2017.
 */
public class ReceivedLetterItem {
    String action;
    String content;
    String letterId;


    public ReceivedLetterItem(String action, String sessionId) {
        this.action = action + "?"+"sessionId="+sessionId+"&letterId=";
    }

    public void setletter(Letter letter){
        letterId = Long.toString(letter.getId());
        String preview = "";
        if (letter.getBody()!=null) {
            if (letter.getBody().length() < 20) {
                preview = letter.getBody();
            } else {
                preview = letter.getBody().substring(0, 19) + "...";
            }
        }
        content = "From: "+letter.getSender()+", "+"subject: "+letter.getSubject()+", "+preview;
    }

    public String toString(){
        return Wraper.a(content, action+letterId);
    }



}
