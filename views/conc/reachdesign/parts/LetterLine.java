package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.persist.LetterBoxBunch;
import sb_email.persist.Relation;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.table.Row;

import java.text.SimpleDateFormat;

/**
 * Created by Сергей on 14.03.2017.
 */
public class LetterLine extends Row {
    private final int previewLenght = 40;
    private LetterBoxBunch letterBoxBunch;
    private String viewAction;
    private String deleteAction;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");

    public LetterLine(LetterBoxBunch letterBoxBunch, String sessionId) {
        this.letterBoxBunch = letterBoxBunch;
        viewAction = ViewSettings.viewLetterAction + "?"+"sessionId="+sessionId+"&letterId="+Long.toString(letterBoxBunch.getLetter().getId());
        deleteAction = ViewSettings.deleteLetterAction + "?"+"sessionId="+sessionId+"&letterId="+Long.toString(letterBoxBunch.getLetter().getId());
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        if(letterBoxBunch.getRelation().equals(Relation.RECEIVED)){

//            sb.append(Wraper.td(ViewSettings.fromLetterMark));
            sb.append(Wraper.td(letterBoxBunch.getLetter().getSender()));
//            sb.append(Wraper.td(ViewSettings.subjectLetterMark));
            sb.append(Wraper.td(letterBoxBunch.getLetter().getSubject()));
            sb.append(Wraper.td(preview()));
            sb.append(Wraper.td(dateFormat.format(letterBoxBunch.getDate())));
            sb.append(Wraper.td(Wraper.a(ViewSettings.viewLetterLink,viewAction)));
            sb.append(Wraper.td(Wraper.a(ViewSettings.deleteLetterLink, deleteAction)));


        } else if (letterBoxBunch.getRelation().equals(Relation.SENT)){

//            sb.append(Wraper.td(ViewSettings.toLetterMark));
            sb.append(Wraper.td(letterBoxBunch.getLetter().getReceiver()));
//            sb.append(Wraper.td(ViewSettings.subjectLetterMark));
            sb.append(Wraper.td(letterBoxBunch.getLetter().getSubject()));
            sb.append(Wraper.td(preview()));
            sb.append(Wraper.td(dateFormat.format(letterBoxBunch.getDate())));
            sb.append(Wraper.td(Wraper.a(ViewSettings.viewLetterLink,viewAction)));
            sb.append(Wraper.td(Wraper.a(ViewSettings.deleteLetterLink, deleteAction)));
        }

        return sb.toString();
    }

    private String preview(){

        String prev = "";
        if (letterBoxBunch.getLetter().getBody()!=null) {
            if (letterBoxBunch.getLetter().getBody().length() < previewLenght) {
                prev = letterBoxBunch.getLetter().getBody();
            } else {
                prev = letterBoxBunch.getLetter().getBody().substring(0, previewLenght-1) + "...";
            }
        }
        return prev;
    }
}
