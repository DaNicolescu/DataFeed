
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public abstract class OperatorNode extends Node implements Visitable {

    protected String type;

    public OperatorNode(Node left, Node right, String type) {
        super(left, right);
        this.type = type;
    }

    public abstract boolean getResult(String name, double value);

}
