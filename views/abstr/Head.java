package sb_email.views.abstr;

/**
 * Created by Сергей on 28.01.2017.
 */
public class Head implements Element {
    private String tytle;

    public Head(String tytle) {
        this.tytle = tytle;
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        return "<head>\r\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" +
                "<title>"+tytle+"</title>\r\n" +
                "</head>\r\n";
    }
}
