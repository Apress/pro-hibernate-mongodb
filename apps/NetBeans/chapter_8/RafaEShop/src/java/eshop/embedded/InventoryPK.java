package eshop.embedded;

import java.io.Serializable;

/**
 *
 * @author Apress
 */
public class InventoryPK implements Serializable{
    
    private String sku;
    private String sku_color;
    private String sku_size;    
    
    public InventoryPK(){        
    }
    
    public InventoryPK(String sku, String sku_color, String sku_size) {
        this.sku = sku;
        this.sku_color = sku_color;
        this.sku_size = sku_size;
    }        
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.sku != null ? this.sku.hashCode() : 0);
        hash = 83 * hash + (this.sku_color != null ? this.sku_color.hashCode() : 0);
        hash = 83 * hash + (this.sku_size != null ? this.sku_size.hashCode() : 0);
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
        final InventoryPK other = (InventoryPK) obj;
        if ((this.sku == null) ? (other.sku != null) : !this.sku.equals(other.sku)) {
            return false;
        }
        if ((this.sku_color == null) ? (other.sku_color != null) : !this.sku_color.equals(other.sku_color)) {
            return false;
        }
        if ((this.sku_size == null) ? (other.sku_size != null) : !this.sku_size.equals(other.sku_size)) {
            return false;
        }
        return true;
    }        
}
