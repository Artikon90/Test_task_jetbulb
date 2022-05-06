package exceptions;

public class InvalidValueException extends RuntimeException {
    public InvalidValueException() {
        super("String must contain only valid roman numerals [I, V, X, L, C, D, M].");
    }
}