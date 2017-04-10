package sb_email.views.abstr.layouts;

import sb_email.views.abstr.Attributes;
import sb_email.views.abstr.form.HtmlInput;

import java.util.ArrayList;

/**
 * Created by Сергей on 17.02.2017.
 */
public class Html2ColFormLayout implements HtmlFormLayout {


    private Attributes attributes = new Attributes();

    @Override
    public String place(ArrayList<HtmlInput> list) {
        if (list==null||list.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (HtmlInput hi: list){
            sb.append("<p");
            if (!attributes.isEmpty()) {
                sb.append(' ');
                sb.append(attributes.toString());
            }
            sb.append(">");
            sb.append(hi.getLabel());
            sb.append(' ');
            sb.append(hi.toString());
            sb.append("</p>");
        }
        return sb.toString();
    }

    public void setAttribute(String name, String value){
        attributes.setAttribute(name, value);
    }
}
