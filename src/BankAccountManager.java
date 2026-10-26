import java.util.HashMap;
import java.util.Map;
import java.util.List;

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

    public void addAccount3(BankAccount account) {

        accounts.put(id, account);
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

        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            BankAccount account = entry.getValue();

            System.out.println(
                "Account ID: " + entry.getKey() +
                ", Account Name: " + account.getAccountName() +
                ", Balance: " + String.format("%.2f", account.getBalance())
            );
        }
    }

    // Filter transactions using lambda expression
    public List<Transaction> filterTransactionsAtOrAbove(
            double amount, List<Transaction> txList) {

        return txList.stream()
                .filter(tx -> tx.getAmount() >= amount)
                .toList();
    }

    // Sort transactions using lambda expression
    public List<Transaction> sortTransactionsByAmount(
            List<Transaction> txList) {

        return txList.stream()
                .sorted((tx1, tx2) ->
                    Double.compare(tx1.getAmount(), tx2.getAmount()))
                .toList();
    }
}