package sb_email.views.abstr.table;

import sb_email.views.abstr.HtmlElement;

/**
 * Created by Сергей on 10.03.2017.
 */
public abstract class Row extends HtmlElement {
    protected Row() {
        super("tr");
    }

    @Override
    protected boolean hasCloseTag() {
        return true;
    }


}
