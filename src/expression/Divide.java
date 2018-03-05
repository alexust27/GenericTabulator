package expression;

public class Divide<T> extends BinOperator<T> implements TripleExpression<T> {
    public Divide(TripleExpression<T> first, TripleExpression<T> second, Operations<T> op) {
        super(first, second, op);
    }

    protected T mix(T a, T b) throws Exception {
        return calc.divide(a, b);
    }
}