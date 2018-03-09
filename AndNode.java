
/**
 * 
 * @author Nicolescu Daniel-Marian
 */
public class AndNode extends Node implements Visitable {

    /**
     *
     * @param left fiul stang
     * @param right fiul drept
     */
    public AndNode(Node left, Node right) {
        super(left, right);
    }

    /**
     *
     * @param visitor
     * @return
     */
    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

}
