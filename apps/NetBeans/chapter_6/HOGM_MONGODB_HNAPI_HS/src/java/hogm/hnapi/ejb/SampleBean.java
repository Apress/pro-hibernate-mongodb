package hogm.hnapi.ejb;

import hogm.hnapi.pojo.Players;
//import hogm.hnapi.entity.Players;
import hogm.mongodb.helper.Helper;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
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

        int data = new Random().nextInt(9);

        Players player = new Players();

        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);

        //hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().persist(player);
        hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().persist(player);

        log.info("Persist successful ...");
    }

    // select all players
    public List<Players> selectAllAction() {

        log.info("Select all Players instance ...");

        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();
        org.apache.lucene.search.Sort sort = new Sort(new SortField("name", SortField.STRING));        

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);        
        
        // set sort rule
        fullTextQuery.setSort(sort);
        // execute search   
        List<Players> results = fullTextQuery.list();

        //clear up resources
        fullTextSession.clear();
    
        log.info("Search complete ...");

        return results;
    }

    //select by year date
    public List<Players> selectByYearAction() {

        log.info("Search only Players instances 'born in 1987' ...");

        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        calendar.set(Calendar.YEAR, 1987);

        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("birth").matching(calendar.getTime()).createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.list();

        //clear up resources
        fullTextSession.clear();      

        log.info("Search complete ...");

        return results;
    }

    // select only Rafael Nadal player
    public List<Players> selectRafaelNadalAction() {

        log.info("Search only Players instances that have the name 'Nadal' and surname 'Rafael' ...");

        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.bool().must(queryBuilder.keyword().onField("name").matching("Nadal").createQuery()).must(queryBuilder.keyword().onField("surname").matching("Rafael").createQuery()).createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.list();

        //clear up resources
        fullTextSession.clear();      

        log.info("Search complete ...");

        return results;
    }

    // select only players that surnames start with "J"
    public List<Players> selectJAction() {

        log.info("Search only Players that surnames begins with 'J' ...");

        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().wildcard().onField("surname").matching("J*").createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.list();

        //clear up resources
        fullTextSession.clear();       

        log.info("Search complete ...");

        return results;
    }

    // select only players that ages > 25 and < 28
    public List<Players> select25To28AgeAction() {

        log.info("Search only Players that have ages between 25 and 28, excluding limits ...");

        //FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());
        FullTextSession fullTextSession = Search.getFullTextSession(hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession());

        QueryBuilder queryBuilder = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.range().onField("age").from(25).to(28).excludeLimit().createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.list();

        //clear up resources
        fullTextSession.clear();        

        log.info("Search complete ...");

        return results;
    }
}
