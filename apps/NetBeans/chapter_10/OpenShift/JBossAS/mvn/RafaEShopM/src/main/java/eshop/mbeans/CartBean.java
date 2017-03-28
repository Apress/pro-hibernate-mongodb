package eshop.mbeans;

import eshop.beans.EShopBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Apress
 */
@Named("cart")
@SessionScoped
public class CartBean implements Serializable {

    @Inject
    private EShopBean eShopBean;
    private String p_sku;
    private String p_name;
    private double p_price;
    private String p_color;
    private String p_size;
    private int p_quantity;
    private double payment;
    private int products_nr;
    private String city;
    private String state;
    private String street;
    private String number;
    private String zip;
    private String country;
    private String phone;
    private String fax;
    private List<String> shopping_cart = new ArrayList<String>();

    public String getP_sku() {
        return p_sku;
    }

    public void setP_sku(String p_sku) {
        this.p_sku = p_sku;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }

    public String getP_color() {
        return p_color;
    }

    public void setP_color(String p_color) {
        this.p_color = p_color;
    }

    public String getP_size() {
        return p_size;
    }

    public void setP_size(String p_size) {
        this.p_size = p_size;
    }

    public int getP_quantity() {
        return p_quantity;
    }

    public void setP_quantity(int p_quantity) {
        this.p_quantity = p_quantity;
    }

    public List<String> getShopping_cart() {
        return shopping_cart;
    }

    public double getPayment() {
        return payment;
    }

    public int getProducts_nr() {
        return products_nr;
    }

    public EShopBean geteShopBean() {
        return eShopBean;
    }

    public void seteShopBean(EShopBean eShopBean) {
        this.eShopBean = eShopBean;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void addToCartAction() {

        FacesContext fcx = FacesContext.getCurrentInstance();
        int check_inventory = eShopBean.checkInventory(p_sku, p_color, p_size, p_quantity);

        if (check_inventory == 0) {
            fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Sorry, but this product is not in stock for the moment ...", null));
            return;
        }

        if (check_inventory == -9999) {
            fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "The product was not added to your cart. Sorry for the inconvenient, please try again ...", null));
            return;
        }

        if (check_inventory == p_quantity) {
            payment = payment + p_quantity * p_price;
            products_nr = products_nr + p_quantity;

            fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The product was successfuly added to your cart ...", null));
        } else if (check_inventory != p_quantity) {
            payment = payment + check_inventory * p_price;
            products_nr = products_nr + check_inventory;
            p_quantity = check_inventory;

            fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Only " + check_inventory + " products left! They are in your cart now ...", null));
        }

        String product = "SKU:" + p_sku + " | Name: " + p_name + " | Color: " + p_color + " | Size: " + p_size + " | Price:" + p_price + " | Quantity:" + p_quantity;
        shopping_cart.add(product);
    }

    public void removeFromCartAction(String product) {

        int quantity = 0;
        String sku = "";
        String color = "";
        String size = "";
        double price = 0;

        FacesContext fcx = FacesContext.getCurrentInstance();

        StringTokenizer st = new StringTokenizer(product, "|");
        if (st.hasMoreTokens()) {
            String token = st.nextToken();
            sku = token.substring(token.indexOf(":") + 1, token.length()).trim();
            st.nextToken();
            token = st.nextToken();
            color = token.substring(token.indexOf(":") + 1, token.length()).trim();
            token = st.nextToken();
            size = token.substring(token.indexOf(":") + 1, token.length()).trim();
            token = st.nextToken();
            price = Double.valueOf(token.substring(token.indexOf(":") + 1, token.length()).trim());
            token = st.nextToken();
            quantity = Integer.valueOf(token.substring(token.indexOf(":") + 1, token.length()).trim());
        }

        if (quantity > 0) {
            int check_inventory = eShopBean.refreshInventory(sku, color, size, quantity);

            if (check_inventory == quantity) {
                payment = payment - quantity * price;
                products_nr = products_nr - quantity;
            }
            shopping_cart.remove(product);
            fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The product(s) was successfully removed from your shopping cart ...", null));
        }
    }

    public void saveOrderAction() {

        FacesContext fcx = FacesContext.getCurrentInstance();

        if (!shopping_cart.isEmpty()) {
            int save = eShopBean.saveOrder(city, state, street, number, zip, country, phone, fax, shopping_cart, payment);
            if (save == 0) {
                fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Your order was successfully purchased ...", null));
                shopping_cart.clear();
                payment = 0;
                products_nr = 0;
            }
        } else {
            fcx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Your shopping cart is empty ...", null));
        }
    }
}
