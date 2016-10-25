package hogm.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "atp_players")
@GenericGenerator(name = "mongodb_uuidgg", strategy = "uuid2")
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    @DocumentId
    @Id
    @GeneratedValue(generator = "mongodb_uuidgg")
    private String id;
    @Column(name = "player_name")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String name;
    @Column(name = "player_surname")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String surname;
    @Column(name = "player_age")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private int age;
    @Column(name = "player_birth")
    @Field
    @DateBridge(resolution = Resolution.YEAR)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birth;    
    @ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    @IndexedEmbedded    
    private Collection<Tournaments> tournaments= new ArrayList<Tournaments>(0);

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

    public Collection<Tournaments> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Collection<Tournaments> tournaments) {
        this.tournaments = tournaments;
    }
      
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
