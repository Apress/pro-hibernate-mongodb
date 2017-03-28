package hogm.hnapi.util.without.hibernate.cfg;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * HibernateUtil class (no need of hibernate.cfg.xml)
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

            // enable CMT strategy            
            cfgogm.setProperty(Environment.TRANSACTION_STRATEGY, "org.hibernate.transaction.CMTTransactionFactory");
            // specify JTA platform
            cfgogm.setProperty(Environment.JTA_PLATFORM, "org.hibernate.service.jta.platform.internal.SunOneJtaPlatform");

            //configure MongoDB connection 
            cfgogm.setProperty("hibernate.ogm.datastore.provider", "mongodb");
            cfgogm.setProperty("hibernate.ogm.datastore.grid_dialect", "org.hibernate.ogm.dialect.mongodb.MongoDBDialect"); //you can ignore this setting
            cfgogm.setProperty("hibernate.ogm.mongodb.database", "glassfish_db");
            cfgogm.setProperty("hibernate.ogm.mongodb.host", "127.0.0.1");
            cfgogm.setProperty("hibernate.ogm.mongodb.port", "27017");

            //add our annotated class
            cfgogm.addAnnotatedClass(hogm.hnapi.pojo.LuckyNumberEntity.class);

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
