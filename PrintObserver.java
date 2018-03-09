
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class PrintObserver implements Observer {

    /**
     * TreeMap in care sunt tinute informatiile despre fiecare stock
     *
     */
    private final TreeMap<String, ObservedCommodity> observedCommodities;

    /**
     * Arborele de expresie.
     *
     */
    private final ExpressionTree filter;
    private final int id;
    private final CheckVisitor visitor;

    /**
     *
     * @param id
     * @param filter
     */
    public PrintObserver(int id, ExpressionTree filter) {
        this.id = id;
        this.filter = filter;
        this.visitor = new CheckVisitor();
        this.observedCommodities = new TreeMap<>();
    }

    /**
     * Adauga stock-ul in TreeMap-ul observatorului, sau doar il updateaza.
     *
     * @param commodity
     */
    @Override
    public void update(Commodity commodity) {
        if (this.observedCommodities.containsKey(commodity.getName())) {
            this.observedCommodities.get(commodity.getName()).
                    updateObservedCommodity(commodity.getValue());

        } else {
            ObservedCommodity obsCommodity = new ObservedCommodity(
                    commodity.getName(), commodity.getValue());

            this.observedCommodities.put(commodity.getName(), obsCommodity);
            obsCommodity.incNrOfChanges();
        }
    }

    /**
     * Update-ul initial in care observatorul trece prin tot log-ul feed-ului.
     *
     * @param feedCommodities
     */
    @Override
    public void initialUpdate(HashMap<String, FeedCommodity> feedCommodities) {

        for (String key : feedCommodities.keySet()) {
            FeedCommodity crtFeedCommodity = feedCommodities.get(key);

            ObservedCommodity commodity = new ObservedCommodity(key,
                    crtFeedCommodity.getValue());

            this.observedCommodities.put(key, commodity);
        }
    }

    /**
     * Afisarea stock-urilor cu ajutorul visitorului.
     *
     */
    @Override
    public void print() {
        ObservedCommodity crtCommodity;

        for (String key : this.observedCommodities.keySet()) {
            crtCommodity = this.observedCommodities.get(key);

            visitor.setCommodityToCheck(key, crtCommodity.getValue());

            DecimalFormat twoDec = new DecimalFormat("0.00");

            if (this.filter.root == null || this.filter.root.accept(visitor)) {
                // calculeaza fluctuatia pretului
                crtCommodity.calculateIncrease(crtCommodity.getValue());

                System.out.println("obs " + this.id + ": " + key + " "
                        + twoDec.format(crtCommodity.getValue()) + " "
                        + twoDec.format(crtCommodity.getIncrease()) + "% "
                        + crtCommodity.getNrOfChanges());

                // reseteaza numarul de aparitii si seteaza ultima valoare
                // a stock-ului afisata
                crtCommodity.resetNrOfChanges();
                crtCommodity.setLastPrintedValue(crtCommodity.getValue());
            }
        }
    }

}
