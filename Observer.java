
import java.util.HashMap;

/**
 *
 * @author Nicolescu Daniel-Marian
 */
public interface Observer {

    public void update(Commodity commodity);

    public void initialUpdate(HashMap<String, FeedCommodity> commodities);

    public void print();
}
