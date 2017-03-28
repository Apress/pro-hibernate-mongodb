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

    @PersistenceContext(unitName = "HOGM_MONGODB_Id-ejbPU")
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        //******************************************* TEST - manually set primary keys ***********************************
        /*
         Players player_1 = new Players();  
         player_1.setId(1);
         player_1.setName(Helper.names[1]);
         player_1.setSurname(Helper.surnames[1]);
         player_1.setAge(Helper.ages[1]); 
         Players player_2 = new Players();  
         player_2.setId(2);
         player_2.setName(Helper.names[2]);
         player_2.setSurname(Helper.surnames[2]);
         player_2.setAge(Helper.ages[2]); 
         Players player_3 = new Players();  
         player_3.setId(3);
         player_3.setName(Helper.names[3]);
         player_3.setSurname(Helper.surnames[3]);
         player_3.setAge(Helper.ages[3]); 
        
         em.persist(player_1);
         em.persist(player_2);
         em.persist(player_3);
         */
        //****************************************************************************************************************

        //****************** TEST - AUTO, IDENTITY, SEQUENCE, TABLE, UUID2, Custom Generator strategies ******************

        Players player = new Players();
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);

        em.persist(player);

        //****************************************************************************************************************

        //*************************************** TEST - Composite Key (EmbeddedId) **************************************
        /*      
         RankingAndPrizeE id = new RankingAndPrizeE();
         id.setRanking(Helper.rankings[data]);
         id.setPrize(Helper.prizes[data]);
        
         Players player = new Players();        
         player.setId(id);
         player.setName(Helper.names[data]);
         player.setSurname(Helper.surnames[data]);
         player.setAge(Helper.ages[data]);        
        
         em.persist(player);
         */
        //****************************************************************************************************************       

        //*************************************** TEST - Composite Key (IdClass) **************************************
        /*
         Players player = new Players();
         player.setRanking(Helper.rankings[data]);
         player.setPrize(Helper.prizes[data]);
         player.setName(Helper.names[data]);
         player.setSurname(Helper.surnames[data]);
         player.setAge(Helper.ages[data]);

         em.persist(player);
         */
        //****************************************************************************************************************       

    }
}
