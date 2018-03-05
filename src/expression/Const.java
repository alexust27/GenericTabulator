package expression;

public class Const<T> implements TripleExpression<T> {
    private final T v;

    public Const(T val) {
        v = val;
    }

    public T evaluate(T x, T y, T z) {
        return v;
    }
}