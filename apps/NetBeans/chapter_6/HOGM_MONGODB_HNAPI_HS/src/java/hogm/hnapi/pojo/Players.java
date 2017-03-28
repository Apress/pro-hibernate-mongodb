package hogm.hnapi.pojo;

import java.util.Date;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Resolution;
import org.hibernate.search.annotations.Store;

@Indexed
public class Players {
  
    @DocumentId
    private String id;    
    @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
    private String name;  
    @Field(index=Index.YES, analyze=Analyze.NO, store=Store.NO)
    private String surname; 
    @NumericField
    @Field(index=Index.YES, analyze=Analyze.NO, store=Store.NO)
    private int age;   
    @Field(index=Index.YES, analyze=Analyze.NO, store=Store.NO)
    @DateBridge(resolution = Resolution.YEAR)
    private Date birth;    

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }   

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }        

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }  
}
