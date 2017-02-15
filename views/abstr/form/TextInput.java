package sb_email.views.abstr.form;

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
            sb.append("<p>");
            sb.append(super.getLabel());
            sb.append(" <textarea ");
            sb.append(super.getName());
            sb.append(">");
            sb.append(super.getValuePure());
            sb.append("</textarea>");
            sb.append("</p>\r\n");
        } else {
            sb.append("<p>");
            sb.append(super.getLabel());
            sb.append(" <input ");
            sb.append(super.getName());
            sb.append(super.getValue());
            sb.append(" type = \""+type+"\" ");
            sb.append(super.getPlaseholder());

            sb.append("/></p>\r\n");

        }



        return sb.toString();
    }

    public String getType(){
        return type.toString();
    }




}

