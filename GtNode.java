
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class GtNode extends OperatorNode implements Visitable {

    private double value;
    
    /**
     *
     * @param left fiul stang
     * @param right fiul drept
     * @param type tipul primului operand (name/value)
     * @param value valoarea
     */
    public GtNode(Node left, Node right, String type, double value) {
        super(left, right, type);
        this.value = value;
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean getResult(String name, double value) {
        return value > this.value;
    }

}
