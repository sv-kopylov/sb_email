package sb_email.views.abstr.form;

/**
 * Created by Сергей on 07.02.2017.
 */
public class HiddenInput extends Input {

    public HiddenInput(String name) {
        super(name);
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        if (super.getValue()==null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append("<input type=\"hidden\" name=\"");
        sb.append(super.getName());
        sb.append("\" value=\"");
        sb.append(super.getValue());
        sb.append("\">\r\n");
        return sb.toString();
    }
}
