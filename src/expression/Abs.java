package expression;

public class Abs<T> implements TripleExpression<T> {
    private TripleExpression<T> v;
    private T t;
    private Operations<T> op;

    public Abs(TripleExpression<T> val,Operations<T> calc) {
        v = val;
        this.op=calc;
    }

    public T evaluate(T x, T y, T z) throws Exception {
        t = v.evaluate(x, y, z);
        return op.abs(t);
    }
}