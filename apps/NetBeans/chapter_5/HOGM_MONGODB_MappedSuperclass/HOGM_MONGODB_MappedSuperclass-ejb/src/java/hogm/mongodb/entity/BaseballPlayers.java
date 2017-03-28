package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name="age", column=@Column(name="baseball_player_age"))
public class BaseballPlayers extends Players implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    protected String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }        
}
