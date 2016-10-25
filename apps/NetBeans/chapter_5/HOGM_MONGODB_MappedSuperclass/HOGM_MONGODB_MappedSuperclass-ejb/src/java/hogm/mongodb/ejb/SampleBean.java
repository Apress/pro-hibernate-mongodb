package hogm.mongodb.ejb;

import hogm.mongodb.entity.BaseballPlayers;
import hogm.mongodb.entity.TennisPlayers;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateless
public class SampleBean {
    
    @PersistenceContext(unitName = "HOGM_MONGODB_MAPPEDSUPERCLASS-ejbPU")
    private EntityManager em;
    
    public void persistTenisPlayerAction() {
        
        int data = new Random().nextInt(9);
        
        TennisPlayers player = new TennisPlayers();
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);
        player.setHandplay(Helper.plays[data]);
        
        em.persist(player);
    }
    
    public void persistBaseballPlayerAction() {
        
        int data = new Random().nextInt(5);
        
        BaseballPlayers player = new BaseballPlayers();
        player.setName(Helper.bnames[data]);
        player.setSurname(Helper.bsurnames[data]);
        player.setAge(Helper.bages[data]);
        player.setBirth(Helper.bbirths[data]);
        player.setPosition(Helper.bpositions[data]);
        
        em.persist(player);
    }
}
