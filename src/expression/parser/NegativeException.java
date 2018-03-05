package expression.parser;

public class NegativeException extends Exception {
    public NegativeException() {
        super("NegativeValue");
    }
}