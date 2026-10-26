
import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of bank accounts and assigns unique IDs to each account.
 */
public class BankAccountManager implements Bank {

    private Map<Integer, BankAccount> accounts;
    private int id;

    // Constructor
    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    public void addAccount(BankAccount account) {

        if (accounts.size() >= 100) {
            System.out.println("Maximum limit of 100 accounts reached.");
            return;
        }

        accounts.put(id, account);

        System.out.println("Account added successfully with ID: " + id);

        id++;
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

    for (int i = 0; i < id; i++) {
        BankAccount account = accounts.get(i);
        double balance = account.getBalance();

            System.out.println(
                "Account ID: " + i +
                ", Account Name: " + account.getAccountName() +
                ", Balance:  " + String.format("%.2f", balance)
            );
        }
    }
}
