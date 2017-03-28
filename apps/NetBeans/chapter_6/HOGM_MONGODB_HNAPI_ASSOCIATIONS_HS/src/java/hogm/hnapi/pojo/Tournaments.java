package hogm.hnapi.pojo;

import java.util.ArrayList;
import java.util.Collection;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.ContainedIn;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Indexed
public class Tournaments {

    @DocumentId
    private String id;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String tournament;    
    @ContainedIn
    Collection<Players> players = new ArrayList<Players>(0);

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
