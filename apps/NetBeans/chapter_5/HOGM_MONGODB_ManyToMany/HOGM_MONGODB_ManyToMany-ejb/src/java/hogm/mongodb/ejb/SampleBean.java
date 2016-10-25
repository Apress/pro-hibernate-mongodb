package hogm.mongodb.ejb;

import hogm.mongodb.entity.Players;
import hogm.mongodb.entity.Tournaments;
import hogm.mongodb.helper.Helper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
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

    @PersistenceContext(unitName = "HOGM_ManyToMany-ejbPU")
    private EntityManager em;

    public void persistAction() {

        List<Tournaments> tournaments = new ArrayList<Tournaments>();
        Tournaments t_1 = new Tournaments();
        t_1.setTournament(Helper.tournaments[0]);
        t_1.setPlayers(new ArrayList<Players>());
        Tournaments t_2 = new Tournaments();
        t_2.setTournament(Helper.tournaments[1]);
        t_2.setPlayers(new ArrayList<Players>());
        Tournaments t_3 = new Tournaments();
        t_3.setTournament(Helper.tournaments[2]);
        t_3.setPlayers(new ArrayList<Players>());
        Tournaments t_4 = new Tournaments();
        t_4.setTournament(Helper.tournaments[3]);
        t_4.setPlayers(new ArrayList<Players>());
        Tournaments t_5 = new Tournaments();
        t_5.setTournament(Helper.tournaments[4]);
        t_5.setPlayers(new ArrayList<Players>());
        Tournaments t_6 = new Tournaments();
        t_6.setTournament(Helper.tournaments[5]);
        t_6.setPlayers(new ArrayList<Players>());
        Tournaments t_7 = new Tournaments();
        t_7.setTournament(Helper.tournaments[6]);
        t_7.setPlayers(new ArrayList<Players>());
        Tournaments t_8 = new Tournaments();
        t_8.setTournament(Helper.tournaments[7]);
        t_8.setPlayers(new ArrayList<Players>());
        Tournaments t_9 = new Tournaments();
        t_9.setTournament(Helper.tournaments[8]);
        t_9.setPlayers(new ArrayList<Players>());
        Tournaments t_10 = new Tournaments();
        t_10.setTournament(Helper.tournaments[9]);
        t_10.setPlayers(new ArrayList<Players>());
        Tournaments t_11 = new Tournaments();
        t_11.setTournament(Helper.tournaments[10]);
        t_11.setPlayers(new ArrayList<Players>());
        Tournaments t_12 = new Tournaments();
        t_12.setTournament(Helper.tournaments[11]);
        t_12.setPlayers(new ArrayList<Players>());
        Tournaments t_13 = new Tournaments();
        t_13.setTournament(Helper.tournaments[12]);
        t_13.setPlayers(new ArrayList<Players>());
        Tournaments t_14 = new Tournaments();
        t_14.setTournament(Helper.tournaments[13]);
        t_14.setPlayers(new ArrayList<Players>());
        Tournaments t_15 = new Tournaments();
        t_15.setTournament(Helper.tournaments[14]);
        t_15.setPlayers(new ArrayList<Players>());
        Tournaments t_16 = new Tournaments();
        t_16.setTournament(Helper.tournaments[15]);
        t_16.setPlayers(new ArrayList<Players>());
        tournaments.add(t_1);
        tournaments.add(t_2);
        tournaments.add(t_3);
        tournaments.add(t_4);
        tournaments.add(t_5);
        tournaments.add(t_6);
        tournaments.add(t_7);
        tournaments.add(t_8);
        tournaments.add(t_9);
        tournaments.add(t_10);
        tournaments.add(t_11);
        tournaments.add(t_12);
        tournaments.add(t_13);
        tournaments.add(t_14);
        tournaments.add(t_15);
        tournaments.add(t_16);

        Collection<Integer> store_1 = new ArrayList<Integer>();
        Collection<Integer> store_2 = new ArrayList<Integer>();

        int plr_nr = new Random().nextInt(9);
        for (int i = 0; i <= plr_nr; i++) {

            int data_1 = new Random().nextInt(9);
            if (!store_1.contains(data_1)) {
                Players player = new Players();
                player.setTournaments(new ArrayList<Tournaments>());
                player.setName(Helper.names[i]);
                player.setSurname(Helper.surnames[i]);
                player.setAge(Helper.ages[i]);
                player.setBirth(Helper.births[i]);

                int trn_nr = new Random().nextInt(4);

                store_2.clear();
                for (int j = 0; j <= trn_nr; j++) {
                    int data_2 = new Random().nextInt(16);
                    if (!store_2.contains(data_2)) {
                        Tournaments tournament = tournaments.get(data_2);
                        tournament.getPlayers().add(player);
                        player.getTournaments().add(tournament);
                        store_2.add(data_2);
                    } else {
                        j--;
                    }
                }
                store_1.add(data_1);
                em.persist(player);
            } else {
                i--;
            }
        }
    }

    public void findAction() {
        int pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYERS INFORMATION ...");
        while (pk < 1001) {
            Players player = em.find(Players.class, pk);
            if (player != null) {
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "************** PLAYER WITH ID: {0} *****************", new Object[]{player.getId()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYER: Name:{0}, Surname:{1}, Age:{2}, Birth:{3}", new Object[]{player.getName(), player.getSurname(), player.getAge(), player.getBirth()});
                Collection<Tournaments> photos = player.getTournaments();
                Iterator iterator = photos.iterator();
                while (iterator.hasNext()) {
                    Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "TOURNAMENT: Name:{0}", new Object[]{((Tournaments) (iterator.next())).getTournament()});
                }
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "****************************************************");
            }
            pk++;
        }
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "NO MORE PLAYERS AVAILABLE ...");

        pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "TOURNAMENTS INFORMATION ...");
        while (pk < 1001) {
            Tournaments tournament = em.find(Tournaments.class, pk);
            if (tournament != null) {
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "************** TOURNAMENT WITH ID: {0} *****************", new Object[]{tournament.getId()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "TOURNAMENT: Name :{0}, Participants:", new Object[]{tournament.getTournament()});
                Collection<Players> players = tournament.getPlayers();
                Iterator iterator = players.iterator();
                while (iterator.hasNext()) {
                    Players player = (Players) iterator.next();
                    Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYER: Name:{0}, Surname:{1}, Age:{2}, Birth:{3}", new Object[]{player.getName(), player.getSurname(), player.getAge(), player.getBirth()});
                }
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "****************************************************");
            }
            pk++;
        }
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "NO MORE TOURNAMENTS AVAILABLE ...");
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
