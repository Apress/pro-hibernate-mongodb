package hogm.mongodb.ejb;

import hogm.mongodb.entity.Players;
import hogm.mongodb.entity.Wins2012;
import hogm.mongodb.helper.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Named("bean")
@Stateful
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_MONGODB_ELEMENTCOLLECTION-ejbPU", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();
        List<Wins2012> wins = new ArrayList();
        List<String> rankingsh = new ArrayList();

        int i = 0;
        try {
            while (true) {
                Wins2012 win = new Wins2012();
                win.setTitlesfinals(Helper.win2012[data][i]);
                wins.add(win);
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }

        i = 0;
        try {
            while (true) {
                String rank = Helper.rankings08_12[data][i];
                rankingsh.add(rank);
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }


        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);
        player.setWins(wins);
        player.setRankinghistory08_12(rankingsh);

        em.persist(player);
    }

    public List loadAction() {
        List first = new ArrayList();
        Players p = em.find(Players.class, 1);
        first.add(p);
        return first;
    }       
}
