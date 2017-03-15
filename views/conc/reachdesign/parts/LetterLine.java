package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.persist.LetterBoxBunch;
import sb_email.persist.Relation;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.table.Row;

/**
 * Created by Сергей on 14.03.2017.
 */
public class LetterLine extends Row {
    private LetterBoxBunch letterBoxBunch;
    private String viewAction;
    private String deleteAction;

    public LetterLine(LetterBoxBunch letterBoxBunch, String sessionId) {
        this.letterBoxBunch = letterBoxBunch;
        viewAction = ViewSettings.viewLetterAction + "?"+"sessionId="+sessionId+"&letterId=";
        deleteAction = ViewSettings.deleteLetterAction + "?"+"sessionId="+sessionId+"&letterId=";
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        if(letterBoxBunch.getRelation().equals(Relation.RECEIVED)){
            sb.append(Wraper.td(ViewSettings.fromLetterMark));
            sb.append(Wraper.td(letterBoxBunch.getPostBox().getName()+" ("+letterBoxBunch.getPostBox().getLogin()+")"));
            sb.append(Wraper.td(ViewSettings.subjectLetterMark));
        } else if (letterBoxBunch.getRelation().equals(Relation.SENT)){
            sb.append(Wraper.td(ViewSettings.toLetterMark));
        }

        return sb.toString();
    }
}
