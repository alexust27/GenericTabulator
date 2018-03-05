package expression.generic;

import java.math.BigInteger;

import expression.*;
import expression.parser.*;

public class GenericTabulator implements Tabulator {
    public Object[][][] tabulate(
            String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2
    ) throws Exception {
        IntOperations ii = new IntOperations();
        DoubleOperations dd = new DoubleOperations();
        BigIntOperations bi = new BigIntOperations();
        UIntOperations u = new UIntOperations();
        ByteOperations bt = new ByteOperations();
        FloatOperations f = new FloatOperations();

        ExpressionParser<Integer> parseri = new ExpressionParser<>(ii);
        ExpressionParser<Double> parserd = new ExpressionParser<>(dd);
        ExpressionParser<BigInteger> parserbi = new ExpressionParser<>(bi);
        ExpressionParser<Integer> parserU = new ExpressionParser<>(u);
        ExpressionParser<Byte> parserB = new ExpressionParser<>(bt);
        ExpressionParser<Float> parserF = new ExpressionParser<>(f);

        Object[][][] res = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        switch (mode) {
                            case "i":
                                res[i - x1][j - y1][k - z1] =
                                        parseri.parse(expression).evaluate(
                                                ii.parse(Integer.toString(i)),
                                                ii.parse(Integer.toString(j)),
                                                ii.parse(Integer.toString(k))
                                        );
                                break;
                            case "d":
                                res[i - x1][j - y1][k - z1] =
                                        parserd.parse(expression).evaluate(
                                                dd.parse(Integer.toString(i)),
                                                dd.parse(Integer.toString(j)),
                                                dd.parse(Integer.toString(k))
                                        );
                                break;
                            case "bi":
                                res[i - x1][j - y1][k - z1] =
                                        parserbi.parse(expression).evaluate(
                                                bi.parse(Integer.toString(i)),
                                                bi.parse(Integer.toString(j)),
                                                bi.parse(Integer.toString(k))
                                        );
                                break;
                            case "u":
                                res[i - x1][j - y1][k - z1] =
                                        parserU.parse(expression).evaluate(
                                                u.parse(Integer.toString(i)),
                                                u.parse(Integer.toString(j)),
                                                u.parse(Integer.toString(k))
                                        );
                                break;
                            case "f":
                                res[i - x1][j - y1][k - z1] =
                                        parserF.parse(expression).evaluate(
                                                f.parse(Integer.toString(i)),
                                                f.parse(Integer.toString(j)),
                                                f.parse(Integer.toString(k))
                                        );
                                break;
                            case "b":
                                res[i - x1][j - y1][k - z1] =
                                        parserB.parse(expression).evaluate(
                                                bt.parse(Integer.toString(i)),
                                                bt.parse(Integer.toString(j)),
                                                bt.parse(Integer.toString(k))
                                        );
                                break;
                        }
                    } catch (Exception e) {
                        res[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return res;
    }
}