package expression;

public class Add<T> extends BinOperator<T> {
    public Add(TripleExpression<T> first, TripleExpression<T> second, Operations<T> calc) {
        super(first, second, calc);
    }

    protected T mix(T a, T b) throws Exception {
        return calc.add(a, b);
    }
}