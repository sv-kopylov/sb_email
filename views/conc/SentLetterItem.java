package sb_email.views.conc;

import sb_email.persist.Letter;
import sb_email.views.abstr.form.HtmlForm;
import sb_email.views.abstr.form.HtmlInput;
import sb_email.views.abstr.form.InputType;
import sb_email.views.abstr.layouts.HtmlPlainFormLayout;

/**
 * Created by Сергей on 21.02.2017.
 */
public class SentLetterItem {
    HtmlForm form;
    HtmlInput hidden;
    String content;

    public SentLetterItem(String action) {
        form = new HtmlForm("POST",action);
        form.setLayout(new HtmlPlainFormLayout());
        form.setSubmitComandName("view");
        hidden = new HtmlInput("letterId", InputType.hidden);
        form.addInput(hidden);
     }

    public void setletter(Letter letter){
        hidden.setAttribute("value", Long.toString(letter.getId()));
        content = "To: "+letter.getReceiver()+"\r\n"+"subject: "+letter.getSubject()+" ";
    }


    public String toStrring(){

        return content + form.toString();
    }
}

