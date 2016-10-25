package hogm.mongodb.ejb;

import hogm.mongodb.entity.Players;
import hogm.mongodb.entity.Tournaments;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateless
public class SampleBean {
    
    @PersistenceContext(unitName = "HOGM_MONGODB_L2Cache-ejbPU")
    private EntityManager em;
    
    public void persistAction() {        
        
        int data_p = new Random().nextInt(9);
        
        Players player = new Players();
        player.setName(Helper.names[data_p]);
        player.setSurname(Helper.surnames[data_p]);
        player.setAge(Helper.ages[data_p]);
        player.setBirth(Helper.births[data_p]);
        
        if ((data_p == 0) || (data_p == 1) || (data_p == 3)) { //Novak, Roger, Nadal
            player.setBest_rating(Players.Ratings.FIRST);
        }
        if (data_p == 2) { //Andy
            player.setBest_rating(Players.Ratings.SECOND);
        }
        if ((data_p == 4) || (data_p == 6)) { //Ferrer, Del Potro
            player.setBest_rating(Players.Ratings.FOURTH);
        }
        if (data_p == 5) { //Berdych
            player.setBest_rating(Players.Ratings.SIXTH);
        }
        if (data_p == 7) { //Tsonga
            player.setBest_rating(Players.Ratings.FIFTH);
        }
        if (data_p == 8) { //Tipsarevic
            player.setBest_rating(Players.Ratings.EIGHTH);
        }
        if (data_p == 9) { //Gasquet
            player.setBest_rating(Players.Ratings.SEVENTH);
        }
        
        em.persist(player);        
        
        int data_t = new Random().nextInt(6);
        Tournaments tournament = new Tournaments();
        tournament.setName(Helper.tnames[data_t]);
        tournament.setCountry(Helper.tcountries[data_t]);
        tournament.setSurface(Helper.tsurfaces[data_t]);
        tournament.setType(Helper.ttypes[data_t]);
        
        em.persist(tournament);
    }
}
