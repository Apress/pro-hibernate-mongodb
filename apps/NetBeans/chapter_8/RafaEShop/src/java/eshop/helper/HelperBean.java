package eshop.helper;

import eshop.embedded.Addresses;
import eshop.entities.Categories;
import eshop.entities.Customers;
import eshop.entities.Inventory;
import eshop.entities.Products;
import java.util.Calendar;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.logging.Logger;

/**
 *
 * @author Apress
 */
@Singleton
@LocalBean
@Named("helperbean")
public class HelperBean {

    @PersistenceContext(unitName = "HOGM_eSHOP-ejbPU")
    private EntityManager em;
    private static final Logger log = Logger.getLogger(HelperBean.class.getName());

    public void populateShop() {

        log.info("Please wait while preparing database data ... ");

        Categories category_tops = new Categories();
        category_tops.setCategory("Tops");
        Categories category_shoes = new Categories();
        category_shoes.setCategory("Shoes");
        Categories category_caps = new Categories();
        category_caps.setCategory("Caps");
        Categories category_wristband = new Categories();
        category_wristband.setCategory("Wristbands");
        Categories category_racquets = new Categories();
        category_racquets.setCategory("Racquets");
        Categories category_calendars = new Categories();
        category_calendars.setCategory("Calendars");
        Categories category_posters = new Categories();
        category_posters.setCategory("Posters");
        Categories category_gadgets = new Categories();
        category_gadgets.setCategory("Gadgets");
        Categories category_collectors = new Categories();
        category_collectors.setCategory("Collectors");

        em.persist(category_tops);
        em.persist(category_shoes);
        em.persist(category_caps);
        em.persist(category_wristband);
        em.persist(category_racquets);
        em.persist(category_calendars);
        em.persist(category_posters);
        em.persist(category_gadgets);
        em.persist(category_collectors);
        em.flush();

        Products tops_1 = new Products();
        tops_1.setSku("TOPS_0001");
        tops_1.setProduct("Bull Logo T-Shirt");
        tops_1.setPrice(26.90);
        tops_1.setOld_price(0.00);
        tops_1.setDescription("This T-Shirt is only for real fans ...");
        tops_1.getColors().add("Khaki");
        tops_1.getColors().add("Red");
        tops_1.getColors().add("Black");
        tops_1.getSizes().add("M");
        tops_1.getSizes().add("L");
        tops_1.getSizes().add("XL");
        tops_1.getSizes().add("XXL");
        tops_1.getGallery().add("tops_0001_1.png");
        tops_1.getGallery().add("tops_0001_2.png");
        tops_1.getGallery().add("tops_0001_3.png");
        tops_1.getGallery().add("tops_0001_4.png");
        tops_1.setCategory(category_tops);
        em.persist(tops_1);

        Products tops_2 = new Products();
        tops_2.setSku("TOPS_0002");
        tops_2.setProduct("Masters Crew T-Shirt");
        tops_2.setPrice(64.95);
        tops_2.setOld_price(0.00);
        tops_2.setDescription("A great T-Shirt for amateur tennis players ...");
        tops_2.getColors().add("Red");
        tops_2.getColors().add("Khaki");
        tops_2.getSizes().add("S");
        tops_2.getSizes().add("M");
        tops_2.getSizes().add("XXL");
        tops_2.getGallery().add("tops_0002_1.png");
        tops_2.getGallery().add("tops_0002_2.png");
        tops_2.getGallery().add("tops_0002_3.png");
        tops_2.setCategory(category_tops);
        em.persist(tops_2);

        Products tops_3 = new Products();
        tops_3.setSku("TOPS_0003");
        tops_3.setProduct("Power Court N98 Jacket");
        tops_3.setPrice(89.90);
        tops_3.setOld_price(0.00);
        tops_3.setDescription("Amazing jacket for tennis fans ...");
        tops_3.getColors().add("Khaki");
        tops_3.getColors().add("Red");
        tops_3.getSizes().add("S");
        tops_3.getSizes().add("L");
        tops_3.getGallery().add("tops_0003_1.png");
        tops_3.getGallery().add("tops_0003_2.png");
        tops_3.getGallery().add("tops_0003_3.png");
        tops_3.getGallery().add("tops_0003_4.png");
        tops_3.getGallery().add("tops_0003_5.png");
        tops_3.setCategory(category_tops);
        em.persist(tops_3);

        Products shoes_1 = new Products();
        shoes_1.setSku("SHOES_0001");
        shoes_1.setProduct("Nike Air Courtballistec 4.3");
        shoes_1.setPrice(104.89);
        shoes_1.setOld_price(0.00);
        shoes_1.setDescription("Lightweight yet durable ...");
        shoes_1.getSizes().add("6.5");
        shoes_1.getSizes().add("7");
        shoes_1.getSizes().add("8");
        shoes_1.getSizes().add("8.5");
        shoes_1.getSizes().add("9");
        shoes_1.getSizes().add("9.5");
        shoes_1.getSizes().add("10");
        shoes_1.getSizes().add("10.5");
        shoes_1.getSizes().add("11");
        shoes_1.getSizes().add("11.5");
        shoes_1.getSizes().add("12");
        shoes_1.getSizes().add("14");
        shoes_1.getGallery().add("shoes_0001_1.png");
        shoes_1.getGallery().add("shoes_0001_2.png");
        shoes_1.getGallery().add("shoes_0001_3.png");
        shoes_1.getGallery().add("shoes_0001_4.png");
        shoes_1.setCategory(category_shoes);
        em.persist(shoes_1);

        Products caps_1 = new Products();
        caps_1.setSku("CAPS_0001");
        caps_1.setProduct("Holiday Bull Logo Hat");
        caps_1.setPrice(26.90);
        caps_1.setOld_price(0.00);
        caps_1.setDescription("Cap of polyester circular knit mesh ...");
        caps_1.getColors().add("Khaki");
        caps_1.getColors().add("Black");
        caps_1.getGallery().add("caps_0001_1.png");
        caps_1.getGallery().add("caps_0001_2.png");
        caps_1.setCategory(category_caps);
        em.persist(caps_1);

        Products caps_2 = new Products();
        caps_2.setSku("CAPS_0002");
        caps_2.setProduct("Nike Bull Logo hat");
        caps_2.setPrice(29.00);
        caps_2.setOld_price(0.00);
        caps_2.setDescription("Great cap for sunny days ...");
        caps_2.getColors().add("Red");
        caps_2.getGallery().add("caps_0002_1.png");
        caps_2.setCategory(category_caps);
        em.persist(caps_2);

        Products caps_3 = new Products();
        caps_3.setSku("CAPS_0003");
        caps_3.setProduct("Nike Summer Bandana");
        caps_3.setPrice(13.00);
        caps_3.setOld_price(0.00);
        caps_3.setDescription("Bandana for hot summer days ...");
        caps_3.getGallery().add("caps_0003_1.png");
        caps_3.getColors().add("Black");
        caps_3.getColors().add("White");
        caps_3.setCategory(category_caps);
        em.persist(caps_3);

        Products wristband_1 = new Products();
        wristband_1.setSku("WRISTBANDS_0001");
        wristband_1.setProduct("Foundation Wristband");
        wristband_1.setPrice(15.00);
        wristband_1.setOld_price(0.00);
        wristband_1.setDescription("Foundation Official Wristband ...");
        wristband_1.getGallery().add("wristband_0001_1.png");
        wristband_1.getColors().add("Green");
        wristband_1.setCategory(category_wristband);
        em.persist(wristband_1);

        Products racquet_1 = new Products();
        racquet_1.setSku("RACQUET_0001");
        racquet_1.setProduct("Babolat AeroPro Drive GT Junior 26");
        racquet_1.setPrice(89.00);
        racquet_1.setOld_price(99.00);
        racquet_1.setDescription("Aerodynamic for a faster stroke ...");
        racquet_1.getGallery().add("racquet_0001_1.png");
        racquet_1.setCategory(category_racquets);
        em.persist(racquet_1);

        Products racquet_2 = new Products();
        racquet_2.setSku("RACQUET_0002");
        racquet_2.setProduct("Babolat AeroPro Drive GT Raquet");
        racquet_2.setPrice(186.00);
        racquet_2.setOld_price(219.00);
        racquet_2.setDescription("Great control, amazing spin ...");
        racquet_2.getSizes().add("L1");
        racquet_2.getSizes().add("L2");
        racquet_2.getSizes().add("L3");
        racquet_2.getGallery().add("racquet_0002_1.png");
        racquet_2.getGallery().add("racquet_0002_2.png");
        racquet_2.getGallery().add("racquet_0002_3.png");
        racquet_2.setCategory(category_racquets);
        em.persist(racquet_2);

        Products racquet_3 = new Products();
        racquet_3.setSku("RACQUET_0003");
        racquet_3.setProduct("Babolat Aero Back-Pack 2013");
        racquet_3.setPrice(61.50);
        racquet_3.setOld_price(0.00);
        racquet_3.setDescription("Can store up to 2 racquets without covers ...");
        racquet_3.getGallery().add("racquet_0003_1.png");
        racquet_3.getGallery().add("racquet_0003_2.png");
        racquet_3.getGallery().add("racquet_0003_3.png");
        racquet_3.getGallery().add("racquet_0003_4.png");
        racquet_3.setCategory(category_racquets);
        em.persist(racquet_3);

        Products racquet_4 = new Products();
        racquet_4.setSku("RACQUET_0004");
        racquet_4.setProduct("Babolat Aero Line Black/Yellow 12 Pack Bag");
        racquet_4.setPrice(73.00);
        racquet_4.setOld_price(0.00);
        racquet_4.setDescription("Dual racquet compartments are thermo-lined ...");
        racquet_4.getGallery().add("racquet_0004_1.png");
        racquet_4.getGallery().add("racquet_0004_2.png");
        racquet_4.getGallery().add("racquet_0004_3.png");
        racquet_4.getGallery().add("racquet_0004_4.png");
        racquet_4.setCategory(category_racquets);
        em.persist(racquet_4);

        Products calendar_1 = new Products();
        calendar_1.setSku("CALENDAR_0001");
        calendar_1.setProduct("Official 2013 Calendar");
        calendar_1.setPrice(14.95);
        calendar_1.setOld_price(0.00);
        calendar_1.setDescription("The official Rafa Nadal Calendar 2013 features ...");
        calendar_1.getGallery().add("calendar_0001_1.png");
        calendar_1.getGallery().add("calendar_0001_2.png");
        calendar_1.getGallery().add("calendar_0001_3.png");
        calendar_1.getGallery().add("calendar_0001_4.png");
        calendar_1.setCategory(category_calendars);
        em.persist(calendar_1);

        Products calendar_2 = new Products();
        calendar_2.setSku("CALENDAR_0002");
        calendar_2.setProduct("Official 2012 Calendar");
        calendar_2.setPrice(5.95);
        calendar_2.setOld_price(14.95);
        calendar_2.setDescription("The official Rafa Nadal Calendar 2012 features ...");
        calendar_2.getGallery().add("calendar_0002_1.png");
        calendar_2.getGallery().add("calendar_0002_2.png");
        calendar_2.getGallery().add("calendar_0002_3.png");
        calendar_2.getGallery().add("calendar_0002_4.png");
        calendar_2.setCategory(category_calendars);
        em.persist(calendar_2);

        Products calendar_3 = new Products();
        calendar_3.setSku("CALENDAR_0003");
        calendar_3.setProduct("Rafael Nadal 2012 desktop calendar");
        calendar_3.setPrice(2.95);
        calendar_3.setOld_price(4.95);
        calendar_3.setDescription("The most beautiful and exciting moments of the last season ...");
        calendar_3.getGallery().add("calendar_0003_1.png");
        calendar_3.getGallery().add("calendar_0003_2.png");
        calendar_3.getGallery().add("calendar_0003_3.png");
        calendar_3.getGallery().add("calendar_0003_4.png");
        calendar_3.setCategory(category_calendars);
        em.persist(calendar_3);

        Products calendar_4 = new Products();
        calendar_4.setSku("CALENDAR_0004");
        calendar_4.setProduct("Rafael Nadal 2010 Calendar");
        calendar_4.setPrice(2.95);
        calendar_4.setOld_price(5.95);
        calendar_4.setDescription("The official Rafa Nadal Calendar 2010 features ...");
        calendar_4.getGallery().add("calendar_0004_1.png");
        calendar_4.getGallery().add("calendar_0004_2.png");
        calendar_4.getGallery().add("calendar_0004_3.png");
        calendar_4.getGallery().add("calendar_0004_4.png");
        calendar_4.setCategory(category_calendars);
        em.persist(calendar_4);

        Products calendar_5 = new Products();
        calendar_5.setSku("CALENDAR_0005");
        calendar_5.setProduct("Rafael Nadal 2010 desktop calendar");
        calendar_5.setPrice(2.95);
        calendar_5.setOld_price(5.90);
        calendar_5.setDescription("The most beautiful and exciting moments of 2009 ...");
        calendar_5.getGallery().add("calendar_0005_1.png");
        calendar_5.getGallery().add("calendar_0005_2.png");
        calendar_5.getGallery().add("calendar_0005_3.png");
        calendar_5.getGallery().add("calendar_0005_4.png");
        calendar_5.setCategory(category_calendars);
        em.persist(calendar_5);

        Products poster_1 = new Products();
        poster_1.setSku("POSTER_0001");
        poster_1.setProduct("HIS7ORY Poster");
        poster_1.setPrice(15.95);
        poster_1.setOld_price(0.00);
        poster_1.setDescription("Limited Edition HIS7ORY Poster to celebrate the seven French Open trophies ...");
        poster_1.getGallery().add("poster_0001_1.png");
        poster_1.setCategory(category_posters);
        em.persist(poster_1);

        Products poster_2 = new Products();
        poster_2.setSku("POSTER_0002");
        poster_2.setProduct("Life Size US Open vinyl sticker");
        poster_2.setPrice(49.50);
        poster_2.setOld_price(69.95);
        poster_2.setDescription("Life size vinyl sticker for smooth surfaces ...");
        poster_2.getGallery().add("poster_0002_1.png");
        poster_2.setCategory(category_posters);
        em.persist(poster_2);

        Products poster_3 = new Products();
        poster_3.setSku("POSTER_0003");
        poster_3.setProduct("Life Size Roland Garros vinyl sticker");
        poster_3.setPrice(49.50);
        poster_3.setOld_price(69.95);
        poster_3.setDescription("High definition image printed in high quality ...");
        poster_3.getGallery().add("poster_0003_1.png");
        poster_3.setCategory(category_posters);
        em.persist(poster_3);

        Products gadget_1 = new Products();
        gadget_1.setSku("GAGDGET_0001");
        gadget_1.setProduct("Black Portable Battery Charger");
        gadget_1.setPrice(49.50);
        gadget_1.setOld_price(0.00);
        gadget_1.setDescription("Portable battery charger for smartphones ...");
        gadget_1.getGallery().add("gadget_0001_1.png");
        gadget_1.getGallery().add("gadget_0001_2.png");
        gadget_1.setCategory(category_gadgets);
        em.persist(gadget_1);

        Products gadget_2 = new Products();
        gadget_2.setSku("GAGDGET_0002");
        gadget_2.setProduct("Silver portable Battery Charger");
        gadget_2.setPrice(49.50);
        gadget_2.setOld_price(0.00);
        gadget_2.setDescription("Portable battery charger for smartphones ...");
        gadget_2.getGallery().add("gadget_0002_1.png");
        gadget_2.getGallery().add("gadget_0002_2.png");
        gadget_2.setCategory(category_gadgets);
        em.persist(gadget_2);

        Products gadget_3 = new Products();
        gadget_3.setSku("GAGDGET_0003");
        gadget_3.setProduct("USB Stick");
        gadget_3.setPrice(14.99);
        gadget_3.setOld_price(0.00);
        gadget_3.setDescription("2 GB USB stick with Foundation logo ...");
        gadget_3.getGallery().add("gadget_0003_1.png");
        gadget_3.getGallery().add("gadget_0003_2.png");
        gadget_3.setCategory(category_gadgets);
        em.persist(gadget_3);

        Products collector_1 = new Products();
        collector_1.setSku("COLLECTOR_0001");
        collector_1.setProduct("Nike Rafa Bull Logo Foundation Hat");
        collector_1.setPrice(150.00);
        collector_1.setOld_price(0.00);
        collector_1.setDescription("Auotgraphed Hatbull cap ...");
        collector_1.getGallery().add("collector_0001_1.png");
        collector_1.getGallery().add("collector_0001_2.png");
        collector_1.setCategory(category_collectors);
        em.persist(collector_1);

        Products collector_2 = new Products();
        collector_2.setSku("COLLECTOR_0002");
        collector_2.setProduct("The court in your hands");
        collector_2.setPrice(49.50);
        collector_2.setOld_price(65.00);
        collector_2.setDescription("A unique occasion to help children and obtain a piece of history: a sample of the court where ...");
        collector_2.getGallery().add("collector_0002_1.png");
        collector_2.getGallery().add("collector_0002_2.png");
        collector_2.getGallery().add("collector_0002_3.png");
        collector_2.setCategory(category_collectors);
        em.persist(collector_2);

        Customers customer_1 = new Customers();
        Addresses address_c_1 = new Addresses();
        address_c_1.setCity("Sacramento");
        address_c_1.setCountry("United States of America");
        address_c_1.setState("California");
        address_c_1.setStreet("10th St");
        address_c_1.setZip("94203");
        address_c_1.setNumber("234");
        address_c_1.setPhone("(916) 485-2338");
        address_c_1.setFax("+44 131 888 8888");
        customer_1.setEmail("tom@yahoo.com");
        customer_1.setPassword("tomandrafa");
        customer_1.setName("Tomas");
        customer_1.setSurname("Berg");
        customer_1.setRegistration(Calendar.getInstance().getTime());
        customer_1.setCustomer_address_1(address_c_1);

        Customers customer_2 = new Customers();
        Addresses address_c_2 = new Addresses();
        address_c_2.setCity("Minneapolis");
        address_c_2.setCountry("United States of America");
        address_c_2.setState("Minnesota");
        address_c_2.setStreet("36th St");
        address_c_2.setZip("55403");
        address_c_2.setNumber("90");
        address_c_2.setPhone("(952) 679-7873");
        address_c_2.setFax("+44 137 838 8845");
        customer_2.setEmail("john@yahoo.com");
        customer_2.setPassword("johnandrafa");
        customer_2.setName("John");
        customer_2.setSurname("Malek");
        customer_2.setRegistration(Calendar.getInstance().getTime());
        customer_2.setCustomer_address_1(address_c_2);

        Customers customer_3 = new Customers();
        Addresses address_c_3 = new Addresses();
        address_c_3.setCity("Campina");
        address_c_3.setCountry("Romania");
        address_c_3.setState("Prahova");
        address_c_3.setStreet("N. Iorga");
        address_c_3.setNumber("101");
        address_c_3.setZip("106044");
        address_c_3.setPhone("(0727) 249423");
        address_c_3.setFax("+44 137 538 1222");
        Addresses address_c_4 = new Addresses();
        address_c_4.setCity("Banesti");
        address_c_4.setCountry("Romania");
        address_c_4.setState("Prahova");
        address_c_4.setStreet("Nationala");
        address_c_4.setZip("107050");
        address_c_4.setNumber("118");
        address_c_4.setPhone("(0727) 249423");
        address_c_4.setFax("+44 137 538 1222");
        customer_3.setEmail("marian@yahoo.com");
        customer_3.setPassword("marianandrafa");
        customer_3.setName("Marian");
        customer_3.setSurname("Iordache");
        customer_3.setRegistration(Calendar.getInstance().getTime());
        customer_3.setCustomer_address_1(address_c_3);
        customer_3.setCustomer_address_2(address_c_4);        

        Inventory inv;
        //TOPS 0001
        int invrnd = 2 + new Random().nextInt(18);
        inv = new Inventory();
        inv.setSku("TOPS_0001");
        inv.setSku_color("Black");
        inv.setSku_size("M");
        inv.setInventory(invrnd);
        em.persist(inv);

        inv = new Inventory();
        inv.setSku("TOPS_0001");
        inv.setSku_color("Black");
        inv.setSku_size("L");
        inv.setInventory(invrnd);
        em.persist(inv);

        inv = new Inventory();
        inv.setSku("TOPS_0001");
        inv.setSku_color("Black");
        inv.setSku_size("XL");
        inv.setInventory(invrnd);
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Black");
        inv.setSku_size("XXL");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Red");
        inv.setSku_size("M");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Red");
        inv.setSku_size("L");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Red");
        inv.setSku_size("XL");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Red");
        inv.setSku_size("XXL");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Khaki");
        inv.setSku_size("M");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Khaki");
        inv.setSku_size("L");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Khaki");
        inv.setSku_size("XL");
        em.persist(inv);

        //TOPS 0002
        invrnd = 2 + new Random().nextInt(18);
        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0001");
        inv.setSku_color("Khaki");
        inv.setSku_size("XXL");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0002");
        inv.setSku_color("Red");
        inv.setSku_size("S");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0002");
        inv.setSku_color("Red");
        inv.setSku_size("M");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0002");
        inv.setSku_color("Red");
        inv.setSku_size("XXL");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0002");
        inv.setSku_color("Khaki");
        inv.setSku_size("S");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0002");
        inv.setSku_color("Khaki");
        inv.setSku_size("M");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0002");
        inv.setSku_color("Khaki");
        inv.setSku_size("XXL");
        em.persist(inv);

        //TOPS 0003
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0003");
        inv.setSku_color("Red");
        inv.setSku_size("S");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0003");
        inv.setSku_color("Red");
        inv.setSku_size("L");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0003");
        inv.setSku_color("Khaki");
        inv.setSku_size("S");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("TOPS_0003");
        inv.setSku_color("Khaki");
        inv.setSku_size("L");
        em.persist(inv);

        //SHOES_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("6.5");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("7");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("8");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("8.5");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("9");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("9.5");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("10");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("10.5");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("11");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("11.5");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("12");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("SHOES_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("14");
        em.persist(inv);

        //CAPS 0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CAPS_0001");
        inv.setSku_color("Khaki");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CAPS_0001");
        inv.setSku_color("Black");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CAPS 0002
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CAPS_0002");
        inv.setSku_color("Red");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CAPS 0003
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CAPS_0003");
        inv.setSku_color("Black");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CAPS_0003");
        inv.setSku_color("White");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //WRISTBANDS_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("WRISTBANDS_0001");
        inv.setSku_color("Green");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //RACQUET_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("RACQUET_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //RACQUET_0002
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("RACQUET_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("L1");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("RACQUET_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("L2");
        em.persist(inv);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("RACQUET_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("L3");
        em.persist(inv);

        //RACQUET_0003
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("RACQUET_0003");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //RACQUET_0004
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("RACQUET_0004");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CALENDAR_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CALENDAR_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CALENDAR_0002
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CALENDAR_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CALENDAR_0003
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CALENDAR_0003");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CALENDAR_0004
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CALENDAR_0004");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //CALENDAR_0005
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("CALENDAR_0005");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //POSTER_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("POSTER_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //POSTER_0002
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("POSTER_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //POSTER_0003
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("POSTER_0003");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //GAGDGET_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("GAGDGET_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //GAGDGET_0002
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("GAGDGET_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //GAGDGET_0003
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("GAGDGET_0003");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //COLLECTOR_0001
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("COLLECTOR_0001");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        //COLLECTOR_0002
        invrnd = 2 + new Random().nextInt(18);

        inv = new Inventory();
        inv.setInventory(invrnd);
        inv.setSku("COLLECTOR_0002");
        inv.setSku_color("Unavailable");
        inv.setSku_size("Unavailable");
        em.persist(inv);

        log.info("Please wait while populating database ... ");

        em.persist(customer_1);
        em.persist(customer_2);
        em.persist(customer_3);

        log.info("Database successfully populated ... ");
    }
}
