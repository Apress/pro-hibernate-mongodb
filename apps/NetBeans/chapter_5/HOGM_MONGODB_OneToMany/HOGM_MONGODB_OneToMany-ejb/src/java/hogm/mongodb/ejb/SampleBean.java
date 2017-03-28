package hogm.mongodb.ejb;

import hogm.mongodb.entity.Photos;
import hogm.mongodb.entity.Players;
import hogm.mongodb.helper.Helper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("bean")
@Stateless
public class SampleBean {

    @PersistenceContext(unitName = "HOGM_OneToMany-ejbPU")
    private EntityManager em;

    public void persistAction() {

        int data = new Random().nextInt(9);

        Players player = new Players();

        player.setName(Helper.names[data]);
        player.setSurname(Helper.surnames[data]);
        player.setAge(Helper.ages[data]);
        player.setBirth(Helper.births[data]);

        int i = 0;
        Collection<Photos> photolist = new ArrayList<Photos>();
        try {
            while (true) {
                Photos photo = new Photos();
                photo.setPhoto(Helper.photos[data][i]);
                photo.setPlayer_photos(player);
                photolist.add(photo);
                i++;
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
        }

        player.setPhotos(photolist);

        em.persist(player);
    }
    
    public void findAction() {
        int pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYERS INFORMATION ...");
        while (pk < 1001) {
            Players player = em.find(Players.class, pk);
            if (player != null) {
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "************** PLAYER WITH ID: {0} *****************", new Object[]{player.getId()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYER: Name:{0}, Surname:{1}, Age:{2}, Birth:{3}", new Object[]{player.getName(), player.getSurname(), player.getAge(), player.getBirth()});
                Collection<Photos> photos = player.getPhotos();
                Iterator iterator = photos.iterator();
                while(iterator.hasNext()){
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PHOTO: Name:{0}", new Object[]{((Photos)(iterator.next())).getPhoto()});
                }                
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "****************************************************");
            }
            pk++;
        }
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "NO MORE PLAYERS AVAILABLE ...");

        pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PHOTOS INFORMATION ...");
        while (pk < 1001) {
            Photos photo = em.find(Photos.class, pk);
            if (photo != null) {                
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "************** PHOTO WITH ID: {0} *****************", new Object[]{photo.getId()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PHOTO: Photo :{0}, This photo belongs to :{1} {2}", new Object[]{photo.getPhoto(), photo.getPlayer_photos().getName(), photo.getPlayer_photos().getSurname()});
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "****************************************************");
            }
            pk++;
        }
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "NO MORE PHOTOS AVAILABLE ...");       
    }
    
    public void removeAction() {
        int pk = 1;
        Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "REMOVING FIRST PLAYER (_id:1 - _id:1000) ...");
        while (pk < 1001) {
            Players player = em.find(Players.class, pk);
            if (player != null) {
                em.remove(player);
                Logger.getLogger(SampleBean.class.getName()).log(Level.INFO, "PLAYER SUCCESSFULLY REMOVED ...");
                break;
            }
            pk++;
        } 
    }
}
