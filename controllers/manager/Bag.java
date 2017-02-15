package sb_email.controllers.manager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

/**
 * Created by Сергей on 06.02.2017.
 */
@Component
@Scope("singleton")
public class Bag {
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
    }

    public PostBoxManager getManager (String sessionId){
        return treeMap.get(sessionId);
    }

}
