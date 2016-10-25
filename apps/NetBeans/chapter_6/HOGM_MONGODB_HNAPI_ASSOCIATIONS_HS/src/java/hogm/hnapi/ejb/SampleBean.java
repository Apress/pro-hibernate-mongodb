package hogm.hnapi.ejb;

//import hogm.hnapi.pojo.Players;
//import hogm.hnapi.pojo.Tournaments;
import hogm.hnapi.entity.Players;
import hogm.hnapi.entity.Tournaments;
import hogm.mongodb.helper.Helper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.jboss.logging.Logger;

@Stateful
@SessionScoped
@Named("bean")
public class SampleBean {

    private static final Logger log = Logger.getLogger(SampleBean.class.getName());

    public void persistAction() {

        log.info("Persisting Players instance ...");

        List<Tournaments> tournaments = new ArrayList<Tournaments>(0);
        Tournaments t_1 = new Tournaments();
        t_1.setTournament(Helper.tournaments[0]);
        Tournaments t_2 = new Tournaments();
        t_2.setTournament(Helper.tournaments[1]);
        Tournaments t_3 = new Tournaments();
        t_3.setTournament(Helper.tournaments[2]);
        Tournaments t_4 = new Tournaments();
        t_4.setTournament(Helper.tournaments[3]);
        Tournaments t_5 = new Tournaments();
        t_5.setTournament(Helper.tournaments[4]);
        Tournaments t_6 = new Tournaments();
        t_6.setTournament(Helper.tournaments[5]);
        Tournaments t_7 = new Tournaments();
        t_7.setTournament(Helper.tournaments[6]);
        Tournaments t_8 = new Tournaments();
        t_8.setTournament(Helper.tournaments[7]);
        Tournaments t_9 = new Tournaments();
        t_9.setTournament(Helper.tournaments[8]);
        Tournaments t_10 = new Tournaments();
        t_10.setTournament(Helper.tournaments[9]);
        Tournaments t_11 = new Tournaments();
        t_11.setTournament(Helper.tournaments[10]);
        Tournaments t_12 = new Tournaments();
        t_12.setTournament(Helper.tournaments[11]);
        Tournaments t_13 = new Tournaments();
        t_13.setTournament(Helper.tournaments[12]);
        Tournaments t_14 = new Tournaments();
        t_14.setTournament(Helper.tournaments[13]);
        Tournaments t_15 = new Tournaments();
        t_15.setTournament(Helper.tournaments[14]);
        Tournaments t_16 = new Tournaments();
        t_16.setTournament(Helper.tournaments[15]);
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
                player.setName(Helper.names[i]);
                player.setSurname(Helper.surnames[i]);
                player.setAge(Helper.ages[i]);
                player.setBirth(Helper.births[i]);

                int trn_nr = new Random().nextInt(16);

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
                hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().persist(player);
                //hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().persist(player);
            } else {
                i--;
            }
        }

        log.info("Persist successful ...");
    }

    // select all players
    public List<Players> selectAllPlayersAction() {

        log.info("Select all Players instance ...");

        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Sort sort = new Sort(new SortField("name", SortField.STRING));
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search   
        fullTextQuery.setSort(sort);
        List<Players> results = fullTextQuery.list();

        //clea up resources
        fullTextSession.clear();
        fullTextSession.close();

        log.info("Search complete ...");

        return results;
    }

    // select all tournaments
    public List<Tournaments> selectAllTournamentsAction() {

        log.info("Select all Tournaments instance ...");

        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Tournaments.class).get();
        org.apache.lucene.search.Sort sort = new Sort(new SortField("tournament", SortField.STRING));
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Tournaments.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search   
        fullTextQuery.setSort(sort);
        List<Tournaments> results = fullTextQuery.list();

        //clea up resources
        fullTextSession.clear();
        fullTextSession.close();

        log.info("Search complete ...");

        return results;
    }
}
