package sb_email.views.abstr.bodyelemants;

import sb_email.views.abstr.Element;
import sb_email.views.abstr.Wraper;

/**
 * Created by Сергей on 02.02.2017.
 */
public class TextElement implements Element {
    private String text;

    public TextElement(String text) {
        this.text = text;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {

            return text;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
