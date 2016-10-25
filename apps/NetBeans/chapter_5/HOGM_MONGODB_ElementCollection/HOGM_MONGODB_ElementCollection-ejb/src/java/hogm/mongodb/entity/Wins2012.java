package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Wins2012 implements Serializable {
       
   private String titlesfinals;

    public String getTitlesfinals() {
        return titlesfinals;
    }

    public void setTitlesfinals(String titlesfinals) {
        this.titlesfinals = titlesfinals;
    }        
}
