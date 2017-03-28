package hogm.mongodb.entity;

import java.io.Serializable;

public class RankingAndPrizeC implements Serializable {

    private int ranking;
    private String prize;

    public RankingAndPrizeC() {
    }        
    
    @Override
    public boolean equals(Object arg0) {
        
        //implement equals here
        return false;
    }

    @Override
    public int hashCode() {
        
        //implement hashCode here        
        return 0;
    }
}
