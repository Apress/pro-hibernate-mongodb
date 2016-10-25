package hogm.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class defines the CRUD operations
 *
 */
@Component
public class LuckyNumberDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persist(LuckyNumberEntity luckyNumberEntity) {
        em.persist(luckyNumberEntity);
    }
}
