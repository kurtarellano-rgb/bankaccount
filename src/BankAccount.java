
import java.util.ArrayList;
import java.util.List;

import exception.AccountFrozenException;
import exception.InsufficientFundsException;
import exception.InvalidAmountException;

/**
 * Represents a bank account with basic transactions.
 * Supports deposits, withdrawals, account freezing,
 * and transaction history.
 */
public class BankAccount {

    /** Current account balance. */
    private double balance;

    /** Indicates whether the account is frozen. */
    private boolean isFrozen;

    /** Stores the account transaction history. */
    private List<Transaction> transactionHistory;

    /** Stores the account owner's name. */
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

    /**
     * Initializes the bank account with an owner's name.
     *
     * @param accountName name of the account owner
     */
    public BankAccount(String accountName) {
        this();
        this.accountName = accountName;
    }

    /**
     * Deposits money into the bank account.
     * Handles invalid amounts and frozen accounts.
     *
     */
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

    /**
     * Withdraws money from the bank account.
     * Handles invalid amounts, insufficient funds,
     * and frozen accounts.
     */
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

        } catch (InvalidAmountException
                | InsufficientFundsException
                | AccountFrozenException e) {

            System.out.println(e.getMessage());

            if (e instanceof InsufficientFundsException) {
                printBalance();
            }
        }
    }

    /**
     * Prints the current account balance.
     */
    public void printBalance() {
        System.out.printf("Current balance: %.2f%n", balance);
    }

    /**
     * Returns the current account balance.
     *
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the account owner's name.
     *
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Freezes the bank account.
     */
    public void freezeAccount() {
        isFrozen = true;
    }

    /**
     * Unfreezes the bank account.
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
     * Returns the account transaction history.
     *
     */
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
