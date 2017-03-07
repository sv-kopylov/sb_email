package sb_email.views.abstr;

import java.util.ArrayList;

/**
 * Created by Сергей on 02.03.2017.
 */
public class HtmlHead extends HtmlElement {
    ArrayList<String> items = new ArrayList<>();
    public HtmlHead(String tytle) {
        super("head");
        addItem("<title>"+tytle+"</title>");
    }

    public int addItem (String item){
        items.add(item);
        return items.indexOf(item);
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        for(String s:items){
            sb.append(s);
            sb.append("\r\n");
        }
        return sb.toString();
    }
}
