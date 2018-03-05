package expression;

public class Variable<T> implements TripleExpression<T> {
    private String str;

    public Variable(String t) {
        str = t;
    }

    public T evaluate(T x, T y, T z) {
        if (str.equals("x")) {
            return x;
        } else if (str.equals("y")) {
            return y;
        } else {
            return z;
        }
    }
}