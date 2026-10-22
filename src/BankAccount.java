
/**
 * Represents a bank account with basic transactions.
 */
public class BankAccount {

    private double balance;
    private boolean isFrozen;

    /**
     * Initializes the bank account.
     */
    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
    }

    /**
     * Deposits money into the account.
     *
     * @param amount amount to deposit
     */
    public void deposit(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        }

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Amount deposited: " + amount);
            System.out.println("Invalid amount. Must be greater than 0");
        } else {
            balance += amount;
            System.out.printf("Amount deposited: %.2f%n", amount);
            System.out.printf("Current balance: %.2f%n", balance);
        }
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount amount to withdraw
     */
    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
        }

        System.out.println("Amount withdrawn: " + amount);

        if (!Double.isFinite(amount) || amount <= 0) {
            System.out.println("Invalid amount. Must be greater than 0");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
            System.out.printf("Current balance: %.2f%n", balance);
        } else {
            balance -= amount;
            System.out.printf("Current balance: %.2f%n", balance);
        }
    }

    /**
     * Returns the account balance.
     *
     * @return current balance
     */
    public double getBalance() {
        return balance;
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
     * @return true if frozen, otherwise false
     */
    public boolean isFrozen() {
        return isFrozen;
    }
}
