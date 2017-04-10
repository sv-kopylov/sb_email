package sb_email.controllers.manager;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

/**
 * Created by Сергей on 06.02.2017.
 */
@Component
@Scope("singleton")
public class Bag {
    Logger logger = Logger.getLogger(Bag.class);
    private TreeMap<String, PostBoxManager> treeMap = new TreeMap<>();

    public void addManager (PostBoxManager manager){
        PostBoxManager jocker;
        for (PostBoxManager pbm: treeMap.values()){
            if (pbm.equals(manager)){
                treeMap.remove(pbm.getSessionId());
                break;
            }
        }
        treeMap.put(manager.getSessionId(), manager);
        logger.info("muanager puted sessionId: "+manager.getSessionId());
    }

    public PostBoxManager getManager (String sessionId){
        logger.info("request for manager");
        return treeMap.get(sessionId);
    }

    public void removeManager(String sessionId){
        treeMap.remove(sessionId);
    }

}
