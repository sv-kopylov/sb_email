package sb_email.views.abstr.form;

import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.layouts.HtmlFormLayout;
import sb_email.views.abstr.layouts.HtmlPlainFormLayout;

import java.util.ArrayList;

/**
 * Created by Сергей on 16.02.2017.
 */
public class HtmlForm extends HtmlElement {
    private ArrayList<HtmlInput> inputs = new ArrayList<>();
    private ArrayList<HtmlElement> elements = new ArrayList<>();
    private HtmlSubmit submitButton = new HtmlSubmit("submit");
    private HtmlFormLayout layout = new HtmlPlainFormLayout();

    public HtmlForm(String method, String action) {
        super("form");
        super.setAttribute("method", method);
        super.setAttribute("action", action);

    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        if (!inputs.isEmpty()){
            sb.append(layout.place(inputs));
        }
        if (!elements.isEmpty()){
            for(HtmlElement element:elements){
                sb.append(element.toString());
            }
        }
        sb.append(submitButton.toString());
        return sb.toString();
    }

    public void setAction(String action) {
        super.setAttribute("action", action);
    }
    public void setSubmitComandName(String submitComandName) {
        submitButton.setAttribute("value", submitComandName);
    }

    public void setLayout(HtmlFormLayout layout) {
        this.layout = layout;
    }

    public int addInput(HtmlInput input){
        inputs.add(input);
        return inputs.indexOf(input);
    }
    public int addElement(HtmlElement elem){
        elements.add(elem);
        return elements.indexOf(elem);
    }
}

