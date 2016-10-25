package hogm.mongodb.ejb;

import hogm.mongodb.entity.Players;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateful
@SessionScoped
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_MONGODB_VERSION-ejbPU")
    private EntityManager em;
    Players p1 = null;
    Players p2 = null;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setFacade(new Random().nextInt(1000000));

        em.persist(player);
    }

    public void readUpdateAction() {

        p1 = em.find(Players.class, 1, LockModeType.OPTIMISTIC);

        if (p1 != null) {
            p1.setFacade(new Random().nextInt(1000000));

            em.merge(p1);           
            em.flush();         
        }
    }

    //******** TEST OPTIMISTIC LOCKING FOR LockModeType.OPTIMISTIC and OPTIMISTIC_FORCE_INCREMENT  ********//
    public void read_OPTIMISTIC_Action_1() {
        p1 = em.find(Players.class, 1, LockModeType.OPTIMISTIC); //or OPTIMISTIC_FORCE_INCREMENT        
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "READ 1, version={0}", p1.getVersion());
    }

    public void read_OPTIMISTIC_Action_2() {
        p2 = em.find(Players.class, 1, LockModeType.OPTIMISTIC); //or OPTIMISTIC_FORCE_INCREMENT   
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "READ 2, version={0}", p2.getVersion());
    }

    public void update_OPTIMISTIC_Action_1() {
        p1.setFacade(new Random().nextInt(1000000));
        em.merge(p1);
        em.flush();
        p1 = em.find(Players.class, 1, LockModeType.OPTIMISTIC); //or OPTIMISTIC_FORCE_INCREMENT
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "UPDATE 1, version={0}", p1.getVersion());
    }

    public void update_OPTIMISTIC_Action_2() {
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "UPDATE 2, version={0}", p2.getVersion());
        p2.setFacade(new Random().nextInt(1000000));       
        em.merge(p2);      
        em.flush();
        //there is no need to check version, until now the OptimisticLockException exception should be in log
    }
    //****************************************************************************************************//   
}
