package sb_email.views.abstr.form;

import sb_email.views.abstr.Element;

/**
 * Created by Сергей on 30.01.2017.
 */
public abstract class Input implements Element {
    private String id;
    private String name;
    private String label;
    private String plaseholder;
    private String value;


    public Input(String name) {
        this.name = name;
        id = name;
        label = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (name==null) {
            return"";
        } else {
            return "name = \""+name+"\"";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPlaseholder() {
        if (plaseholder==null) {
            return"";
        } else {
            return "plaseholder = \""+plaseholder+"\"";
        }

    }

    public void setPlaseholder(String plaseholder) {
        this.plaseholder = plaseholder;
    }

    public String getValue() {
        if (value==null) {
            return"";
        } else {
            return "value = \""+value+"\"";
        }
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValuePure() {
        if (value==null) {
            return"";
        } else {
            return value;
        }
    }
}
