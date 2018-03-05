package expression;

public class Square<T> implements TripleExpression<T> {
    private TripleExpression<T> value;
    private Operations<T> op;

    public Square(TripleExpression<T> val,Operations<T> op) {
        value = val;
        this.op=op;
    }

    public T evaluate(T x, T y, T z) throws Exception {
        T a = value.evaluate(x, y, z);
        return op.square(a);
    }
}