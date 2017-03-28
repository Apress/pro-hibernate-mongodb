package hogm.mongodb.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

@Entity
@Table(catalog="ATP", schema="public", name="atp_players")
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;    
    @Column(name="player_name")
    private String name;
    @Column(name="player_surname")
    private String surname;
    @Column(name="player_age")
    @Transient
    private int age;   
    @Temporal(javax.persistence.TemporalType.DATE)    
    @Transient
    private Date birth;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
