package sb_email.views.abstr;

/**
 * Created by Сергей on 27.01.2017.
 */
public abstract class Page {

    private Element head;
    private Element body;
    private String tytle = "";

    public Page() {
    }
    public Page(String tytle) {
        this.tytle = tytle;
    }

    public String getPage(){
        StringBuilder sb = new StringBuilder();
         sb.append("<!DOCTYPE HTML>");
         sb.append("\r\n");
         sb.append("<html>\r\n");

         if (head==null){
             head = new Head(tytle);
         }
        sb.append(head.getElement());

         if (body!=null){
            sb.append(body.getElement());
        }
        sb.append("</html>");





         sb.append("</html>");
        return sb.toString();
    }

    public Element getHead() {
        return head;
    }

    public void setHead(Element head) {
        this.head = head;
    }

    public Element getBody() {
        return body;
    }

    public void setBody(Element body) {
        this.body = body;
    }

    public String getTytle() {
        return tytle;
    }

    public void setTytle(String tytle) {
        this.tytle = tytle;
    }
}
