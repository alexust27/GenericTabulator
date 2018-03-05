package expression;

public class Negate<T> implements TripleExpression<T> {
    private TripleExpression<T> value;
    private Operations<T> op;

    public Negate(TripleExpression<T> val, Operations<T> op) {
        value = val;
        this.op = op;
    }

    public T evaluate(T x, T y, T z) throws Exception {
        T a = value.evaluate(x, y, z);
        return op.negate(a);
    }
}