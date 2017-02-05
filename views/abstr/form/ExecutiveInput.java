package sb_email.views.abstr.form;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Сергей on 01.02.2017.
 */
public class ExecutiveInput extends Input {
    private String type;

    public ExecutiveInput(String value, ExecutiveInputType type) {
        super(value);
        try {
            super.setValue(value);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }
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
        if (super.getValue()!=null){
            sb.append("value = \"");
            sb.append(super.getValue());
            sb.append("\"");
        }

        sb.append(">\r\n");
        return sb.toString();
    }
}
