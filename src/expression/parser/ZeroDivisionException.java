package expression.parser;

public class ZeroDivisionException extends RuntimeException {
    public ZeroDivisionException() {
        super("division by zero");
    }
}