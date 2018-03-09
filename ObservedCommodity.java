
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class ObservedCommodity extends Commodity {

    /**
     * lastPrintedValue este folosit pentru a calcula fluctuatia pretului
     * dintre doua afisari
     *
     */
    private double lastPrintedValue;
    private double increase;
    private int nrOfChanges;

    /**
     *
     * @param name
     * @param value
     */
    public ObservedCommodity(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public double getIncrease() {
        return increase;
    }

    public void incNrOfChanges() {
        ++this.nrOfChanges;
    }

    public int getNrOfChanges() {
        return nrOfChanges;
    }

    public void resetNrOfChanges() {
        this.nrOfChanges = 0;
    }

    public void setLastPrintedValue(double lastPrintedValue) {
        this.lastPrintedValue = lastPrintedValue;
    }

    public void calculateIncrease(double newValue) {
        if (this.lastPrintedValue == 0.0) {
            this.increase = 0.0;
            
        } else {
            this.increase = (newValue - this.lastPrintedValue) / 
                    this.lastPrintedValue * 100;
        }
    }

    public void updateObservedCommodity(double value) {
        incNrOfChanges();
        setValue(value);
    }

}
