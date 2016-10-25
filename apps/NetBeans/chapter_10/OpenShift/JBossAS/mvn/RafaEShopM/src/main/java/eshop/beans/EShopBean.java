package eshop.beans;

import eshop.embedded.Addresses;
import eshop.embedded.CartProducts;
import eshop.embedded.InventoryPK;
import eshop.entities.Categories;
import eshop.entities.Customers;
import eshop.entities.Inventory;
import eshop.entities.Orders;
import eshop.entities.Products;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.DatabaseRetrievalMethod;
import org.hibernate.search.query.ObjectLookupMethod;
import org.hibernate.search.query.dsl.QueryBuilder;

/**
 *
 * @author Apress
 */
@Stateless
@LocalBean
public class EShopBean {

    @PersistenceContext(unitName = "HOGM_eSHOP-ejbPU")
    private EntityManager em;
    //private static final Logger log = Logger.getLogger(EShopBean.class.getName());

    // loading categories ids and names
    public List<String> extractCategories() {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);       
        
        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Categories.class).get();
        org.apache.lucene.search.Query query = queryBuilder.all().createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Categories.class);
        fullTextQuery.setProjection(FullTextQuery.ID, "category");
        Sort sort = new Sort(new SortField("category", SortField.STRING));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List results = fullTextQuery.getResultList();

        return results;
    }

    // loading products of a category
    public Map<Integer, List<Products>> extractProducts(String name, int page) {
     
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Products.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("category.id").matching(name).createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Products.class);
        Sort sort = new Sort(new SortField("price", SortField.DOUBLE));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        fullTextQuery.setFirstResult(page * 3);
        fullTextQuery.setMaxResults(3);
        List<Products> results = fullTextQuery.getResultList();

        Map<Integer, List<Products>> results_and_total = new HashMap<Integer, List<Products>>();
        results_and_total.put(fullTextQuery.getResultSize(), results);

        return results_and_total;
    }

    //search a product by name
    public List<Products> searchProducts(String search) {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Products.class).get();
        org.apache.lucene.search.Query query = queryBuilder.keyword().onField("product").matching(search).createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Products.class);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);
        fullTextQuery.setMaxResults(3);

        List results = fullTextQuery.getResultList();

        return results;
    }

    // loading promotional products
    public List<Products> extractPromotionalProducts() {
    
        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Products.class).get();
        org.apache.lucene.search.Query query = queryBuilder.range().onField("old_price").above(0.1).createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Products.class);
        Sort sort = new Sort(new SortField("price", SortField.DOUBLE));
        fullTextQuery.setSort(sort);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List results = fullTextQuery.getResultList();

        return results;
    }

    //locate a customer in the database
    public Customers extractCustomer(String email, String password) {

        FullTextEntityManager fullTextEntityManager = org.hibernate.search.jpa.Search.getFullTextEntityManager(em);

        QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Customers.class).get();
        org.apache.lucene.search.Query query = queryBuilder.bool().must(queryBuilder.keyword()
                .onField("email").matching(email).createQuery()).must(queryBuilder.keyword()
                .onField("password").matching(password).createQuery()).createQuery();

        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Customers.class);

        fullTextQuery.initializeObjectsWith(ObjectLookupMethod.SKIP, DatabaseRetrievalMethod.FIND_BY_ID);

        List results = fullTextQuery.getResultList();

        if (results.isEmpty()) {
            return null;
        }

        return (Customers) results.get(0);
    }

    //save an order to database
    public int saveOrder(String city, String state, String street, String number, String zip, String country, String phone, String fax, List<String> shopping_cart, double payment) {

        String[] customers = {"tom@yahoo.com", "john@yahoo.com", "marian@yahoo.com"};
        String[] passwords = {"tomandrafa", "johnandrafa", "marianandrafa"};

        int choose = new Random().nextInt(2);

        Customers customer = this.extractCustomer(customers[choose], passwords[choose]);
        Orders new_order = new Orders();
        Addresses shipping_address = new Addresses();

        if (customer != null) {
            for (String product : shopping_cart) {
                StringTokenizer st = new StringTokenizer(product, "|");
                CartProducts cart_product = new CartProducts();
                if (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    cart_product.setSku(token.substring(token.indexOf(":") + 1, token.length()).trim());
                    token = st.nextToken();
                    cart_product.setName(token.substring(token.indexOf(":") + 1, token.length()).trim());
                    token = st.nextToken();
                    cart_product.setColor(token.substring(token.indexOf(":") + 1, token.length()).trim());
                    token = st.nextToken();
                    cart_product.setSize(token.substring(token.indexOf(":") + 1, token.length()).trim());
                    token = st.nextToken();
                    cart_product.setPrice(Double.valueOf(token.substring(token.indexOf(":") + 1, token.length()).trim()));
                    token = st.nextToken();
                    cart_product.setQuantity(token.substring(token.indexOf(":") + 1, token.length()).trim());
                }

                cart_product.setUin(String.valueOf(1000000 + new Random().nextInt(1000000)));
                new_order.getCart().add(cart_product);
            }          

            shipping_address.setCity(city);
            shipping_address.setCountry(country);
            shipping_address.setFax(fax);
            shipping_address.setNumber(number);
            shipping_address.setPhone(phone);
            shipping_address.setState(state);
            shipping_address.setStreet(street);
            shipping_address.setZip(zip);
            new_order.setShipping_address(shipping_address);
            new_order.setSubtotal(payment);
            new_order.setStatus("PURCHASED");
            new_order.setOrderdate(Calendar.getInstance().getTime());

            new_order.setCustomer(customer);            
            em.persist(new_order);

        } else {
            //the customer credentials were not found in the database
        }

        return 0;
    }

    //extract from inventory
    public int checkInventory(String sku, String color, String size, int quantity) {
     
        InventoryPK pk = new InventoryPK(sku, color, size);

        Inventory inventory = em.find(Inventory.class, pk, LockModeType.OPTIMISTIC);
        int amount = inventory.getInventory();
        if (amount > 0) {
            if (amount >= quantity) {
                amount = amount - quantity;
                inventory.setInventory(amount);
                try {
                    em.merge(inventory);
                } catch (OptimisticLockException e) {
                    return -9999;
                }

                return quantity;
            } else {
                inventory.setInventory(0);
                try {
                    em.merge(inventory);
                } catch (OptimisticLockException e) {
                    return -9999;
                }

                return amount;
            }
        } else {
            return amount;
        }
    }

    //restore inventory when a product was removed from shopping cart
    public int refreshInventory(String sku, String color, String size, int quantity) {      

        InventoryPK pk = new InventoryPK(sku, color, size);

        Inventory inventory = em.find(Inventory.class, pk, LockModeType.OPTIMISTIC);
        int amount = inventory.getInventory();

        amount = amount + quantity;

        inventory.setInventory(amount);

        try {
            em.merge(inventory);
        } catch (OptimisticLockException e) {
            return -9999;
        }

        return quantity;
    }
}
