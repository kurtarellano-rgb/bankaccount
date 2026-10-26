
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank account with basic transactions.
 */
public class BankAccount {

    private double balance;
    private boolean isFrozen;
    private List<Transaction> transactionHistory;
    private String accountName;

    /**
     * Initializes the bank account.
     */
    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
        transactionHistory = new ArrayList<>();
        accountName = "";
    }

    public BankAccount(String accountName) {
        this();
        this.accountName = accountName;
}

    /**
     * Deposits money into the account.
     *
     */
    public void deposit(double amount) {
        if (isFrozen()) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount deposited: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else {
            balance += amount;
            transactionHistory.add(new Transaction("Deposit", amount));
            System.out.printf("Amount deposited: %.2f%n", amount);
            printBalance();
        }
    }

    /**
     * Withdraws money from the account.
     *
     */
    public void withdraw(double amount) {
        if (isFrozen()) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        }

        System.out.println("Amount withdrawn: " + amount);

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
        } else if (amount > balance) {
            System.out.printf("Insufficient balance. %.2f%n", balance);
        } else {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdraw", amount));
            printBalance();
        }
    }

    /**
     * Print Balance Method
     */
    public void printBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /**
     * Returns the account balance.
     *
     */
    public double getBalance() {
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    /**
     * Freezes the account.
     */
    public void freezeAccount() {
        isFrozen = true;
    }

    /**
     * Unfreezes the account.
     */
    public void unfreezeAccount() {
        isFrozen = false;
    }

    /**
     * Checks whether the account is frozen.
     *
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     * Returns the transaction history.
     *
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
