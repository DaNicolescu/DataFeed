
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Nicolescu Daniel-Marian
 */
public class Rpn {
    
    private static Rpn instance;
    
    private Rpn() {
        
    }
    
    public static Rpn getInstance() {
        if(instance == null) {
            instance = new Rpn();
        }
        
        return instance;
    }

    /**
     * Converteste o expresie infix data ca parametru intr-una postfix
     *
     * @param line
     * @return o coada in care se afla elementele expresiei
     */
    public Queue<String> InfixToRpn(String line) {
        Queue<String> inputQueue = new LinkedList<>();

        if (line.equals("nil")) {
            return inputQueue;
        }

        String[] tokens = line.split(" +");

        // creeaza o coada de input din String-ul dat ca parametru,
        // eliminand parantezele inutile din jurul fiecarei expresii
        // ex: (eq name abc) => eq name abc
        
        // pastreaza doar parantezele ce au legatura cu ordinea efectuarii
        // evaluarilor
        for (int i = 0; i < tokens.length - 1; i++) {
            // daca e paranteza deschisa
            if (tokens[i].equals("(")) {
                if (tokens[i + 1].equals("(")) {
                    inputQueue.add(tokens[i]);
                }

            // daca e paranteza inchisa
            } else if (tokens[i].equals(")")) {
                if (tokens[i + 1].equals(")")) {
                    inputQueue.add(tokens[i]);
                }

            // daca e evaluator
            } else if (tokens[i].equals("&&") || tokens[i].equals("||")) {
                inputQueue.add(tokens[i]);

            // daca e un operator este introdus in coada impreuna cu cei doi 
            // operanzi
            } else {
                inputQueue.add(tokens[i] + " " + tokens[i + 1] + " " + tokens[i + 2]);
                i += 2;
            }
        }

        Queue<String> outputQueue = new LinkedList<>();
        Stack<String> operatorStack = new Stack<>();

        String currentToken;

        // cat timp coada de input nu e vida
        while (!inputQueue.isEmpty()) {
            currentToken = inputQueue.poll();

            // daca e paranteza deschisa o pune pe stiva
            if (currentToken.equals("(")) {
                operatorStack.push(currentToken);

            // daca e paranteza inchisa
            } else if (currentToken.equals(")")) {
                // cat timp nu gaseste o paranteza deschisa, pune ce gaseste
                // pe stiva in coada de output
                while (!operatorStack.peek().equals("(")) {
                    outputQueue.add(operatorStack.pop());
                }

                // scapa de paranteza deschisa
                operatorStack.pop();

            // daca e un evaluator
            } else if (currentToken.equals("&&") || currentToken.equals("||")) {
                operatorStack.push(currentToken);
                
            // daca e un operator
            } else {
                outputQueue.add(currentToken);
            }
        }

        // pune ce a mai ramas pe stiva in coada de output
        while (!operatorStack.isEmpty()) {
            outputQueue.add(operatorStack.pop());
        }

        return outputQueue;
    }
}
