package expression;

public class Multiply<T> extends BinOperator<T> {
    public Multiply(TripleExpression<T> first, TripleExpression<T> second, Operations<T> op) {
        super(first, second, op);
    }

    protected T mix(T a, T b) throws Exception {
        return calc.multiply(a, b);
    }
}