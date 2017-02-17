package sb_email.views.abstr.layouts;

import sb_email.views.abstr.form.HtmlInput;

import java.util.ArrayList;

/**
 * Created by Сергей on 17.02.2017.
 */
public class Html2ColFormLayout implements HtmlFormLayout {
    @Override
    public String place(ArrayList<HtmlInput> list) {
        if (list==null||list.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (HtmlInput hi: list){
            sb.append(hi.getLabel());
            sb.append(' ');
            sb.append(hi.toString());
            sb.append("<br>");
        }
        return sb.toString();
    }
}
