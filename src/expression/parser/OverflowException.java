package expression.parser;

public class OverflowException extends Exception {
    public OverflowException() {
        super("overflow");
    }
}