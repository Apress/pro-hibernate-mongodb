package eshop.embedded;

import java.io.Serializable;
import javax.persistence.Embeddable;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author Apress
 */
@Embeddable
public class CartProducts implements Serializable {

    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String sku;
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String name;
    @NumericField
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private double price;
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String color;
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String size;
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String quantity;
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)    
    private String uin;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }          
}
