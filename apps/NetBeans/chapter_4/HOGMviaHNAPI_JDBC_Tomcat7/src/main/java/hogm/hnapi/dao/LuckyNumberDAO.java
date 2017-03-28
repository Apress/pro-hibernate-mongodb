package hogm.hnapi.dao;

import hogm.hnapi.pojo.LuckyNumberEntity;
import hogm.hnapi.pojo.LuckyNumberPojo;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 * This class defines the CRUD operations
 *
 */
public class LuckyNumberDAO {

    private static final Logger log = Logger.getLogger(LuckyNumberDAO.class.getName());

    /**
     * Insert data (use getCurrentSession and @Entity)
     *
     * @param transientInstance
     * @throws Exception
     */
    public void persist_cs_without_cfg(LuckyNumberEntity transientInstance) throws java.lang.Exception {

        log.log(Level.INFO, "Persisting LuckyNumberEntity instance ...");
        Session session = hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.persist(transientInstance);
            session.getTransaction().commit();

            log.log(Level.INFO, "Persist successful...");
        } catch (RuntimeException re) {
            session.getTransaction().rollback();
            log.log(Level.SEVERE, "Persist failed...", re);
            throw re;
        }
    }

    /**
     * Insert data (use openSession and @Entity)
     *
     * @param transientInstance
     * @throws Exception
     */
    public void persist_os_without_cfg(LuckyNumberEntity transientInstance) throws java.lang.Exception {

        log.log(Level.INFO, "Persisting LuckyNumberEntity instance ...");
        Session session = hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(transientInstance);
            session.flush(); // flush happens automatically anyway
            session.getTransaction().commit();

            log.log(Level.INFO, "Persist successful...");
        } catch (RuntimeException re) {
            session.getTransaction().rollback();
            log.log(Level.SEVERE, "Persist failed...", re);
            throw re;
        } finally {
            session.close();
        }
    }
    
     /**
     * Insert data (use getCurrentSession and POJO)
     *
     * @param transientInstance
     * @throws Exception
     */
    public void persist_cs_with_cfg(LuckyNumberPojo transientInstance) throws java.lang.Exception {

        log.log(Level.INFO, "Persisting LuckyNumberPojo instance ...");
        Session session = hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            session.persist(transientInstance);
            session.getTransaction().commit();

            log.log(Level.INFO, "Persist successful...");
        } catch (RuntimeException re) {
            session.getTransaction().rollback();
            log.log(Level.SEVERE, "Persist failed...", re);
            throw re;
        }
    }
    
    /**
     * Insert data (use openSession and POJO)
     *
     * @param transientInstance
     * @throws Exception
     */
    public void persist_os_with_cfg(LuckyNumberPojo transientInstance) throws java.lang.Exception {

        log.log(Level.INFO, "Persisting LuckyNumberPojo instance ...");
        Session session = hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().openSession();

        try {
            session.beginTransaction();
            session.persist(transientInstance);
            session.flush(); // flush happens automatically anyway
            session.getTransaction().commit();

            log.log(Level.INFO, "Persist successful...");
        } catch (RuntimeException re) {
            session.getTransaction().rollback();
            log.log(Level.SEVERE, "Persist failed...", re);
            throw re;
        } finally {
            session.close();
        }
    }
}
