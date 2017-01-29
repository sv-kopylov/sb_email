package sb_email.views.abstr;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 28.01.2017.
 */
public class Body implements Element {

    BodyHeader bodyHeader;
    BodyFooter bodyFooter;
    BodyAside bodyAside;
    Message message;

    ArrayList<Element> elements =new ArrayList<>();
    public int addElement (Element element) {
             elements.add(element);
             return elements.indexOf(element);
    }


    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public String getElement() {
        StringBuilder sb = new StringBuilder();
        sb.append("<body>\r\n");
        if (message!=null){
            sb.append(message.getElement());
            message=null;
        }
        if (bodyHeader!=null){
            sb.append(bodyHeader.getElement());
        }
        if (bodyAside!=null){
            sb.append(bodyAside.getElement());
        }
        if (bodyFooter!=null){
            sb.append(bodyFooter.getElement());
        }

       if (elements.size()>0){
            for(Element el: elements){
                sb.append(el.getElement());
            }
       }



        sb.append("</body>\r\n");
        return sb.toString();

    }

    public BodyHeader getBodyHeader() {
        return bodyHeader;
    }

    public void setBodyHeader(BodyHeader bodyHeader) {
        this.bodyHeader = bodyHeader;
    }

    public BodyFooter getBodyFooter() {
        return bodyFooter;
    }

    public void setBodyFooter(BodyFooter bodyFooter) {
        this.bodyFooter = bodyFooter;
    }

    public BodyAside getBodyAside() {
        return bodyAside;
    }

    public void setBodyAside(BodyAside bodyAside) {
        this.bodyAside = bodyAside;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
