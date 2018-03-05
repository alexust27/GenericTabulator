package expression;
/**
 * Created by Александр on 11.04.2017.
 */

import java.math.BigInteger;

public class BigIntOperations implements Operations<BigInteger> {
    public BigInteger parse(String s) {
        return new BigInteger(s);
    }

    public BigInteger add(BigInteger a, BigInteger b) throws Exception {
        return a.add(b);
    }

    public BigInteger subtract(BigInteger a, BigInteger b) throws Exception {
        return a.subtract(b);
    }

    public BigInteger multiply(BigInteger a, BigInteger b) throws Exception {
        return a.multiply(b);
    }

    public BigInteger divide(BigInteger a, BigInteger b) throws Exception {
        return a.divide(b);
    }

    public BigInteger negate(BigInteger a) throws Exception {
        return a.negate();
    }

    public BigInteger mod(BigInteger a, BigInteger b) throws Exception {
        return a.remainder(b);
    }

    public BigInteger square(BigInteger a) {
        return a.multiply(a);
    }

    public BigInteger abs(BigInteger a) {
        return a.abs();
    }

}