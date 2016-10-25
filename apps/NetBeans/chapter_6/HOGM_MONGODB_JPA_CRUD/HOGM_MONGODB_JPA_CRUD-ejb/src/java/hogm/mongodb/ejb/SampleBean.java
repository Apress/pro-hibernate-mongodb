package hogm.mongodb.ejb;

import hogm.mongodb.entity.Players;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

@Named("bean")
@Stateful
@SessionScoped
public class SampleBean {
    
    @PersistenceContext(unitName = "HOGM_CRUD-ejbPU")
    private EntityManager em;
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
        
        em.persist(new_player);
        player = new_player;
        ids.add(player.getId());
        
        log.info("Persist successful ...");
    }
    
    public void findAction() {
        
        log.info("Finding Players instance ...");
        if (find_id != null) {
            player = em.find(hogm.mongodb.entity.Players.class, find_id);
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
            em.merge(player);            
        } else {
            log.warn("There is no player to update ...");
        }
        log.info("Update successful ...");
    }
    
    public void removeAction() {
        
        log.info("Deleting Players instance ...");
        
        if (player.getId() != null) {
            Players existing_player = em.find(hogm.mongodb.entity.Players.class, player.getId());            
            if (existing_player != null) {
                em.remove(existing_player);
                
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
