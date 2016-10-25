package eshop.entities;

import eshop.embedded.Addresses;
import eshop.embedded.CartProducts;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "orders_c")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @DocumentId
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "order_status")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String status;
    @Column(name = "order_subtotal")
    @NumericField
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private double subtotal;
    @DateBridge(resolution = Resolution.HOUR)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date orderdate;
    @Embedded
    @IndexedEmbedded
    @Basic(fetch = FetchType.EAGER)
    private Addresses shipping_address;
    @IndexedEmbedded
    @ElementCollection(targetClass = eshop.embedded.CartProducts.class,
    fetch = FetchType.EAGER)
    @AttributeOverrides({
        @AttributeOverride(name = "sku",
        column =
        @Column(name = "product_sku")),
        @AttributeOverride(name = "name",
        column =
        @Column(name = "product_name")),
        @AttributeOverride(name = "price",
        column =
        @Column(name = "product_price")),
        @AttributeOverride(name = "color",
        column =
        @Column(name = "product_color")),
        @AttributeOverride(name = "size",
        column =
        @Column(name = "product_size")),
        @AttributeOverride(name = "quantity",
        column =
        @Column(name = "product_quantity")),
        @AttributeOverride(name = "uin",
        column =
        @Column(name = "unique_identification_number")),})
    private List<CartProducts> cart = new ArrayList<CartProducts>(0);
    @IndexedEmbedded
    @ManyToOne(fetch = FetchType.LAZY)
    private Customers customer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Addresses getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(Addresses shipping_address) {
        this.shipping_address = shipping_address;
    }

    public List<CartProducts> getCart() {
        return cart;
    }

    public void setCart(List<CartProducts> cart) {
        this.cart = cart;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }    
    
    @Override
    public boolean equals(Object object) {       
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eshop.entities.Orders[ id=" + id + " ]";
    }
}
