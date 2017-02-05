package sb_email.views.abstr.form;

import javax.naming.OperationNotSupportedException;

/**
 * Created by Сергей on 01.02.2017.
 */
public class TextInput extends Input {
    private String type;

    public TextInput(String name, TextInputType type) {
        super(name);
        this.type = type.toString();
    }

    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public String getElement() {
        StringBuilder sb = new StringBuilder();
        if (type.equals("textarea")){
            sb.append("<label for = \""+super.getId()+"\">");
            sb.append(super.getLabel());
            sb.append("</label>\r\n");
            sb.append("<textarea id = \""+super.getId()+"\">");
            sb.append("</textarea>\r\n");
        } else {
            sb.append("<label for = \""+super.getId()+"\">");
            sb.append(super.getLabel());
            sb.append("</label>\r\n");
            sb.append("<input id = \""+super.getId()+"\" ");
            sb.append("type = \""+type+"\" ");
            if (super.getPlaseholder()!=null){
                sb.append("placeholder = \""+super.getPlaseholder()+"\" ");
            }
            sb.append("</input>\r\n");

        }



        return sb.toString();
    }

    public String getType(){
        return type.toString();
    }

    @Override
    public void setValue(String value) throws OperationNotSupportedException {
        throw(new OperationNotSupportedException());
    }


}

