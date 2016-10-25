package hogm.jpa.ejb;

import hogm.jpa.entity.Players;
import hogm.mongodb.helper.Helper;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.jboss.logging.Logger;

@Stateful
@SessionScoped
@Named("bean")
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_HS-ejbPU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(SampleBean.class.getName());

    public void persistAction() {

        log.info("Persisting Players instance ...");

        int data = new Random().nextInt(9);

        Players player = new Players();

        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);

        em.persist(player);

        log.info("Persist successful ...");
    }

    // select all players
    public List<Players> selectAllAction() {

        log.info("Select all Players instance ...");

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Sort sort = new Sort(new SortField("name", SortField.STRING));
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search   
        fullTextQuery.setSort(sort);
        List<Players> results = fullTextQuery.getResultList();

        //clear up resources
        fullTextEntityManager.clear();

        log.info("Search complete ...");

        return results;
    }

    //select by year date
    public List<Players> selectByYearAction() {

        log.info("Search only Players instances born in 1987 ...");

        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        calendar.set(Calendar.YEAR, 1987);

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("birth").matching(calendar.getTime()).createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.getResultList();

        //clear up resources
        fullTextEntityManager.clear();

        log.info("Search complete ...");

        return results;
    }

    // select only Rafael Nadal player
    public List<Players> selectRafaelNadalAction() {

        log.info("Search only Players instances that have the name 'Nadal' and surname 'Rafael' ...");

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.bool().must(queryBuilder.keyword().onField("name").matching("Nadal").createQuery()).must(queryBuilder.keyword().onField("surname").matching("Rafael").createQuery()).createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.getResultList();

        //clear up resources
        fullTextEntityManager.clear();

        log.info("Search complete ...");

        return results;
    }

    // select only players that surnames start with "J"
    public List<Players> selectJAction() {

        log.info("Search only Players that surnames begins with 'J' ...");

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().wildcard().onField("surname").matching("J*").createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.getResultList();

        //clear up resources
        fullTextEntityManager.clear();

        log.info("Search complete ...");

        return results;
    }

    // select only players that ages > 25 and < 28
    public List<Players> select25To28AgeAction() {

        log.info("Search only Players that have ages between 25 and 28, excluding limits ...");

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Players.class).get();
        org.apache.lucene.search.Query query = queryBuilder.range().onField("age").from(25).to(28).excludeLimit().createQuery();

        // wrap Lucene query in a org.hibernate.FullTextQuery
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Players.class);
        //required by OGM
        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        // execute search        
        List<Players> results = fullTextQuery.getResultList();

        //clear up resources
        fullTextEntityManager.clear();

        log.info("Search complete ...");

        return results;
    }
}
