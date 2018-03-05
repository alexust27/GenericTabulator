package expression.extra;

import expression.BinOperator;
import expression.TripleExpression;

public class And extends BinOperator {
    public And(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int mix(int a, int b) {
        return a & b;
    }
}