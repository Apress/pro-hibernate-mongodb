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
    public static final transient String[] birthplaces = {"Belgrade, Serbia", "Basel, Switzerland", "Dunblane, Scotland", "Manacor, Mallorca, Spain", "Javea, Spain", "Valasske Mezirici, Czech", "Tandil, Argentina", "Le Mans, France", "Belgrade, Serbia", "Beziers, France"};
    public static final transient String[] residences = {"Monte Carlo, Monaco", "Bottmingen, Switzerland", "London, England", "Manacor, Mallorca, Spain", "Valencia, Spain", "Monte Carlo, Monaco", "Tandil, Argentina", "Gingins, Switzerland", "Belgrade, Serbia", "Neuchatel, Switzerland"};
    public static final transient String[] heights = {"188 cm", "185 cm", "190 cm", "185 cm", "175 cm", "196 cm", "198 cm", "188 cm", "180 cm", "185 cm"};
    public static final transient String[] weights = {"176 lbs (80 kg)", "187 lbs (85 kg)", "185 lbs (84 kg)", "188 lbs (85 kg)", "160 lbs (73 kg)", "200 lbs (91 kg)", "214 lbs (97 kg)", "200 lbs (91 kg)", "176 lbs (80 kg)", "165 lbs (75 kg)"};
    public static final transient String[] plays = {"Right-handed", "Right-handed", "Right-handed", "Left-handed", "Right-handed", "Right-handed", "Right-handed", "Right-handed", "Right-handed", "Right-handed"};
    public static final transient int[] turnedpro = {2003, 1998, 2005, 2001, 2000, 2002, 2005, 2004, 2002, 2002};
    public static final transient String[] coachs = {"Marian Vajda", "Paul Annacone", "Ivan Lendl", "Toni Nadal", "Javier Piles", "Tomas Krupa", "Franco Davin", "Roger Rasheed", "none", "Piatti, Grosjean"};
    public static final transient String[] websites = {"http://www.novakdjokovic.com", "http://www.rogerfederer.com", "http://www.andymurray.com", "http://www.rafaelnadal.com", "http://www.davidferrer.com", "http://tomasberdych.cz", "none", "none", "http://www.jtipsarevic.com", "http://richardgasquet.net"};
    public static final transient int[] rankings = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static final transient String[] prizes = {"$45,686,497", "$76,014,777", "$24,934,421", "$50,061,827", "$17,178,869", "$13,139,293", "$10,853,349", "$10,676,927", "$6,600,238", "$7,540,613"};
    public static final transient String[] bnames = {"Rodriguez", "Wells", "Santana", "Teixeira", "Sabathia"};
    public static final transient String[] bsurnames = {"Alex", "Vernon", "Johan", "Mark", "CC"};
    public static final transient int[] bages = {37, 34, 33, 32, 32};
    public static final transient Date[] bbirths = new Date[5];
    public static final transient String[] bpositions = {"Third baseman / Shortstop", "Outfielder", "Starting pitcher", "First baseman", "Starting pitcher"};

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
        calendar.set(1975, Calendar.JULY, 27); //27.07.1975
        bbirths[0] = calendar.getTime();
        calendar.clear();
        calendar.set(1978, Calendar.DECEMBER, 8); //08.12.1978 
        bbirths[1] = calendar.getTime();
        calendar.clear();
        calendar.set(1979, Calendar.MARCH, 13); //13.03.1979  
        bbirths[2] = calendar.getTime();
        calendar.clear();
        calendar.set(1980, Calendar.APRIL, 11); //11.04.1980
        bbirths[3] = calendar.getTime();
        calendar.clear();
        calendar.set(1980, Calendar.JULY, 21); //21.07.1980
        bbirths[4] = calendar.getTime();
        calendar.clear();
    }
}
