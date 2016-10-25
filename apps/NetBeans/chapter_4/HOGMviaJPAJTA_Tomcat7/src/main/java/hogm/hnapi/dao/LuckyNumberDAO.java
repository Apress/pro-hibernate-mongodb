package hogm.hnapi.dao;

import hogm.hnapi.entities.LuckyNumberEntity;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class defines the CRUD operations
 *
 */
public class LuckyNumberDAO {

    private static final Logger log = Logger.getLogger(LuckyNumberDAO.class.getName());
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HOGM_JPA_JTA_TOMCAT_PU");
    private final EntityManager em = emf.createEntityManager();

    /**
     * Insert data
     *
     * @param transientInstance
     * @throws Exception
     */
    public void persistAction(LuckyNumberEntity transientInstance) throws java.lang.Exception {

        log.log(Level.INFO, "Persisting LuckyNumberEntity instance ...");

        javax.transaction.TransactionManager tx = com.arjuna.ats.jta.TransactionManager.transactionManager();
        // javax.transaction.UserTransaction tx = com.arjuna.ats.jta.UserTransaction.userTransaction();

        try {
            tx.begin();
            em.joinTransaction();
            em.persist(transientInstance);
            tx.commit();

            log.log(Level.INFO, "Persist successful...");
        } catch (Exception re) {
            tx.rollback();

            log.log(Level.SEVERE, "Persist failed...", re);
            throw re;
        } finally {
            if (em != null) {
                em.clear();
                em.close();
            }
        }
    }
}
