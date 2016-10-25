package hogm.mongodb.ejb;

import hogm.mongodb.entity.BaseballPlayers;
import hogm.mongodb.entity.TennisPlayers;
import hogm.mongodb.helper.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateful
@SessionScoped
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_MONGODB_LISTENERS-ejbPU")
    private EntityManager em;
    private List tennispklist = new ArrayList();
    private List baseballpklist = new ArrayList();

    public void persistTenisPlayerAction() {

        int data = new Random().nextInt(9);

        TennisPlayers player = new TennisPlayers();
        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);
        player.setHandplay(Helper.plays[data]);

        em.persist(player);

        tennispklist.add(player.getId());
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

        baseballpklist.add(player.getId());
    }

    public void loadFirstTennisPlayer() {
        if (!tennispklist.isEmpty()) {
            em.find(TennisPlayers.class, tennispklist.get(0));
        } else {
            Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, "THERE ARE NO MORE TENNIS PLAYERS IN THE DATABASE ...");
        }
    }

    public void loadFirstBaseballPlayer() {
        if (!baseballpklist.isEmpty()) {
            em.find(BaseballPlayers.class, baseballpklist.get(0));
        } else {
            Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, "THERE ARE NO MORE BASEBALL PLAYERS IN THE DATABASE ...");
        }
    }

    public void updateFirstTennisPlayer() {
        if (!tennispklist.isEmpty()) {
            TennisPlayers first = em.find(TennisPlayers.class, tennispklist.get(0));
            if (first != null) {
                first.setHandplay("Left-handed");
                em.merge(first);
            }
        } else {
            Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, "THERE ARE NO MORE TENNIS PLAYERS IN THE DATABASE ...");
        }
    }

    public void updateFirstBaseballPlayer() {
        if (!baseballpklist.isEmpty()) {
            BaseballPlayers first = em.find(BaseballPlayers.class, baseballpklist.get(0));
            if (first != null) {
                first.setPosition("reserve");
                em.merge(first);
            }
        } else {
            Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, "THERE ARE NO MORE BASEBALL PLAYERS IN THE DATABASE ...");
        }
    }

    public void deleteFirstTennisPlayer() {
        if (!tennispklist.isEmpty()) {
            TennisPlayers first = em.find(TennisPlayers.class, tennispklist.get(0));
            if (first != null) {
                em.remove(first);
                tennispklist.remove(0);
            }
        } else {
            Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, "THERE ARE NO MORE TENNIS PLAYERS IN THE DATABASE ...");
        }
    }

    public void deleteFirstBaseballPlayer() {
        if (!baseballpklist.isEmpty()) {
            BaseballPlayers first = em.find(BaseballPlayers.class, baseballpklist.get(0));
            if (first != null) {
                em.remove(first);
                baseballpklist.remove(0);
            }
        } else {
            Logger.getLogger(SampleBean.class.getName()).log(Level.SEVERE, "THERE ARE NO MORE BASEBALL PLAYERS IN THE DATABASE ...");
        }
    }
}
