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

    @PersistenceContext(unitName = "HOGM_MONGODB_TRANSIENT-ejbPU")
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);

        em.persist(player);
    }
}
