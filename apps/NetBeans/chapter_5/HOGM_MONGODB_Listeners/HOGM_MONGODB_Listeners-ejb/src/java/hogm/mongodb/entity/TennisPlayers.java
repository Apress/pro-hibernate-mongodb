package hogm.mongodb.entity;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity
@ExcludeSuperclassListeners
@AttributeOverride(name = "age", column =
@Column(name = "tenis_player_age"))
public class TennisPlayers extends Players implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String handplay;    

    @PrePersist
    @Override
    void onPrePersist() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "PREPARING THE PERSIST A TENNIS PLAYER OBJECT ...");
    }

    @PostPersist
    @Override
    void onPostPersist() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "THE TENNIS PLAYER OBJECT WAS PERSISTED ...");
    }

    @PostLoad
    @Override
    void onPostLoad() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS LOADED ...");
    }

    @PreUpdate
    void onPreUpdate() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "PREPARING THE UPDATE THE FIRST TENNIS PLAYER OBJECT ...");
    }

    @PostUpdate
    void onPostUpdate() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS UPDATED...");
    }

    @PreRemove
    void onPreRemove() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "PREPARING THE DELETE FOR THE FIRST TENNIS PLAYER OBJECT ...");
    }

    @PostRemove
    void onPostRemove() {
        Logger.getLogger(TennisPlayers.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS REMOVED ...");
    }
    
    public String getHandplay() {
        return handplay;
    }

    public void setHandplay(String handplay) {
        this.handplay = handplay;
    }
}
