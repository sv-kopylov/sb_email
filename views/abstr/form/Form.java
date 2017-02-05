package sb_email.views.abstr.form;

import sb_email.views.abstr.Element;

import java.util.ArrayList;

/**
 * Created by Сергей on 30.01.2017.
 */
public class Form implements Element {
    private String action;
    private String method;
    private ArrayList<Input> elements = new ArrayList<>();

    public Form(String method) {
        this.method = method;
    }

    public int addInput(Input element){
        elements.add(element);
        return elements.indexOf(element);
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        if (action == null || method == null || elements == null) return "";
        if (elements.size() == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("<form action=\"" + action + "\" method=\"" + method + "\">\r\n");
        for (Element e : elements) {
            sb.append(e.getElement());
        }
        sb.append("</form>\r\n");

        return sb.toString();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public ArrayList<Input> getElements() {
        return elements;
    }


}
