
/**
 *
 * @author Nicolescu Daniel-Marian
 */
public interface Visitor {

    public boolean visit(OrNode node);

    public boolean visit(AndNode node);

    public boolean visit(NameEqNode node);

    public boolean visit(ValueEqNode node);

    public boolean visit(NameNeNode node);

    public boolean visit(ValueNeNode node);

    public boolean visit(GtNode node);

    public boolean visit(GeNode node);

    public boolean visit(LtNode node);

    public boolean visit(LeNode node);
}
