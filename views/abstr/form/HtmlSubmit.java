package sb_email.views.abstr.form;

/**
 * Created by Сергей on 18.02.2017.
 */
public class HtmlSubmit extends HtmlInput {
    public HtmlSubmit(String buttonName) {
        super("", "", InputType.submit);
        super.removaAttribute("name");
        super.removaAttribute("id");
        super.setAttribute("value",buttonName);
    }
}
