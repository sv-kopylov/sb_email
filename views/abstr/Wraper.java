package sb_email.views.abstr;

/**
 * Created by Сергей on 01.02.2017.
 */
public class Wraper {
    public static String a(String text, String href){
        return "<a href = \""+href+"\">"+text+"</a>";
    }

    public static String p(String text){
        return "<p>"+text+"</p>\r\n";
    }

    public static String div(String text){
            return "<div>"+text+"</div>\r\n";
        }

    public static String h1(String text){
        return "<h1>"+text+"</h1>\r\n";
    }
    public static String h2(String text){
        return "<h2>"+text+"</h2>\r\n";
    }
    public static String h3(String text){
        return "<h3>"+text+"</h3>\r\n";
    }

    public static String br(){
        return "<br>";
    }

    public static String td(String text){
        return "<td>"+text+"</td>";
    }

}
