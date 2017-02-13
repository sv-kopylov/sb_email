package sb_email.views.abstr.form;



/**
 * Created by Сергей on 01.02.2017.
 */
public class ExecutiveInput extends Input {
    private String type;

    public ExecutiveInput(String value, ExecutiveInputType type) {
        super(value);

            super.setValue(value);

        this.type = type.toString();
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        StringBuilder sb = new StringBuilder();
        sb.append("<input type = \"");
        sb.append(type);
        sb.append("\"");
        sb.append(super.getValue());
        sb.append(">\r\n");
        return sb.toString();
    }
}
