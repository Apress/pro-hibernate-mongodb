package tests;

import hogm.mongodb.entity.Players;
import hogm.mongodb.entity.Tournaments;
import javax.persistence.Cache;
import javax.persistence.CacheRetrieveMode;
import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CacheTest {

    private static EntityManagerFactory emf;
    private EntityManager em;

    public CacheTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("HOGM_MONGODB_L2Cache-ejbPU");
        em = emf.createEntityManager();

        em.setProperty("javax.persistence.cache.retrieveMode", CacheRetrieveMode.USE); //this is the default
        em.setProperty("javax.persistence.cache.storeMode", CacheStoreMode.USE); //this is the default
    }

    @After
    public void tearDown() {
        if (em != null) {
            em.clear();
            em.close();
        }
    }

    @Test
    public void testCache_ENABLE_SELECTIVE() {

        Cache cache = em.getEntityManagerFactory().getCache();

        //TESTING PLAYERS OBJECT CACHING
        
        // players objects shouldn't be in second-level cache at this moment
        for (int i = 1; i < 5; i++) {
            assertFalse(cache.contains(Players.class, i));
        }

        // finding the players objects should place them into second-level cache 
        for (int i = 1; i < 5; i++) {
            em.find(Players.class, i);
        }
        
        // players objects should be in second-level cache at this moment, but we delete them from cache one by one        
        for (int i = 1; i < 5; i++) {
            assertTrue(cache.contains(Players.class, i));
            cache.evict(Players.class, i);
        }

        // players objects shouldn't be in second-level cache at this moment        
        for (int i = 1; i < 5; i++) {
            assertFalse(cache.contains(Players.class, i));
        }
        
        //TESTING TOURNAMENTS OBJECT CACHING
        
        // tournaments objects shouldn't be in second-level cache at this moment
        for (int i = 1; i < 5; i++) {
            assertFalse(cache.contains(Tournaments.class, i));
        }

        // finding the tournaments objects shouldn't place them into second-level cache 
        for (int i = 1; i < 5; i++) {
            em.find(Tournaments.class, i);
        }
        
        // players objects shouldn't be in second-level cache at this moment either
        for (int i = 1; i < 5; i++) {
            assertFalse(cache.contains(Tournaments.class, i));            
        }
        
        cache.evictAll();
    }
}
