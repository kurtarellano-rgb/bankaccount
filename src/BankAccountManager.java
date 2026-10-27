import java.util.HashMap;
import java.util.Map;

/**
 * Manages bank accounts.
 */
public class BankAccountManager implements Bank {

    private Map<Integer, BankAccount> accounts;
    private int id;
    private static final int MAX_ACC = 100;

    /**
     * Initializes the account manager.
     */
    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    /**
     * Adds an account to the manager.
     */
    public void addAccount(BankAccount account) {

        if (accounts.size() >= MAX_ACC) {
            System.out.println(
                "Maximum limit of " + MAX_ACC + " accounts reached.");
            return;
        }

        accounts.put(id, account);
        id++;
    }

    /**
     * Returns an account based on its ID.
     */
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    /**
     * Displays all accounts and their balances.
     */
    public void listAccounts() {
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            BankAccount account = entry.getValue();

            System.out.println("Account ID: " + entry.getKey());
            System.out.println("Owner: " + account.getAccountName());
            System.out.printf("Balance: %.2f%n", account.getBalance());
        }
    }
}