package sb_email.views.conc.reachdesign.parts;

import sb_email.views.abstr.Page;

/**
 * Created by Сергей on 02.03.2017.
 */
public class Pagetemplate extends Page {


    public Pagetemplate(String tytle) {
        super(tytle);
        super.setHead(new Headtemplate());
    }
}
