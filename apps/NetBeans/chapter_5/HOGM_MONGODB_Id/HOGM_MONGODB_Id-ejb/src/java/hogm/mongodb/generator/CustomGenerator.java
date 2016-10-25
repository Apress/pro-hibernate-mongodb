package hogm.mongodb.generator;

import java.io.Serializable;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * This class will generate a random value of type
 * XXXX_long-number (e.g. SFGZ_3495832849584739405)
 * 
* @author Apress
 * 
*/
public class CustomGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor sessionImplemetor,
            Object object) throws HibernateException {

        Random rnd = new Random();
        String str = "";

        for (int i = 0; i <= 3; i++) {
            str = str + (char) (rnd.nextInt(26) + 'a');
        }

        str = str + "_";
        str = str + String.valueOf(rnd.nextLong());
        str=str.toUpperCase();

        return str;
    }
}
