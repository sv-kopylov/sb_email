package sb_email.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import sb_email.dao.LettersBoxBunchDao;
import sb_email.persist.Letter;
import sb_email.persist.LetterBoxBunch;
import sb_email.persist.PostBox;
import sb_email.persist.Relation;
import sb_email.views.conc.PostBoxPage;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Сергей on 06.02.2017.
 */
public class PostBoxManager {



    private PostBoxPage postBoxPage = new PostBoxPage();

    private String sessionId;
    private PostBox postBox;
    private Long timeStamp;
    private List<LetterBoxBunch> bunches;


    public PostBoxManager(String sessionId, PostBox postBox) {
        this.sessionId = sessionId;
        this.postBox = postBox;
        postBoxPage.setSessionId(sessionId);
        setTimeStamp();

    }

    public String getSessionId() {
        setTimeStamp();
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setTimeStamp() {
        timeStamp = GregorianCalendar.getInstance().getTimeInMillis();
    }

    public PostBoxPage getPostBoxPage(){
        postBoxPage.setSessionId(sessionId);
        setTimeStamp();
        return postBoxPage;
    }

    public PostBox getPostBox(){
        setTimeStamp();
        return postBox;
    }

    private boolean setSentLetters(LettersBoxBunchDao lettersBoxBunchDao){
        bunches = lettersBoxBunchDao.findByPostBox(postBox);
        if (bunches!=null&&bunches.size()>0){
            ArrayList<Letter> sentLetters = new ArrayList<>();
            for (LetterBoxBunch b: bunches){
                if (b.getRelation().equals(Relation.SENT)){
                    sentLetters.add(b.getLetter());
                }
            }
            if(sentLetters.size()>0){
                postBoxPage.setSentLetters(sentLetters);
                return true;
            }
        }
        return false;
    };

    public boolean setReceivedLetters(LettersBoxBunchDao lettersBoxBunchDao) {
        bunches = lettersBoxBunchDao.findByPostBox(postBox);
        if (bunches!=null&&bunches.size()>0){
            ArrayList<Letter> receivedLetters = new ArrayList<>();
            for (LetterBoxBunch b: bunches){
                if (b.getRelation().equals(Relation.RECEIVED)){
                    receivedLetters.add(b.getLetter());
                }
            }

            if(receivedLetters.size()>0){
                postBoxPage.setReceivedLetters(receivedLetters, sessionId);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostBoxManager that = (PostBoxManager) o;

        return postBox.getLogin().equals(that.postBox.getLogin());
    }

    public PostBoxPage showSent(){


        return postBoxPage;

    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}

