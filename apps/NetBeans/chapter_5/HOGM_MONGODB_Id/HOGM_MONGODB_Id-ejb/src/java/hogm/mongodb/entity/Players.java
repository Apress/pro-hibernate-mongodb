package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Players implements Serializable {

    private static final long serialVersionUID = 1L;
    //*********** manually set primary keys ************
    //@Id     
    //private int id;
    //**************************************************
    //***************** AUTO strategy ******************   
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    //**************************************************
    //*************** IDENTITY strategy ****************
    //@Id        
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //private Long id;
    //**************************************************
    //*************** SEQUENCE strategy ****************
    //@SequenceGenerator(name="mongodb_sequence", initialValue=5, allocationSize=2)
    //@SequenceGenerator(name="mongodb_sequence", catalog="MONGO", schema="MONGOSEQ", initialValue=5, allocationSize=2)    
    //@Id       
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mongodb_sequence")
    //private int id;
    //**************************************************
    //*************** TABLE strategy *******************
    //@TableGenerator(name="mongodb_table", initialValue=5, allocationSize=2)
    //@TableGenerator(name="mongodb_table", table="pk_table", initialValue=5, allocationSize=2)    
    //@Id
    //@GeneratedValue(strategy=GenerationType.TABLE, generator="mongodb_table")   
    //private int id;
    //**************************************************
    //*************** UUID2 generator ******************
    //@GenericGenerator(name="mongodb_uuidgg", strategy="uuid2")    
    //@Id    
    //@GeneratedValue(generator="mongodb_uuidgg")
    //private String id;
    //**************************************************
    //*************** Custom Generator *****************
    //@GenericGenerator(name="mongodb_custom_generator", strategy="hogm.mongodb.generator.CustomGenerator")            
    //@Id
    //@GeneratedValue(generator="mongodb_custom_generator")
    //private String id;
    //**************************************************
    //********** Composite Key (EmbeddedId) ************
    //@EmbeddedId              
    //private RankingAndPrizeE id;
    //**************************************************
    //********** Composite Key (IdClass) ************
    //@IdClass(hogm.mongodb.entity.RankingAndPrizeC.class)
    //@Id
    //private int ranking;
    //@Id
    //private String prize;
    //**************************************************
    private String name;
    private String surname;
    private int age;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
