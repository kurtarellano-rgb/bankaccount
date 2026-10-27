
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Manages bank accounts and assigns unique IDs.
 */
public class BankAccountManager implements Bank {

    private Map<Integer, BankAccount> accounts;
    private int id;

    /**
     * Initializes the account manager.
     */
    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    /**
     * Adds an account to the manager.
     *
     */
    public void addAccount(BankAccount account) {

        if (accounts.size() >= 100) {
            System.out.println(
                "Maximum limit of 100 accounts reached.");
            return;
        }

        accounts.put(id, account);

        System.out.println(
            "Account added successfully with ID: " + id);

        id++;
    }

    /**
     * Returns an account using its ID.
     *
     */
    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    /**
     * Displays all registered bank accounts.
     */
    public void listAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (Map.Entry<Integer, BankAccount> entry
                : accounts.entrySet()) {

            BankAccount account = entry.getValue();

            System.out.println(
                "Account ID: " + entry.getKey()
                + ", Account Name: " + account.getAccountName()
                + ", Balance: "
                + String.format("%.2f", account.getBalance())
            );
        }
    }

    /**
     * Filters transactions at or above an amount.
     *

     */
    public List<Transaction> filterTransactionsAtOrAbove(
            double amount, List<Transaction> txList) {

        return txList.stream()
                .filter(tx -> tx.getAmount() >= amount)
                .toList();
    }

    /**
     * Sorts transactions by amount in ascending order.
     *
     */
    public List<Transaction> sortTransactionsByAmount(
            List<Transaction> txList) {

        return txList.stream()
                .sorted((tx1, tx2) ->
                    Double.compare(
                        tx1.getAmount(), tx2.getAmount()))
                .toList();
    }
}
