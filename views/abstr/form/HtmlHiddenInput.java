package sb_email.views.abstr.form;

/**
 * Created by Сергей on 24.02.2017.
 */
public class HtmlHiddenInput extends HtmlInput{
    public HtmlHiddenInput(String name) {
        super(name, InputType.hidden);
        super.removaAttribute("id");
        super.setLabel("");
    }
}
