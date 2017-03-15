package sb_email.views.abstr.layouts;

import sb_email.views.abstr.Attributes;
import sb_email.views.abstr.HtmlElement;
import sb_email.views.abstr.form.HtmlInput;

import java.util.ArrayList;

/**
 * Created by Сергей on 07.03.2017.
 */
public class HtmlTableLayout implements HtmlFormLayout{
    private Attributes attributes = new Attributes();
    @Override
    public String place(ArrayList<HtmlInput> list) {
        if (list==null||list.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("<table");
        if (!attributes.isEmpty()) {
            sb.append(' ');
            sb.append(attributes.toString());
        }
        sb.append(">");
        for (HtmlInput hi: list){
            sb.append("<tr>");
                sb.append("<td>");
                    sb.append(hi.getLabel());
                        sb.append("</td>");
                sb.append("<td>");
                    sb.append(hi.toString());
                         sb.append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        return sb.toString();
    }

    public HtmlTableLayout setAttribute(String name, String value){
        attributes.setAttribute(name, value);
        return this;
    }

    public boolean removaAttribute(String name){
        return attributes.removeAttribute(name);
    }

    public void clearAttributes(){
        attributes.clear();
    }

}
