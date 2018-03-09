
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class OrNode extends Node implements Visitable {

    /**
     *
     * @param left fiul stang
     * @param right fiul drept
     */
    public OrNode(Node left, Node right) {
        super(left, right);
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
