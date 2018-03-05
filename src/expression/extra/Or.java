package expression.extra;

import expression.BinOperator;
import expression.TripleExpression;

public class Or extends BinOperator {
    public Or(TripleExpression first, TripleExpression second) {
        super(first, second);
    }

    protected int mix(int a, int b) {
        return a | b;
    }
}