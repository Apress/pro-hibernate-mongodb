package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "player_details")
public class Details implements Serializable {
        
    private String birthplace;    
    private String residence;   
    private String height;    
    private String weight;    
    private String plays;    
    private int turnedpro;   
    private String coach;       
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private MoreDetails more;

    public MoreDetails getMore() {
        return more;
    }

    public void setMore(MoreDetails more) {
        this.more = more;
    }   
    
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }   

    public String getPlays() {
        return plays;
    }

    public void setPlays(String plays) {
        this.plays = plays;
    }

    public int getTurnedpro() {
        return turnedpro;
    }

    public void setTurnedpro(int turnedpro) {
        this.turnedpro = turnedpro;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }           
}
