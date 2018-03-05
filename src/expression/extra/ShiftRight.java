package expression.extra;

public class ShiftRight extends BinOperator {
    public ShiftRight(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int mix(int a, int b) {
        return a >> b;
    }
}