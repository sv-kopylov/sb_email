package sb_email.controllers.manager;

import org.springframework.beans.factory.annotation.Autowired;
import sb_email.ViewSettings;
import sb_email.dao.LettersBoxBunchDao;
import sb_email.persist.Letter;
import sb_email.persist.LetterBoxBunch;
import sb_email.persist.PostBox;
import sb_email.persist.Relation;
import sb_email.views.conc.PostBoxPage;
import sb_email.views.conc.reachdesign.pages.P_PostBox;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Сергей on 06.02.2017.
 */
public class PostBoxManager {


    private P_PostBox postBoxPage;

    private String sessionId;
    private PostBox postBox;
    private Long timeStamp;
    private List<LetterBoxBunch> bunches;


    public PostBoxManager(String sessionId, PostBox postBox) {
        this.sessionId = sessionId;
        this.postBox = postBox;
        postBoxPage = new P_PostBox(postBox.getTytle());
        postBoxPage.setSessionId(sessionId);
        setTimeStamp();

    }

    public String getSessionId() {
        setTimeStamp();
        return sessionId;
    }

    public void setTimeStamp() {
        timeStamp = GregorianCalendar.getInstance().getTimeInMillis();
    }

    public P_PostBox getPostBoxPage() {
        setTimeStamp();
        return postBoxPage;
    }

    public PostBox getPostBox() {
        setTimeStamp();
        return postBox;
    }

    public boolean setSentLetters(LettersBoxBunchDao lettersBoxBunchDao) {
        bunches = lettersBoxBunchDao.findByPostBox(postBox);
        ArrayList <LetterBoxBunch> sentLetBunches = new ArrayList<>();
        if (bunches == null && bunches.isEmpty()) {
            postBoxPage.setInfo(ViewSettings.noLettersFound);
            return false;
        }
        for(int i = bunches.size()-1; i >=0; i--) {
            if (bunches.get(i).getRelation().equals(Relation.SENT)) {
                sentLetBunches.add(bunches.get(i));
            }
        }
        if (sentLetBunches.isEmpty()) {
            postBoxPage.setInfo(ViewSettings.noLettersFound);
            return false;
        }
        postBoxPage.setLetters(sentLetBunches);
        return true;
    }

    public boolean setReceivedLetters(LettersBoxBunchDao lettersBoxBunchDao) {
        bunches = lettersBoxBunchDao.findByPostBox(postBox);
        ArrayList <LetterBoxBunch> receivedLetBunches = new ArrayList<>();
        if (bunches == null && bunches.isEmpty()) {
            postBoxPage.setInfo(ViewSettings.noLettersFound);
            return false;
        }
        for (int i = bunches.size()-1; i >=0; i--) {
            if (bunches.get(i).getRelation().equals(Relation.RECEIVED)) {
                receivedLetBunches.add(bunches.get(i));
            }
        }
        if (receivedLetBunches.isEmpty()) {
            postBoxPage.setInfo(ViewSettings.noLettersFound);
            return false;
        }
        postBoxPage.setLetters(receivedLetBunches);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostBoxManager that = (PostBoxManager) o;

        return postBox.getLogin().equals(that.postBox.getLogin());
    }

    public P_PostBox showSent() {
        return postBoxPage;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }
}

