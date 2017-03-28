package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players_websites")
public class Websites implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String http_address;
    @OneToOne(mappedBy = "website")
    private Players player_website;

    public Players getPlayer_website() {
        return player_website;
    }

    public void setPlayer_website(Players player_website) {
        this.player_website = player_website;
    }        

    public String getHttp_address() {
        return http_address;
    }

    public void setHttp_address(String http_address) {
        this.http_address = http_address;
    }    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }      
}
