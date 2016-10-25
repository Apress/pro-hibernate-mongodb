package hogm.mongodb.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class Helper {

    private static final Calendar calendar = GregorianCalendar.getInstance();
    public static final transient String[] names = {"Djokovic", "Federer", "Murray", "Nadal", "Ferrer", "Berdych", "Del Potro", "Tsonga", "Tipsarevic", "Gasquet"};
    public static final transient String[] surnames = {"Novak", "Roger", "Andy", "Rafael", "David", "Tomas", "Juan Martin", "Jo-Wilfried", "Janko", "Richard"};
    public static final transient int[] ages = {25, 31, 25, 26, 30, 27, 24, 27, 28, 26};
    public static final transient Date[] births = new Date[10];
    public static final transient String[][] win2012 = {{"Barclays ATP World Tour Finals", " ATP World Tour Masters 1000 Shanghai", "Beijing", "ATP World Tour Masters 1000 Canada", "ATP World Tour Masters 1000 Miami", "Australian Open"},
        {"ATP World Tour Masters 1000 Cincinnati", "Wimbledon", "ATP World Tour Masters 1000 Madrid", "ATP World Tour Masters 1000 Indian Wells", "Dubai", "Rotterdam"},
        {"US Open", "London Olympics", "Brisbane"},
        {"Roland Garros", "ATP World Tour Masters 1000 Rome", "Barcelona", "ATP World Tour Masters 1000 Monte Carlo"},
        {"ATP World Tour Masters 1000 Paris", "Valencia", "Bastad", "s-Hertogenbosch", "Acapulco", "Buenos Aires", "Auckland"},
        {"Stockholm", "Montpellier"},
        {"Basel", "Vienna", "Estoril", "Marseille"},
        {"Metz", "Doha"},
        {"Stuttgart"},
        {"Bangkok"}};
    public static final transient String[][] rankings08_12 = {{"2008: 3", "2009: 3", "2010: 3", "2011: 1", "2012: 1"},
        {"2008: 2", "2009: 1", "2010: 2", "2011: 1", "2012: 2"},
        {"2008: 4", "2009: 4", "2010: 4", "2011: 4", "2012: 3"},
        {"2008: 1", "2009: 2", "2010: 1", "2011: 2", "2012: 4"},
        {"2008: 12", "2009: 17", "2010: 7", "2011: 5", "2012: 5"},
        {"2008: 20", "2009: 20", "2010: 6", "2011: 7", "2012: 6"},
        {"2008: 9", "2009: 5", "2010: 257", "2011: 11", "2012: 7"},
        {"2008: 6", "2009: 10", "2010: 13", "2011: 6", "2012: 8"},
        {"2008: 49", "2009: 38", "2010: 49", "2011: 9", "2012: 9"},
        {"2008: 24", "2009: 52", "2010: 30", "2011: 19", "2012: 10"}};

    static {
        calendar.clear();
        calendar.set(1987, Calendar.MAY, 22); //22.05.1987
        births[0] = calendar.getTime();
        calendar.clear();
        calendar.set(1981, Calendar.AUGUST, 8); //08.08.1981
        births[1] = calendar.getTime();
        calendar.clear();
        calendar.set(1987, Calendar.MAY, 15); //15.05.1987
        births[2] = calendar.getTime();
        calendar.clear();
        calendar.set(1986, Calendar.JUNE, 3); //03.06.1986
        births[3] = calendar.getTime();
        calendar.clear();
        calendar.set(1982, Calendar.APRIL, 2); //02.04.1982
        births[4] = calendar.getTime();
        calendar.clear();
        calendar.set(1985, Calendar.SEPTEMBER, 17); //17.09.1985
        births[5] = calendar.getTime();
        calendar.clear();
        calendar.set(1988, Calendar.SEPTEMBER, 23); //23.09.1988
        births[6] = calendar.getTime();
        calendar.clear();
        calendar.set(1985, Calendar.APRIL, 17); //17.04.1985
        births[7] = calendar.getTime();
        calendar.clear();
        calendar.set(1984, Calendar.JUNE, 22); //22.06.1984
        births[8] = calendar.getTime();
        calendar.clear();
        calendar.set(1986, Calendar.JUNE, 18); //18.06.1986
        births[9] = calendar.getTime();
        calendar.clear();
    }
}
