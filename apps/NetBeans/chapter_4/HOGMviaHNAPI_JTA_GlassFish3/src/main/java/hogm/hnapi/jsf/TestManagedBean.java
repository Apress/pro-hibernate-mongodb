package hogm.hnapi.jsf;

import hogm.hnapi.dao.LuckyNumberDAO;
import hogm.hnapi.pojo.LuckyNumberEntity;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bean")
@RequestScoped
public class TestManagedBean {

    /**
     * Creates a new instance of TestManagedBean
     */
    public TestManagedBean() {
    }

    /**
     * Persist a lucky number
     *
     * @throws Exception
     */
    public void persistAction() throws Exception {

        LuckyNumberDAO luckyNumberDAO = new LuckyNumberDAO();
        LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
        luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));

        luckyNumberDAO.persist_cs_without_cfg(luckyNumberEntity);
        // luckyNumberDAO.persist_os_without_cfg(luckyNumberEntity);

        //LuckyNumberPojo luckyNumberPojo = new LuckyNumberPojo();
        // luckyNumberPojo.setLuckynumber(new Random().nextInt(1000000));

        //luckyNumberDAO.persist_cs_with_cfg(luckyNumberPojo);
        //  luckyNumberDAO.persist_os_with_cfg(luckyNumberPojo);
        
    }
}
