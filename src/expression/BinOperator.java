package expression;

abstract public class BinOperator<T> implements TripleExpression<T> {
    protected TripleExpression<T> x1;
    protected TripleExpression<T> x2;
    protected Operations<T> calc;

    BinOperator(TripleExpression first, TripleExpression second, Operations<T> op) {
        x1 = first;
        x2 = second;
        this.calc = op;
    }

    abstract protected T mix(T a, T b) throws Exception;

    public T evaluate(T x, T y, T z) throws Exception {
        return mix(x1.evaluate(x, y, z), x2.evaluate(x, y, z));
    }
}