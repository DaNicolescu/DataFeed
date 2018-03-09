
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class NameEqNode extends OperatorNode implements Visitable {

    private String name;

    /**
     *
     * @param left fiul stang
     * @param right fiul drept
     * @param type tipul primului operand (name/value)
     * @param name numele
     */
    public NameEqNode(Node left, Node right, String type, String name) {
        super(left, right, type);
        this.name = name;
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean getResult(String name, double value) {
        return this.name.equals(name);
    }

}
