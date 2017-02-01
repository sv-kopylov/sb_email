package sb_email.views.abstr.bodyelemants;

import sb_email.views.abstr.Element;

import java.util.ArrayList;

/**
 * Created by Сергей on 30.01.2017.
 */
public class Section implements Element {

    private String style;
    private ArrayList<Element> elements = new ArrayList<>();



    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public String getElement() {
        StringBuilder sb = new StringBuilder();
        if (elements.size()>0){
            sb.append("<section");
            if(style!=null) {
                sb.append(" style = \"" + style + "\"");
            }
            sb.append(">\r\n");
            for (Element e: elements){
                sb.append(e.getElement());
            }
            sb.append("</section>\r\n");
            return sb.toString();

        }
        return "";
    }
    public int addElement (Element element){
        elements.add(element);
        return elements.indexOf(element);
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

}
