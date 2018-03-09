
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public abstract class Node implements Visitable {

    public Node left;
    public Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

}
