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
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("HOGM_JPA_RESOURCE_LOCAL_PU");
    private EntityManager em = emf.createEntityManager();

    /**
     * Insert data
     *
     * @param transientInstance
     * @throws Exception
     */
    public void persistAction(LuckyNumberEntity transientInstance) throws java.lang.Exception {

        log.log(Level.INFO, "Persisting LuckyNumberEntity instance ...");

        try {
            em.getTransaction().begin();
            em.persist(transientInstance);
            em.getTransaction().commit();

            log.log(Level.INFO, "Persist successful...");
        } catch (Exception re) {
            em.getTransaction().rollback();

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
