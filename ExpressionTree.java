
import java.util.Queue;
import java.util.Stack;

/**
 * Arbore de expresie.
 * 
 * @author Nicolescu Daniel-Marian
 */
public class ExpressionTree {

    public Node root;

    /**
     * Constructorul apeleaza metoda createExpressionTree ce creeaza un arbore
     * de expresie pornind de la expresia in notatie poloneza.
     *
     * @param RpnExpression coada in care se afla elementele
     * unei expresii in notatie poloneza
     */
    public ExpressionTree(Queue<String> RpnExpression) {
        createExpressionTree(RpnExpression);
    }

    /**
     * Creeaza un arbore pornind de la expresia data ca parametru.
     * 
     * @param RpnExpression coada ce contine o expresie in notatie poloneza.
     */
    private void createExpressionTree(Queue<String> RpnExpression) {
        Stack<Node> stack = new Stack<>();
        String currentToken;

        if (RpnExpression.isEmpty()) {
            return;
        }

        while (!RpnExpression.isEmpty()) {
            currentToken = RpnExpression.poll();

            // daca este evaluatorul "&&"
            // se creeaza un nod nou folosind ca fii ultimele 2 noduri 
            // din stiva si se pune apoi pe stiva
            if (currentToken.equals("&&")) {
                Node right = stack.pop();
                Node left = stack.pop();

                
                AndNode andNode = new AndNode(left, right);

                stack.push(andNode);
            // daca este evaluatorul "||"
            // se creeaza un nod nou folosind ca fii ultimele 2 noduri 
            // din stiva si se pune apoi pe stiva
            } else if (currentToken.equals("||")) {
                Node right = stack.pop();
                Node left = stack.pop();

                OrNode orNode = new OrNode(left, right);

                stack.push(orNode);
            // daca este un operator
            // se creeaza un nod operator nou si se pune pe stiva
            } else {
                String[] info = currentToken.split(" ");

                OperatorNode opNode = OperatorFactory.createOperator(
                        OperatorFactory.OperatorType.valueOf(info[0]), null,
                        null, info[1], info[2]);

                stack.push(opNode);
            }
        }
        
        // radacina arborelui va fi ultimul element din stiva
        this.root = stack.pop();
    }
}
