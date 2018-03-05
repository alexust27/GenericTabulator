package expression.extra;

public class ShiftLeft extends BinOperator {
    public ShiftLeft(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int mix(int a, int b) {
        return a << b;
    }
}
