package sb_email.views.conc.reachdesign.parts;

import sb_email.ViewSettings;
import sb_email.persist.Relation;
import sb_email.views.abstr.Wraper;
import sb_email.views.abstr.table.Row;

/**
 * Created by Сергей on 24.03.2017.
 */
public class LettersTableHead extends Row {
    private Relation relation;

    public LettersTableHead() {
        setAttribute("class","LettersTableHead");
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        if(relation.equals(Relation.RECEIVED)){
            sb.append(Wraper.td(ViewSettings.fromLetterMark));
        } else if(relation.equals(Relation.SENT)) {
            sb.append(Wraper.td(ViewSettings.toLetterMark));
        }
            sb.append(Wraper.td(ViewSettings.subjectLetterMark));
            sb.append(Wraper.td(""));
            sb.append(Wraper.td(""));
            sb.append(Wraper.td(""));
            sb.append(Wraper.td(""));



        return sb.toString();
    }
}
