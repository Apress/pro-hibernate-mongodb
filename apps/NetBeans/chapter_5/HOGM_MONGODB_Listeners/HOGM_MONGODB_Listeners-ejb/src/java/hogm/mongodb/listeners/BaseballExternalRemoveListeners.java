package hogm.mongodb.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PostRemove;
import javax.persistence.PreRemove;

public class BaseballExternalRemoveListeners {

    @PreRemove
    void onPreRemove(Object o) {
        Logger.getLogger(BaseballExternalRemoveListeners.class.getName()).log(Level.INFO, "PREPARING THE DELETE FOR THE FIRST BASEBALL PLAYER OBJECT ...{0}", o.toString());
    }

    @PostRemove
    void onPostRemove(Object o) {
        Logger.getLogger(BaseballExternalRemoveListeners.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS REMOVED ...{0}", o.toString());
    }
}
