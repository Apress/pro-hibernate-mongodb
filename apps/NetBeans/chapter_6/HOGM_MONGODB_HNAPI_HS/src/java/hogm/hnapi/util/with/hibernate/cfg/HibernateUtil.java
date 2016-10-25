package hogm.hnapi.util.with.hibernate.cfg;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * HibernateUtil class (based on hibernate.cfg.xml)
 *
 */
public class HibernateUtil {

    private static final Logger log = Logger.getLogger(HibernateUtil.class.getName());
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            // create a new instance of OmgConfiguration
            OgmConfiguration cfgogm = new OgmConfiguration();

            //process configuration and mapping files
            cfgogm.configure();
            // create the SessionFactory
            serviceRegistry = new ServiceRegistryBuilder().applySettings(cfgogm.getProperties()).buildServiceRegistry();
            sessionFactory = cfgogm.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            log.log(Level.SEVERE, "Initial SessionFactory creation failed !", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Get the SessionFactory
     *
     * @return SessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
