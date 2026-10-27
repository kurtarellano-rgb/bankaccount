
import java.util.ArrayList;
import java.util.List;
import exception.InvalidAmountException;
import exception.InsufficientFundsException;
import exception.AccountFrozenException;

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

  
    public void deposit(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(
                    "Account is FROZEN. Unable to transact.");
            }

            System.out.printf("Amount deposited: %.2f%n", amount);

            if (!Double.isFinite(amount) || amount <= 0) {
                throw new InvalidAmountException(
                    "Invalid amount. Must be greater than 0");
            }

            balance += amount;
            transactionHistory.add(
                new Transaction("Deposit", amount));
            printBalance();

        } catch (InvalidAmountException | AccountFrozenException e) {
            System.out.println(e.getMessage());
        }
    }


    public void withdraw(double amount) {
        try {
            if (isFrozen()) {
                throw new AccountFrozenException(
                    "Account is FROZEN. Unable to transact.");
            }

            System.out.printf("Amount withdrawn: %.2f%n", amount);

            if (!Double.isFinite(amount) || amount <= 0) {
                throw new InvalidAmountException(
                    "Invalid amount. Must be greater than 0");
            }

            if (amount > balance) {
                throw new InsufficientFundsException(
                    "Insufficient balance.");
            }

            balance -= amount;
            transactionHistory.add(
                new Transaction("Withdraw", amount));
            printBalance();

        } catch (InvalidAmountException |
                 InsufficientFundsException |
                 AccountFrozenException e) {

            System.out.println(e.getMessage());

            if (e instanceof InsufficientFundsException) {
                printBalance();
            }
        }
    }

    /**
     * Prints the current balance.
     */
    public void printBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }


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
