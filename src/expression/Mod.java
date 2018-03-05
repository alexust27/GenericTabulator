package expression;

/**
 * Created by Александр on 12.04.2017.
 */
public class Mod<T> extends BinOperator<T>{
    public Mod(TripleExpression<T> first, TripleExpression<T> second, Operations<T> calc) {
        super(first, second, calc);
    }

    protected T mix(T a, T b) throws Exception {
        return calc.mod(a, b);
    }
}
