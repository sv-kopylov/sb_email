package sb_email.views.conc.reachdesign.parts;

import sb_email.persist.LetterBoxBunch;
import sb_email.views.abstr.table.HtmlTable;

import java.util.List;

/**
 * Created by Сергей on 15.03.2017.
 */
public class LettersTable extends HtmlTable{

    private String sessionId;
    private LettersTableHead tableHead = new LettersTableHead();

    public LettersTable() {
        setAttribute("class", "LettersTable");
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setLetters(List<LetterBoxBunch> letters){
        clear();
        if(letters==null||letters.size()==0||sessionId==null){
            return;
        }

        tableHead.setRelation(letters.get(0).getRelation());
        this.addRow(tableHead);
        LetterLine letterLine;
        for (LetterBoxBunch lbb: letters){
            letterLine = new LetterLine(lbb, sessionId);
            this.addRow(letterLine);
        }
    }


}
