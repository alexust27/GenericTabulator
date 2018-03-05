package expression;

public class ByteOperations implements Operations<Byte> {

    public Byte parse(String a) throws Exception {
        return Byte.parseByte(a);
    }

    public Byte add(Byte a, Byte b) throws Exception {
        return (byte)(a + b);
    }
    public Byte subtract(Byte a, Byte b) throws Exception {
        return (byte)(a - b);
    }
    public Byte multiply(Byte a, Byte b) throws Exception {
        return (byte)(a * b);
    }
    public Byte divide(Byte a, Byte b) throws Exception {
        return (byte)(a / b);
    }
    public Byte mod(Byte a, Byte b) throws Exception {
        return (byte)(a % b);
    }
    public Byte negate(Byte a) throws Exception {
        return (byte)(-a);
    }
    public Byte abs(Byte a) throws Exception {
        if (a < 0) {
            return subtract((byte)0, a);
        } else {
            return a;
        }
    }
    public Byte square(Byte a) throws Exception {
        return multiply(a, a);
    }
}
