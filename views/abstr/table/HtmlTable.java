package sb_email.views.abstr.table;

import sb_email.views.abstr.HtmlElement;

import java.util.ArrayList;

/**
 * Created by Сергей on 10.03.2017.
 */
public class HtmlTable extends HtmlElement {
    ArrayList<Row> rows = new ArrayList<>();
    public HtmlTable() {
        super("table");
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }

    @Override
    protected String content() {
        StringBuilder sb = new StringBuilder();
        for(Row row: rows){
            sb.append(row.toString());
        }

        return sb.toString();
    }

    public int addRow(Row row){
        rows.add(row);
        return rows.indexOf(row);
    }

    public void clear(){
        rows.clear();
    }

}
