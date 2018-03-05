package expression;

public class UIntOperations implements Operations<Integer> {

    public Integer parse(String a) throws Exception {
        return Integer.parseInt(a);
    }

    public Integer add(Integer a, Integer b) throws Exception {
        return a + b;
    }
    public Integer subtract(Integer a, Integer b) throws Exception {
        return a - b;
    }
    public Integer multiply(Integer a, Integer b) throws Exception {
        return a * b;
    }
    public Integer divide(Integer a, Integer b) throws Exception {
        return a / b;
    }
    public Integer mod(Integer a, Integer b) throws Exception {
        return a % b;
    }
    public Integer negate(Integer a) throws Exception {
        return -a;
    }
    public Integer abs(Integer a) throws Exception {
        if (a < 0) {
            return subtract(0, a);
        } else {
            return a;
        }
    }
    public Integer square(Integer a) throws Exception {
        return multiply(a, a);
    }
}
