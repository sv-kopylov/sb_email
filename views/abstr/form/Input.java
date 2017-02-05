package sb_email.views.abstr.form;

import sb_email.views.abstr.Element;

import javax.naming.OperationNotSupportedException;

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
        return name;
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
        return plaseholder;
    }

    public void setPlaseholder(String plaseholder) {
        this.plaseholder = plaseholder;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) throws OperationNotSupportedException {
        this.value = value;
    }
}
