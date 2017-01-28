package sb_email.views.abstr;

/**
 * Created by Сергей on 28.01.2017.
 */
public class Message implements Element {

   private String message;
   private String style;

    public Message(String message) {
        this.message = message;
    }



    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {

        if (style!=null){
            return  "<p style = "+style+">"+message+"</p>";
        }

        return "<p>"+message+"</p>";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
