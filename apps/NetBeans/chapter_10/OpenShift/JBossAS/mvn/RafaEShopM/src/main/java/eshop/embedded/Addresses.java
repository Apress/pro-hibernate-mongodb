package eshop.embedded;

import java.io.Serializable;
import javax.persistence.Embeddable;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

/**
 *
 * @author Apress
 */
@Embeddable
public class Addresses implements Serializable {
  
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String city;    
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String state;  
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String street;   
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String number;
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String zip;   
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String country;   
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String phone;   
    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.NO)
    private String fax;        

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
}
