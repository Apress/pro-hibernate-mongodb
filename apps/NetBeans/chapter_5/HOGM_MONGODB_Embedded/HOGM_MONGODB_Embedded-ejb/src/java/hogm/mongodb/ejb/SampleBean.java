package hogm.mongodb.ejb;

import hogm.mongodb.entity.Details;
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

    @PersistenceContext(unitName = "HOGM_MONGODB_EMBEDDED-ejbPU")
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();
        Details detail = new Details();        
        
        detail.setBirthplace(Helper.birthplaces[data]);
        detail.setCoach(Helper.coachs[data]);
        detail.setHeight(Helper.heights[data]);
        detail.setPlays(Helper.plays[data]);
        detail.setResidence(Helper.residences[data]);
        detail.setTurnedpro(Helper.turnedpro[data]);
        detail.setWebsite(Helper.websites[data]);
        detail.setWeight(Helper.weights[data]);      
        
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);
                
        player.setDetails(detail);
               
        em.persist(player);        
    }
}
