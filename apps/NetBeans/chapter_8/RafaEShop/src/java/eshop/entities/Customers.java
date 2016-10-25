package eshop.entities;

import eshop.embedded.Addresses;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "customers_c")
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @DocumentId
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(name = "customer_email")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String email;
    @Column(name = "customer_password")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String password;
    @Column(name = "customer_name")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String name;
    @Column(name = "customer_surname")
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String surname;
    @DateBridge(resolution = Resolution.DAY)
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "customer_registration")
    private Date registration;
    @Embedded
    @IndexedEmbedded
    @Basic(fetch = FetchType.LAZY)
    private Addresses customer_address_1;
    @Embedded
    @IndexedEmbedded
    @Basic(fetch = FetchType.LAZY)
    private Addresses customer_address_2;   

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getRegistration() {
        return registration;
    }

    public void setRegistration(Date registration) {
        this.registration = registration;
    }

    public Addresses getCustomer_address_1() {
        return customer_address_1;
    }

    public void setCustomer_address_1(Addresses customer_address_1) {
        this.customer_address_1 = customer_address_1;
    }

    public Addresses getCustomer_address_2() {
        return customer_address_2;
    }

    public void setCustomer_address_2(Addresses customer_address_2) {
        this.customer_address_2 = customer_address_2;
    }  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {        
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eshop.entities.Customers[ id=" + id + " ]";
    }
}
