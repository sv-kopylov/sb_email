package sb_email.controllers.manager;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by Сергей on 09.02.2017.
 */
public class IdGen {
    public static String getId(String login){
        StringBuilder sb = new StringBuilder();
        sb.append(login);
        Random rnd = new Random(GregorianCalendar.getInstance().getTimeInMillis());
        for (int i=0; i<4; i++) {
            sb.append(Integer.toHexString(rnd.nextInt(16)));
        }
        return sb.toString();
    }
}
