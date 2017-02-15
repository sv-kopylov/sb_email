package sb_email.views.abstr;

/**
 * Created by Сергей on 15.02.2017.
 */
public abstract class HtmlElement implements Element {
    private String mainTag;
    public abstract boolean isCloses();


    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        return null;
    }
}
