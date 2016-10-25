package hogm.mongodb.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(catalog = "ATP", schema = "public", name = "atp_players")
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;    
    @Column(name = "player_name")
    private String name;
    @Column(name = "player_surname")
    private String surname;
    @Column(name = "player_age")
    private int age;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birth;
    @ElementCollection(targetClass=hogm.mongodb.entity.Wins2012.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "EC_TABLE")  //not supported by OGM
    @AttributeOverrides({
        @AttributeOverride(name = "titlesfinals",
        column = @Column(name = "EC_titlesfinals"))
    })
    private List<Wins2012> wins = new ArrayList<Wins2012>();
    @ElementCollection(targetClass=java.lang.String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "RANKING_TABLE")  //not supported by OGM    
    private List<String> rankinghistory08_12 = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<Wins2012> getWins() {
        return wins;
    }

    public void setWins(List<Wins2012> wins) {
        this.wins = wins;
    }

    public List<String> getRankinghistory08_12() {
        return rankinghistory08_12;
    }

    public void setRankinghistory08_12(List<String> rankinghistory08_12) {
        this.rankinghistory08_12 = rankinghistory08_12;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
