import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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

        System.out.println(
            "Account added successfully with ID: " + id);

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
  
    /**
     * Displays all accounts and their balances.
     */
    public void listAccounts() {

        for (int accountId = 0; accountId < id; accountId++) {
            BankAccount account = accounts.get(accountId);

            if (account != null) {
                System.out.printf(
                    "Account ID: %d, Account Name: %s, Balance: %.1f%n",
                    accountId,
                    account.getAccountName(),
                    account.getBalance()
                );
            }
        }
    }


    /**
     * Filters transactions with amounts at or above the given amount.
     *
     */
    public List<Transaction> filterTransactionsAtOrAbove(
            double amount, List<Transaction> transactions) {

        List<Transaction> filtered = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getAmount() >= amount) {
                filtered.add(transaction);
            }
        }

        return filtered;
    }


    
    /**
     * Sorts transactions by amount in ascending order.
   */
    public List<Transaction> sortTransactionsByAmount(
            List<Transaction> transactions) {

        List<Transaction> sorted = new ArrayList<>(transactions);

        sorted.sort(
            Comparator.comparingDouble(Transaction::getAmount)
        );

        return sorted;
    }
}
