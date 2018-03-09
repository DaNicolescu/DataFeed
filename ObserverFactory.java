
import java.util.Queue;

/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class ObserverFactory {

    private ObserverFactory() {

    }

    /**
     * Construieste un PrintObserver al carui id este cel dat ca parametru si
     * care are ca atribut un arbore de expresie creat cu ajutorul parametrului
     * filter
     *
     * @param id id-ul observatorului
     * @param filter expresie in infix notation 
     * @return un PrintObserver
     */
    public static Observer CreateObserver(int id, String filter) {
        Rpn converter = Rpn.getInstance();
        Queue<String> RpnExpression = converter.InfixToRpn(filter);

        ExpressionTree tree = new ExpressionTree(RpnExpression);

        return new PrintObserver(id, tree);
    }

}
