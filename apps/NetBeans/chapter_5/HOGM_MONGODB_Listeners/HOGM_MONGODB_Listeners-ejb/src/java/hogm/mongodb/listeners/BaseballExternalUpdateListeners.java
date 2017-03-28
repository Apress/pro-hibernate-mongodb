package hogm.mongodb.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

public class BaseballExternalUpdateListeners {

    @PreUpdate
    void onPreUpdate(Object o) {
        Logger.getLogger(BaseballExternalUpdateListeners.class.getName()).log(Level.INFO, "PREPARING THE UPDATE THE FIRST BASEBALL PLAYER OBJECT ...{0}", o.toString());
    }

    @PostUpdate
    void onPostUpdate(Object o) {
        Logger.getLogger(BaseballExternalUpdateListeners.class.getName()).log(Level.INFO, "THE FIRST BASEBALL PLAYER OBJECT WAS UPDATED...{0}", o.toString());
    }
}
