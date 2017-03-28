package hogm.mongodb.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class RankingAndPrizeE implements Serializable {
    
    private int ranking;
    private String prize;

    public RankingAndPrizeE() {
    }        

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }        
    
}
