package sb_email.controllers.manager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.GregorianCalendar;
import java.util.TreeMap;

/**
 * Created by Сергей on 11.04.2017.
 */
@Component
public class BagCleaner {
    private static Logger logger = Logger.getLogger(BagCleaner.class);
    @Autowired
    Bag bag;
    private Long TIMEOUT_MILLS;
    @Value("${my.timeoutMin}")
    private String timeoutString;

    @Scheduled(fixedRate = 60000l)
    public void cleanBag(){
        TIMEOUT_MILLS = Long.parseLong(timeoutString)*60000;
        logger.info("Bag cleaning is started, timeout " + timeoutString);
        TreeMap<String, PostBoxManager> allManagers = bag.getAllManagersMap();
        Long nowTime = GregorianCalendar.getInstance().getTimeInMillis();
        for(String key: allManagers.keySet()){
            if(nowTime - allManagers.get(key).getTimeStamp()>TIMEOUT_MILLS){
                logger.info("session of "+bag.getManager(key).getPostBox().getName()+" removed");
                bag.removeManager(key);
            }
        }

    }

}
