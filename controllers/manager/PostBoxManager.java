package sb_email.controllers.manager;

import sb_email.persist.LetterBoxBunch;
import sb_email.persist.PostBox;
import sb_email.views.conc.PostBoxPage;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Created by Сергей on 06.02.2017.
 */
public class PostBoxManager {

    private PostBoxPage postBoxPage = new PostBoxPage();

    private String sessionId;
    private PostBox postBox;
    private ArrayList<LetterBoxBunch> bunches;
    private Long timeStamp;

    private ArrayList<String> sentLetters;
    private ArrayList<String> receivedLetters;

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

    public Long getTimeStamp() {
        return timeStamp;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostBoxManager that = (PostBoxManager) o;

        return postBox.getLogin().equals(that.postBox.getLogin());
    }


}

