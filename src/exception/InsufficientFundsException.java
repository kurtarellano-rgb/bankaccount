package exception;
/**
 * Exception thrown when an account has insufficient funds for a transaction.
 */
public class InsufficientFundsException extends Exception {

    private String message;

    public InsufficientFundsException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}