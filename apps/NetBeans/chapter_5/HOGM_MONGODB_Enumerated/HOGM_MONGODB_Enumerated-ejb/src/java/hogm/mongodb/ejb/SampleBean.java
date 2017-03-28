package hogm.mongodb.ejb;

import hogm.mongodb.entity.Players;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateless
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_MONGODB_ENUM-ejbPU")
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);

        if ((data == 0) || (data == 1) || (data == 3)) { //Novak, Roger, Nadal
            player.setBest_rating(Players.Ratings.FIRST);
        }
        if (data == 2) { //Andy
            player.setBest_rating(Players.Ratings.SECOND);
        }
        if ((data == 4) || (data == 6)) { //Ferrer, Del Potro
            player.setBest_rating(Players.Ratings.FOURTH);
        }
        if (data == 5) { //Berdych
            player.setBest_rating(Players.Ratings.SIXTH);
        }
        if (data == 7) { //Tsonga
            player.setBest_rating(Players.Ratings.FIFTH);
        }
        if (data == 8) { //Tipsarevic
            player.setBest_rating(Players.Ratings.EIGHTH);
        }
        if (data == 9) { //Gasquet
            player.setBest_rating(Players.Ratings.SEVENTH);
        }
        
        em.persist(player);
    }
}
