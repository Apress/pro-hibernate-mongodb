package hogm.mongodb.entity;

import hogm.mongodb.entity.Tournaments;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-22T14:30:16")
@StaticMetamodel(Players.class)
public class Players_ { 

    public static volatile SingularAttribute<Players, Integer> id;
    public static volatile SingularAttribute<Players, Date> birth;
    public static volatile SingularAttribute<Players, String> name;
    public static volatile SingularAttribute<Players, Integer> age;
    public static volatile CollectionAttribute<Players, Tournaments> tournaments;
    public static volatile SingularAttribute<Players, String> surname;

}