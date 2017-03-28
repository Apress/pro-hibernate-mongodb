package mongodb_query;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import mongodb.helper.Helper;
import org.joda.time.DateTime;

/**
 *
 * @author Apress
 */
public class MONGODB_QUERY {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // connect to the MongoDB store
            Mongo mongo = new Mongo("127.0.0.1", 27017);

            // get the MongoDB database, helloworld_db
            DB db = mongo.getDB("players_db");

            //get the MongoDB collection named helloworld
            DBCollection dbCollection = db.getCollection("players");

            // create and persist several documents
            List<DBObject> players = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                int player = new Random().nextInt(9);

                BasicDBObject basicDBObject = new BasicDBObject();
                basicDBObject.put("name", Helper.names[player]);
                basicDBObject.append("surname", Helper.surnames[player]);
                basicDBObject.append("age", Helper.ages[player]);
                basicDBObject.append("birth", Helper.births[player]);

                // save the document into players collection
                players.add(basicDBObject);
            }

            dbCollection.insert(players);

            System.out.println("MongoDB has stored the players!");

            System.out.println("Quering players database ...");

            System.out.println("Counting documents in collection:");
            System.out.println(dbCollection.getCount());

            System.out.println("Find the first document in collection:");
            DBObject first = dbCollection.findOne();
            System.out.println(first);

            System.out.println("Find all documents in collection:");
            try (DBCursor cursor = dbCollection.find()) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("Find Rafael Nadal documents:");
            BasicDBObject query = new BasicDBObject("name", "Nadal").append("surname", "Rafael");
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("Find players with age > 25:");
            query = new BasicDBObject("age", new BasicDBObject("$gt", 25));
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("Find players with age < 28:");
            query = new BasicDBObject("age", new BasicDBObject("$lt", 28));
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("JAVA - Find players with birthday between 1 January, 1982 - 31 December, 1985:");
            Calendar calendar_begin = GregorianCalendar.getInstance();
            calendar_begin.clear();
            calendar_begin.set(1982, Calendar.JANUARY, 1);
            Calendar calendar_end = GregorianCalendar.getInstance();
            calendar_end.clear();
            calendar_end.set(1985, Calendar.DECEMBER, 31);
            query = new BasicDBObject("birth", new BasicDBObject("$gte", calendar_begin.getTime()).append("$lte", calendar_end.getTime()));
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("JODA - Find players with birthday between 1 January, 1982 - 31 December, 1985:");
            DateTime joda_calendar_begin = new DateTime(1982, 1, 1, 0, 0);
            DateTime joda_calendar_end = new DateTime(1985, 12, 31, 0, 0);
            query = new BasicDBObject("birth", new BasicDBObject("$gte", joda_calendar_begin.toDate()).append("$lte", joda_calendar_end.toDate()));
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("Find players with ages: 25, 27, 30");
            List<Integer> list = new ArrayList<>();
            list.add(25);
            list.add(27);
            list.add(30);
            query = new BasicDBObject("age", new BasicDBObject("$in", list));
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            System.out.println("Find players with ages different from: 27");
            query = new BasicDBObject("age", new BasicDBObject("$ne", 27));
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            //perform a few updates
            //update player Rafael Nadal, as Rafael Nadal Parera
            System.out.println("UPDATING ...");
            query = new BasicDBObject("name", "Nadal").append("surname", "Rafael");
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    DBObject item = cursor.next();
                    item.put("name", "Nadal Parera");
                    dbCollection.save(item);
                }
            }

            //perform a delete
            //delete player Roger Federer
            System.out.println("DELETING ...");
            query = new BasicDBObject("name", "Federer").append("surname", "Roger");
            try (DBCursor cursor = dbCollection.find(query)) {
                while (cursor.hasNext()) {
                    DBObject item = cursor.next();
                    dbCollection.remove(item);
                }
            }

        } catch (UnknownHostException | MongoException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }
}
