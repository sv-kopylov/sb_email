package sb_email.views.abstr.bodyelemants;

import sb_email.views.abstr.HtmlElement;

import java.util.ArrayList;

/**
 * Created by Сергей on 20.02.2017.
 */
public class HtmlUnorderedList extends HtmlElement {

    ArrayList<String> elements = new ArrayList<>();
    public HtmlUnorderedList() {
        super("ul");
    }

    public void addElement (String element){
        elements.add(element);
    }

    public ArrayList<String> getElements() {
        return elements;
    }

    public void setElements(ArrayList<String> elements) {
        this.elements = elements;
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        if (elements==null||elements.size()==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(String el: elements){
            sb.append("<li>");
            sb.append(el);
            sb.append("</li>");
        }
        return sb.toString();
    }

    public void clear(){
        elements.clear();
    }
}
