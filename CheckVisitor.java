/**
 * Visitor ce evalueaza un arbore de expresie.
 * 
 * @author Nicolescu Daniel-Marian
 */
public class CheckVisitor implements Visitor {

    private String name;
    private double value;
    
    /**
     * Seteaza stock-ul pentru care se va efectua evaluarea.
     * 
     * @param name numele stock-ului
     * @param value valoarea acestuia
     */
    public void setCommodityToCheck(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean visit(OrNode node) {
        return node.left.accept(this) || node.right.accept(this);
    }

    @Override
    public boolean visit(AndNode node) {
        return node.left.accept(this) && node.right.accept(this);
    }

    @Override
    public boolean visit(GtNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(GeNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(LtNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(LeNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(NameEqNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(ValueEqNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(NameNeNode node) {
        return node.getResult(name, value);
    }

    @Override
    public boolean visit(ValueNeNode node) {
        return node.getResult(name, value);
    }

}
