package hogm.jpa.ejb;

import hogm.jpa.entities.LuckyNumberEntity;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
@Named("bean")
public class CMTBean {

    @PersistenceContext(unitName = "HOGM_JPA_JBOSSAS_PU")
    private EntityManager em;

    public void persistAction() {
        LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
        luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));

        em.persist(luckyNumberEntity);
    }
}
