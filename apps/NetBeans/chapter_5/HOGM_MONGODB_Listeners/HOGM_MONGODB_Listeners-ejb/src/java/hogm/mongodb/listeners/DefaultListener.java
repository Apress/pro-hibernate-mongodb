package hogm.mongodb.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class DefaultListener {

    @PrePersist
    void onPrePersist(Object o) {
        Logger.getLogger(DefaultListener.class.getName()).log(Level.INFO, "PREPARING THE PERSIST SOME OBJECT ...");
    }

    @PostPersist
    void onPostPersist(Object o) {
        Logger.getLogger(DefaultListener.class.getName()).log(Level.INFO, "AN OBJECT WAS PERSISTED ...");
    }
}
