package sb_email.views.abstr.bodyelemants;

import sb_email.views.abstr.Attributes;
import sb_email.views.abstr.Element;

/**
 * Created by Сергей on 07.02.2017.
 */
public class FixedTable implements Element {
    Element cells [][];
    private int rows;
    private int colls;
    private Attributes attributes;

    public FixedTable(int rows, int colls) {
        this.rows = rows;
        this.colls = colls;
        cells = new Element[rows][colls];
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        return null;
    }
}
