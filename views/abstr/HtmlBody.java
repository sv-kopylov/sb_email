package sb_email.views.abstr;

import java.util.ArrayList;

/**
 * Created by Сергей on 03.03.2017.
 */
public class HtmlBody extends HtmlElement {
    HtmlElement bodyHeader;
    HtmlElement dodyAside;
    HtmlElement bodyFooter;

    ArrayList<HtmlElement> bodyContent = new ArrayList<>();

    public HtmlBody() {
        super("body");
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        if(bodyHeader!=null) sb.append(bodyHeader.toString());
        if(dodyAside!=null) sb.append(dodyAside.toString());
            if(bodyContent!=null&&bodyContent.size()>0){
                for(HtmlElement elem:bodyContent){
                    sb.append(elem.toString());
                }
            }
        if(bodyFooter!=null) sb.append(bodyFooter.toString());


        return sb.toString();
    }

    public HtmlElement getBodyHeader() {
        return bodyHeader;
    }

    public void setBodyHeader(HtmlElement bodyHeader) {
        this.bodyHeader = bodyHeader;
    }

    public HtmlElement getDodyAside() {
        return dodyAside;
    }

    public void setDodyAside(HtmlElement dodyAside) {
        this.dodyAside = dodyAside;
    }

    public HtmlElement getBodyFooter() {
        return bodyFooter;
    }

    public void setBodyFooter(HtmlElement bodyFooter) {
        this.bodyFooter = bodyFooter;
    }

    public int addElement(HtmlElement elem){
        bodyContent.add(elem);
        return bodyContent.indexOf(elem);
    }
    public HtmlElement removeElement (int i) {
        HtmlElement result = bodyContent.get(i);
        bodyContent.remove(i);
        return result;
    }
}
