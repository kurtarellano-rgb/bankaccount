
import java.time.LocalDateTime;

/** Represents a transaction with a type, amount, and timestamp. */
public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime time_stamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    public String toString() {
        return "Transaction [type=" + type +
               ", amount=" + amount +
               ", time_stamp=" + time_stamp + "]";
    }
}
