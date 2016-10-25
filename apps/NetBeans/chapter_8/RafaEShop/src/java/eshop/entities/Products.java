package eshop.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author Apress
 */
@Entity
@Indexed
@Table(name = "products_c")
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @DocumentId
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "product_sku")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String sku;
    @Column(name = "product_name")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String product;
    @Column(name = "product_price")
    @NumericField
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private double  price;
    @Column(name = "product_old_price")
    @NumericField
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private double old_price;    
    @Column(name = "product_description")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String description;
    @IndexedEmbedded
    @ManyToOne(fetch = FetchType.LAZY)    
    private Categories category;
    @IndexedEmbedded
    @ElementCollection(targetClass = java.lang.String.class, fetch = FetchType.EAGER)
    @Column(name = "product_gallery")
    private List<String> gallery = new ArrayList<String>();
    @IndexedEmbedded    
    @ElementCollection(targetClass = java.lang.String.class, fetch = FetchType.EAGER)
    @Column(name = "product_colors")
    private List<String> colors = new ArrayList<String>();
    @IndexedEmbedded
    @ElementCollection(targetClass = java.lang.String.class, fetch = FetchType.EAGER)
    @Column(name = "product_sizes")
    private List<String> sizes = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }   

    public List<String> getGallery() {
        return gallery;
    }

    public void setGallery(List<String> gallery) {
        this.gallery = gallery;
    }       

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }    

    public double getOld_price() {
        return old_price;
    }

    public void setOld_price(double old_price) {
        this.old_price = old_price;
    }       
    
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }       

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }   

    public String getDescription() {
        return description;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }    

    public void setDescription(String description) {
        this.description = description;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {        
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eshop.entities.Products[ id=" + id + " ]";
    }
}
