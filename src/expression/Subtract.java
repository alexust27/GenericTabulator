package expression;

public class Subtract<T> extends BinOperator<T> {
    public Subtract(TripleExpression first, TripleExpression second, Operations<T> op) {
        super(first, second,op);
    }

    protected T mix(T a, T b) throws Exception {
        return calc.subtract(a,b);
    }
}