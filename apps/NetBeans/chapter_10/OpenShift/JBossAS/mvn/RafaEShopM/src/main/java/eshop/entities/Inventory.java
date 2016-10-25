package eshop.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author Apress
 */
@Entity
@IdClass(eshop.embedded.InventoryPK.class)
@Table(name = "inventory_c")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String sku;
    @Id
    private String sku_color;
    @Id
    private String sku_size;
    @Version
    private Long version;
    @Column(name = "inventory")
    private int inventory;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getSku_color() {
        return sku_color;
    }

    public void setSku_color(String sku_color) {
        this.sku_color = sku_color;
    }

    public String getSku_size() {
        return sku_size;
    }

    public void setSku_size(String sku_size) {
        this.sku_size = sku_size;
    }    

    public Long getVersion() {
        return version;
    }

    protected void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.sku != null ? this.sku.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inventory other = (Inventory) obj;
        if ((this.sku == null) ? (other.sku != null) : !this.sku.equals(other.sku)) {
            return false;
        }
        return true;
    }
}
