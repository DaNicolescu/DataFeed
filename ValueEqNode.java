
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class ValueEqNode extends OperatorNode implements Visitable {

    private double value;

    /**
     *
     * @param left fiul stang
     * @param right fiul drept
     * @param type tipul primului operand (name/value)
     * @param value valoarea
     */
    public ValueEqNode(Node left, Node right, String type, double value) {
        super(left, right, type);
        this.value = value;
    }

    @Override
    public boolean getResult(String name, double value) {
        return this.value == value;
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
