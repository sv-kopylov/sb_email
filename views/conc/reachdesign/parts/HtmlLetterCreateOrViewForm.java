package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.form.*;

/**
 * Created by Сергей on 07.04.2017.
 */
public class HtmlLetterCreateOrViewForm extends HtmlElement {

    private HtmlInput receiver = new HtmlInput("receiver", ViewSettings.receiverInput, InputType.text);
    private HtmlInput subject = new HtmlInput("subject", ViewSettings.subjectInput, InputType.text);
    private HtmlHiddenInput hiddenInput = new HtmlHiddenInput("sessionId");
    private HtmlTextArea letterBody = new HtmlTextArea("letterBody");
    private HtmlSubmit submitButton = new HtmlSubmit(ViewSettings.sendLetterButtonName);

    public HtmlLetterCreateOrViewForm() {
        super("form");
        setAttribute("method", "POST");
        letterBody.setAttribute("class", "letterBodyArea");
        receiver.setAttribute("class", "inputText");
        subject.setAttribute("class", "inputText");
    }

    public void setSessionId(String sessionId) {
        hiddenInput.setAttribute("value", sessionId);
    }

    public void setAction(String action) {
        setAttribute("action", action);
    }

    public void setReceiver(String receiver) {
        this.receiver.setAttribute("value", receiver);

    }

    public void setLetterBody(String letterBody) {

        this.letterBody.setValue(letterBody);


    }

    public void setSubject(String subject) {

        this.subject.setAttribute("value", subject);

    }


    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        sb.append("<table class = \"sendLetterForm\">");
        sb.append(Wraper.tr(
                "<td class = \"leftColumn\">" +
                        ViewSettings.receiverInput +
                        "</td>" +
                        "<td class = \"rightColumn\">" +
                        receiver.toString() +
                        "</td>"));

        sb.append(Wraper.tr(
                "<td class = \"leftColumn\">" +
                        ViewSettings.subjectInput +
                        "</td>" +
                        "<td class = \"rightColumn\">" +
                        subject.toString() +
                        "</td>"));

        sb.append(Wraper.tr(
                "<td class = \"leftColumn\"></td>" +
                        "<td id = \"letterBodyCell\">" +
                        letterBody.toString() +
                        "</td>"));

        sb.append(hiddenInput.toString());


        sb.append("</table>");
        sb.append(submitButton.toString());
        return sb.toString();
    }
}
