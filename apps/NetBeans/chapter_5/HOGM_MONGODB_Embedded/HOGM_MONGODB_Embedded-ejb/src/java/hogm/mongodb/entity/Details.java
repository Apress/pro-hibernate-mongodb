package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Details implements Serializable {
        
    private String birthplace;   
    private String residence;
    @Transient
    private String height;
    @Transient
    private String weight;
    @Transient
    private String plays;
    @Transient
    private int turnedpro;
    @Transient
    private String coach;
    @Transient
    private String website;

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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }            
}
