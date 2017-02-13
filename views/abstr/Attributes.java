package sb_email.views.abstr;

import java.util.HashMap;

/**
 * Created by Сергей on 07.02.2017.
 */
public class Attributes {
    private HashMap<String, String> attribs = new HashMap<>();

    public void setAttribute (String name, String value){
        attribs.put(name, value);
    }

    public String toString(){
        if (attribs.size()==0) return "";
        StringBuilder sb = new StringBuilder();
        for(String name: attribs.keySet()){
            sb.append(name);
            sb.append(" = \"");
            sb.append(attribs.get(name));
            sb.append("\" ");

        }
        return sb.toString();
    }

}
