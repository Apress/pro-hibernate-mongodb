package hogm.mongodb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

@MappedSuperclass
@ExcludeDefaultListeners
public abstract class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "player_name")
    protected String name;
    @Column(name = "player_surname")
    protected String surname;
    @Column(name = "player_age")
    protected int age;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date birth;

    @PrePersist
    void onPrePersist() {
        Logger.getLogger(Players.class.getName()).log(Level.INFO, "PREPARING THE PERSIST A (BASEBALL) PLAYER OBJECT ...");
    }

    @PostPersist
    void onPostPersist() {
        Logger.getLogger(Players.class.getName()).log(Level.INFO, "THE (BASEBALL) PLAYER OBJECT WAS PERSISTED ...");
    }

    @PostLoad
    void onPostLoad() {
        Logger.getLogger(Players.class.getName()).log(Level.INFO, "THE FIRST (BASEBALL) PLAYER OBJECT WAS LOADED ...");
    }

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
