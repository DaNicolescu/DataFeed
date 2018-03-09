
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class FeedCommodity extends Commodity {

    private int nrOfChanges;

    /**
     *
     * @param name
     * @param value
     */
    public FeedCommodity(String name, double value) {
        this.name = name;
        this.value = value;
        this.nrOfChanges = 1;
    }

    public void incNrOfChanges() {
        ++this.nrOfChanges;
    }

    public int getNrOfChanges() {
        return nrOfChanges;
    }

    void updateFeedCommodity(double value) {
        setValue(value);
        incNrOfChanges();
    }

}
