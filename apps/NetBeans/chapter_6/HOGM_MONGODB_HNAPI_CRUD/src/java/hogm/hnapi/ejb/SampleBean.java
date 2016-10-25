package hogm.hnapi.ejb;

import hogm.hnapi.pojo.Players;
//import hogm.hnapi.entity.Players;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.jboss.logging.Logger;

@Stateful
@SessionScoped
@Named("bean")
public class SampleBean {

    private static final Logger log = Logger.getLogger(SampleBean.class.getName());
    private Players player;
    private String find_id;
    private List<String> ids;

    @PostConstruct
    public void newPlayer() {
        this.player = new Players();
        ids = new ArrayList<String>();
    }

    public void persistAction() {

        log.info("Persisting Players instance ...");

        Players new_player = new Players();
        new_player.setName(player.getName());
        new_player.setSurname(player.getSurname());
        new_player.setAge(player.getAge());
        new_player.setBirth(player.getBirth());

        //hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().persist(new_player);
        hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().persist(new_player);
        player = new_player;
        ids.add(player.getId());

        log.info("Persist successful ...");
    }

    public void findAction() {

        log.info("Finding Players instance ...");
        if (find_id != null) {
            //player = (Players) hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().get(hogm.hnapi.entity.Players.class, find_id);
            player = (Players) hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().get(hogm.hnapi.pojo.Players.class, find_id);
            if (player == null) {
                player = new Players();
            }
        } else {
            log.warn("You have to select an id ...");
        }
        log.info("Find successful ...");
    }

    public void updateAction() {

        log.info("Updating Players instance ...");

        if (player.getId() != null) {
            //hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().merge(player);
            hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().merge(player);
        } else {
            log.warn("There is no player to update ...");
        }
        log.info("Update successful ...");
    }

    public void removeAction() {

        log.info("Deleting Players instance ...");
        
        if (player.getId() != null) {
            //Players existing_player = (Players) hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().get(hogm.hnapi.entity.Players.class, player.getId());
            Players existing_player = (Players) hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().get(hogm.hnapi.pojo.Players.class, player.getId());
            if (existing_player != null) {
                //hogm.hnapi.util.without.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().delete(existing_player);
                hogm.hnapi.util.with.hibernate.cfg.HibernateUtil.getSessionFactory().getCurrentSession().delete(existing_player);

                ids.remove(player.getId());
                player.setId(null);
            } else {
                log.warn("Cannot find player to delete ...");
            }
        } else {
            log.warn("You must specify a player to delete ...");
        }
        log.info("Delete successful ...");
    }

    public String getFind_id() {
        return find_id;
    }

    public void setFind_id(String find_id) {
        this.find_id = find_id;
    }

    public Players getPlayer() {
        return player;
    }

    public void setPlayer(Players player) {
        this.player = player;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
