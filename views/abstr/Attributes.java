package sb_email.views.abstr;

import java.util.HashMap;

/**
 * Created by Сергей on 07.02.2017.
 */
public class Attributes {
    private HashMap<String, String> map = new HashMap<>();

    public void setAttribute(String name, String value){
        map.put(name, value);
    }

    public String getAttribute(String name){
        if (map.get(name)==null){
            return "";
        }
        else{
            return name+" = \""+map.get(name)+"\"";
        }

    }

    public String getAttributePure(String name){
        if (map.get(name)==null){
            return "";
        }
        else{
            return map.get(name);
        }

    }

    public String toString(){
        if (map.isEmpty()) return"";
        StringBuilder sb = new StringBuilder();
        for (String s:map.keySet()){
            sb.append(getAttribute(s));
            sb.append(' ');
        }
        return sb.substring(0, sb.length()-1);
    }

    public boolean isEmpty (){
        return map.isEmpty();
    }

    public boolean removeAttribute(String name){
        if (!map.containsKey(name)) return false;
        map.remove(name);
        return true;
    }

    public void clear(){
        clear();
    }

}
