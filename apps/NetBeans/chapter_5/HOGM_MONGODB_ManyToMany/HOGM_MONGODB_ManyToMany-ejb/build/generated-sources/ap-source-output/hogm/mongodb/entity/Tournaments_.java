package hogm.mongodb.entity;

import hogm.mongodb.entity.Players;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-04-22T14:30:16")
@StaticMetamodel(Tournaments.class)
public class Tournaments_ { 

    public static volatile SingularAttribute<Tournaments, Integer> id;
    public static volatile SingularAttribute<Tournaments, String> tournament;
    public static volatile CollectionAttribute<Tournaments, Players> players;

}