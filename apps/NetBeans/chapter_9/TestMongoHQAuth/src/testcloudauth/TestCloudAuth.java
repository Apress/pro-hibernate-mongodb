package testcloudauth;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;

/**
 *
 * @author Apress
 */
public class TestCloudAuth {

    //for MongoHQ
    private static final String MONGO_HOST_HQ = "linus.mongohq.com";
    private static final int MONGO_PORT_HQ = 10039;
    private static final String MONGO_USER_HQ = "admin";
    private static final String MONGO_PASSWORD_HQ = "eshop";
    private static final String MONGO_DATABASE_HQ = "eshop_db";
    //for MongoLab
    private static final String MONGO_HOST_LAB = "ds029107.mongolab.com";
    private static final int MONGO_PORT_LAB = 29107;
    private static final String MONGO_USER_LAB = "admin";
    private static final String MONGO_PASSWORD_LAB = "eshop";
    private static final String MONGO_DATABASE_LAB = "eshop_db";

    public static void main(String[] args) {
        try {

            Mongo mongo_hq = new Mongo(MONGO_HOST_HQ, MONGO_PORT_HQ);
            DB db_hq = mongo_hq.getDB(MONGO_DATABASE_HQ);
            Mongo mongo_lab = new Mongo(MONGO_HOST_LAB, MONGO_PORT_LAB);
            DB db_lab = mongo_lab.getDB(MONGO_DATABASE_LAB);

            boolean auth_hq = db_hq.authenticate(MONGO_USER_HQ, MONGO_PASSWORD_HQ.toCharArray());
            boolean auth_lab = db_lab.authenticate(MONGO_USER_LAB, MONGO_PASSWORD_LAB.toCharArray());

            if (auth_hq) {

                System.out.println("Connected at MongoHQ:");
                DBCollection collection_categories_c_hq = db_hq.getCollection("categories_c");
                DBCollection collection_customers_c_hq = db_hq.getCollection("customers_c");
                DBCollection collection_inventory_c_hq = db_hq.getCollection("inventory_c");
                DBCollection collection_products_c_hq = db_hq.getCollection("products_c");
                DBCollection collection_orders_c_hq = db_hq.getCollection("orders_c");
                System.out.println("TOTAL DOCUMENTS IN categories_c (MongoHQ):" + collection_categories_c_hq.count());
                System.out.println("TOTAL DOCUMENTS IN customers_c (MongoHQ):" + collection_customers_c_hq.count());
                System.out.println("TOTAL DOCUMENTS IN inventory_c (MongoHQ):" + collection_inventory_c_hq.count());
                System.out.println("TOTAL DOCUMENTS IN products_c (MongoHQ):" + collection_products_c_hq.count());
                System.out.println("TOTAL DOCUMENTS IN orders_c (MongoHQ):" + collection_orders_c_hq.count());
            } else {
                System.out.println("Sorry, connection to MongoHQ (eshop_db database) failed ...");
            }

            if (auth_lab) {
                System.out.println("Connected at Mongolab:");
                DBCollection collection_categories_c_lab = db_lab.getCollection("categories_c");
                DBCollection collection_customers_c_lab = db_lab.getCollection("customers_c");
                DBCollection collection_inventory_c_lab = db_lab.getCollection("inventory_c");
                DBCollection collection_products_c_lab = db_lab.getCollection("products_c");
                DBCollection collection_orders_c_lab = db_lab.getCollection("orders_c");
                System.out.println("TOTAL DOCUMENTS IN categories_c (Mongolab):" + collection_categories_c_lab.count());
                System.out.println("TOTAL DOCUMENTS IN customers_c (Mongolab):" + collection_customers_c_lab.count());
                System.out.println("TOTAL DOCUMENTS IN inventory_c (Mongolab):" + collection_inventory_c_lab.count());
                System.out.println("TOTAL DOCUMENTS IN products_c (Mongolab):" + collection_products_c_lab.count());
                System.out.println("TOTAL DOCUMENTS IN orders_c (Mongolab):" + collection_orders_c_lab.count());
            } else {
                System.out.println("Sorry, connection to Mongolab (eshop_db database) failed ...");
            }
        } catch (UnknownHostException | MongoException e) {
            System.err.println(e.getMessage());
        }
    }
}
