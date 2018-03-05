package expression.extra;

import expression.BinOperator;
import expression.TripleExpression;

public class Xor extends BinOperator {
    public Xor(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int mix(int a, int b) {
        return a ^ b;
    }
}