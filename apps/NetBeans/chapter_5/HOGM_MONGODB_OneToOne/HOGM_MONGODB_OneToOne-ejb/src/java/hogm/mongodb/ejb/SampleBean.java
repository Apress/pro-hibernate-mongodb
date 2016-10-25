package hogm.mongodb.ejb;

import hogm.mongodb.entity.Details;
import hogm.mongodb.entity.MoreDetails;
import hogm.mongodb.entity.Players;
import hogm.mongodb.entity.Websites;
import hogm.mongodb.helper.Helper;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateless
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_OneToOne-ejbPU")
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();
        Websites website = new Websites();
        Details maindetail = new Details();
        MoreDetails moredetail = new MoreDetails();

        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);
        maindetail.setBirthplace(Helper.birthplaces[data]);
        maindetail.setCoach(Helper.coachs[data]);
        maindetail.setHeight(Helper.heights[data]);
        maindetail.setPlays(Helper.plays[data]);
        maindetail.setResidence(Helper.residences[data]);
        maindetail.setTurnedpro(Helper.turnedpro[data]);
        maindetail.setWeight(Helper.weights[data]);
        website.setHttp_address(Helper.websites[data]);
        moredetail.setPrizes(Helper.prizes[data]);
        moredetail.setRanking(Helper.rankings[data]);

        maindetail.setMore(moredetail);
        player.setDetails(maindetail);
        player.setWebsite(website);
        website.setPlayer_website(player);

        em.persist(player);
    }

   public void findAction() {
        int pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYERS INFORMATION ...");
        while (pk < 1001) {
            Players player = em.find(Players.class, pk);
            if (player != null) {
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "************** PLAYER WITH ID: {0} *****************", new Object[]{player.getId()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYER: Name:{0}, Surname:{1}, Age:{2}, Birth:{3}", new Object[]{player.getName(), player.getSurname(), player.getAge(), player.getBirth()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "DETAILS: Birthplace:{0}, Coach:{1}, Height:{2}, Weight:{3}, Residence:{4}, Turned pro:{5}, Plays: {6}", new Object[]{player.getDetails().getBirthplace(), player.getDetails().getCoach(), player.getDetails().getHeight(), player.getDetails().getWeight(), player.getDetails().getResidence(), player.getDetails().getTurnedpro(), player.getDetails().getPlays()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "MORE DETAILS: Prizes:{0}, Ranking:{1}", new Object[]{player.getDetails().getMore().getPrizes(), player.getDetails().getMore().getRanking()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "WEBSITE: {0}", new Object[]{player.getWebsite().getPlayer_website()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "****************************************************");
            }
            pk++;
        }
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "NO MORE PLAYERS AVAILABLE ...");

        pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "WEBSITES INFORMATION ...");
        while (pk < 1001) {
            Websites website = em.find(Websites.class, pk);
            if (website != null) {
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "************** WEBSITE WITH ID: {0} *****************", new Object[]{website.getId()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "WEBSITE: Url:{0}, This website belongs to :{1} {2}", new Object[]{website.getHttp_address(), website.getPlayer_website().getName(), website.getPlayer_website().getSurname()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "****************************************************");
            }
            pk++;
        }
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "NO MORE WEBSITES AVAILABLE ...");
    }

    public void removeAction() {
        int pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "REMOVING FIRST PLAYER (_id:1 - _id:1000) ...");
        while (pk < 1001) {
            Players player = em.find(Players.class, pk);
            if (player != null) {
                em.remove(player);
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYER SUCCESSFULLY REMOVED ...");
                break;
            }
            pk++;
        } 
    }
}
