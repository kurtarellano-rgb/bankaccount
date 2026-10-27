
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Represents a transaction with a type, amount, and timestamp. */
public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime time_stamp;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.time_stamp = LocalDateTime.now();
    }

    public String toString() {
        return String.format("Type: %-8s | Amount: %-8.2f | Time Stamp: %s",
                type, amount, time_stamp.format(FORMATTER));
    }

    public double getAmount() {
        return amount;
}
}
