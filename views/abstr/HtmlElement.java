package sb_email.views.abstr;

/**
 * Created by Сергей on 15.02.2017.
 */
public abstract class HtmlElement implements Element {
    private String mainTag;
    private Attributes attributes = new Attributes();

    protected HtmlElement(String mainTag) {
        this.mainTag = mainTag;
    }

    protected abstract boolean hasCloseTag();
    protected abstract String content();

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(mainTag);
        if (!attributes.isEmpty()) {
            sb.append(' ');
            sb.append(attributes.toString());
        }
        if (hasCloseTag()) {
            sb.append(">");
            sb.append(content());
            sb.append("<");
            sb.append(mainTag);
        }
        sb.append("/>");
        return sb.toString();
    }

    public String toString(){
        return getElement();
    }

    public void setAttribute(String name, String value){
        attributes.setAttribute(name, value);
    }
}
