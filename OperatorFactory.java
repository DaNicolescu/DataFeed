
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class OperatorFactory {

    private OperatorFactory() {

    }

    /**
     * tipurile de operatori
     *
     */
    public enum OperatorType {
        eq, ne, gt, ge, lt, le
    }

    /**
     * Creeaza un operator de tip type, cu fiii left si right.
     * Operand1 reprezinta tipul datei pe care se realizeaza operatia 
     * (name/value).
     * Operand2 reprezinta o valoare cu care se compara.
     *
     * @param type tipul operatorului
     * @param left fiul stang
     * @param right fiul drept
     * @param operand1 operandul 1 (name/value)
     * @param operand2 operandul 2
     * @return
     */
    public static OperatorNode createOperator(OperatorType type, Node left,
             Node right, String operand1, String operand2) {

        if (operand1.equals("name")) {
            switch (type) {
                case eq:
                    return new NameEqNode(left, right, operand1, operand2);
                case ne:
                    return new NameNeNode(left, right, operand1, operand2);
            }
        }

        double doubleOperand2 = Double.valueOf(operand2);

        switch (type) {
            case eq:
                return new ValueEqNode(left, right, operand1, doubleOperand2);
            case ne:
                return new ValueNeNode(left, right, operand1, doubleOperand2);
            case gt:
                return new GtNode(left, right, operand1, doubleOperand2);
            case ge:
                return new GeNode(left, right, operand1, doubleOperand2);
            case lt:
                return new LtNode(left, right, operand1, doubleOperand2);
            case le:
                return new LeNode(left, right, operand1, doubleOperand2);
        }

        throw new IllegalArgumentException("Type not recognised");
    }
}
