package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name="age", column=@Column(name="tenis_player_age"))
public class TennisPlayers extends Players implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    protected String handplay; 

    public String getHandplay() {
        return handplay;
    }  
    
    public void setHandplay(String handplay) {
        this.handplay = handplay;
    }        
    
}
