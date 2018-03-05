package expression;

public class FloatOperations implements Operations<Float> {

    public Float parse(String a) throws Exception {
        return Float.parseFloat(a);
    }

    public Float add(Float a, Float b) throws Exception {
        return a + b;
    }
    public Float subtract(Float a, Float b) throws Exception {
        return a - b;
    }
    public Float multiply(Float a, Float b) throws Exception {
        return a * b;
    }
    public Float divide(Float a, Float b) throws Exception {
        return a / b;
    }
    public Float mod(Float a, Float b) throws Exception {
        return a % b;
    }
    public Float negate(Float a) throws Exception {
        return -a;
    }
    public Float abs(Float a) throws Exception {
        if (a < 0) {
            return subtract((float)0, a);
        } else {
            return a;
        }
    }
    public Float square(Float a) throws Exception {
        return multiply(a, a);
    }
}
