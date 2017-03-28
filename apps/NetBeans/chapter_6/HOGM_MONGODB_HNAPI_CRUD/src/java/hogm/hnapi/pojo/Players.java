package hogm.hnapi.pojo;

import java.util.Date;

public class Players {
  
    private String id;    
    private String name;  
    private String surname; 
    private int age;   
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
