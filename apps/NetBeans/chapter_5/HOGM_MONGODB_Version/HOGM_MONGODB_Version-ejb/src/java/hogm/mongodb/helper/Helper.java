package hogm.mongodb.helper;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class Helper {

    public static final transient String[] names = {"Djokovic", "Federer", "Murray", "Nadal", "Ferrer", "Berdych", "Del Potro", "Tsonga", "Tipsarevic", "Gasquet"};
    public static final transient String[] surnames = {"Novak", "Roger", "Andy", "Rafael", "David", "Tomas", "Juan Martin", "Jo-Wilfried", "Janko", "Richard"};
    public static final transient int[] ages = {25, 31, 25, 26, 30, 27, 24, 27, 28, 26};
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
}
