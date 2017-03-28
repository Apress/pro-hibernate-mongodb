package hogm.jpa.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "atp_tournaments")
@GenericGenerator(name = "mongodb_uuidgg", strategy = "uuid2")
public class Tournaments implements Serializable {

    private static final long serialVersionUID = 1L;
    @DocumentId
    @Id
    @GeneratedValue(generator = "mongodb_uuidgg")
    private String id;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String tournament;
    @ManyToMany(mappedBy = "tournaments", fetch = FetchType.EAGER)
    @ContainedIn
    private Collection<Players> players = new ArrayList<Players>(0);

    public Collection<Players> getPlayers() {
        return players;
    }

    public void setPlayers(Collection<Players> players) {
        this.players = players;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
