package hogm.mongodb.jsf;

import hogm.mongodb.ejb.SampleBean;
import hogm.mongodb.entity.Players;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named(value = "playersMB")
@RequestScoped
public class PlayersMB {

    @EJB
    private SampleBean sampleBean;
    List<Players> players = new ArrayList<Players>();
    
    @PostConstruct
    public void loadPlayers(){
        this.players = sampleBean.loadAction();
    }

    public List<Players> getPlayers() {        
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }
}
