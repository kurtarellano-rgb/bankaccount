import java.util.List;
import exception.InvalidAmountException;
import exception.InsufficientFundsException;
import exception.AccountFrozenException;

/** Runs the bank account test cases. */
class BankAccountTestRunner {

    public static void main(String[] args) {

        // System.out.println("EXERCISE 1");

        BankAccount acc1 = new SavingsAccount("Test0");

        // //Test case 1
        // System.out.println("Test Case 1");
        // System.out.println("Account Owner: "
        //         + ((SavingsAccount) acc1).getOwnerName());

        // //Test case 2
        // System.out.println("Test Case 2");
        // try {
        //     acc1.deposit(1000.125);
        // } catch (InvalidAmountException | AccountFrozenException e) {
        //     System.out.println(e.getMessage());
        // }

        // //Test case 3
        // System.out.println("Test Case 3");
        // try {
        //     acc1.deposit(0);
        // } catch (InvalidAmountException | AccountFrozenException e) {
        //     System.out.println(e.getMessage());
        // }

        // //Test case 4
        // System.out.println("Test Case 4");
        // try {
        //     acc1.deposit(-500);
        // } catch (InvalidAmountException | AccountFrozenException e) {
        //     System.out.printf("Amount deposited: %.2f%n", -500.0);
        //     System.out.println(e.getMessage());
        // }

        // //Test case 5
        // System.out.println("Test Case 5");
        // try {
        //     acc1.withdraw(500);
        // } catch (InvalidAmountException |
        //          InsufficientFundsException |
        //          AccountFrozenException e) {
        //     System.out.println(e.getMessage());
        // }

        // //Test case 6
        // System.out.println("Test Case 6");
        // try {
        //     acc1.withdraw(1500);
        // } catch (InvalidAmountException |
        //          InsufficientFundsException |
        //          AccountFrozenException e) {
        //     System.out.printf("Amount withdrawn: %.2f%n", 1500.0);
        //     System.out.println(e.getMessage());
        //     acc1.printBalance();
        // }

        // //Test case 7
        // System.out.println("Test Case 7");
        // try {
        //     acc1.withdraw(-100);
        // } catch (InvalidAmountException |
        //          InsufficientFundsException |
        //          AccountFrozenException e) {
        //     System.out.printf("Amount withdrawn: %.2f%n", -100.0);
        //     System.out.println(e.getMessage());
        // }

        // //Test case 8
        // System.out.println("Test Case 8");
        // acc1.freezeAccount();

        // try {
        //     acc1.deposit(11500);
        // } catch (InvalidAmountException | AccountFrozenException e) {
        //     System.out.println(e.getMessage());
        // }

        // //Test case 9
        // System.out.println("Test Case 9");
        // try {
        //     acc1.withdraw(500);
        // } catch (InvalidAmountException |
        //          InsufficientFundsException |
        //          AccountFrozenException e) {
        //     System.out.println(e.getMessage());
        // }

        // //Test case 10
        // System.out.println("Test Case 10");
        // acc1.unfreezeAccount();

        // try {
        //     acc1.withdraw(100);
        // } catch (InvalidAmountException |
        //          InsufficientFundsException |
        //          AccountFrozenException e) {
        //     System.out.println(e.getMessage());
        // }

        // System.out.println();

        // // EXERCISE 2 TEST CASES

        // System.out.println("EXERCISE 2");

        // //Test case 1
        // System.out.println("\nTest Case 1: Transaction history");
        // System.out.println("Transaction history: "
        //         + acc1.getTransactionHistory());

        // //Test case 2
        // System.out.println("\nTest Case 2: Create account manager");
        // BankAccountManager accM1 = new BankAccountManager();

        // //Test case 3
        // System.out.println("\nTest Case 3: Add acc1");
        // accM1.addAccount(acc1);

        // //Test case 4
        // System.out.println("\nTest Case 4: Add a new account");
        // accM1.addAccount(new SavingsAccount("Test1"));

        // //Test case 5
        // System.out.println("\nTest Case 5: List all accounts");
        // accM1.listAccounts();


        // EXERCISE 3 TEST CASES

 
        // EXERCISE 3 TEST CASES

        System.out.println("\nEXERCISE 3");

        BankAccountManager accM3 = new BankAccountManager();
        BankAccount acc3 = new SavingsAccount("Test3");
        accM3.addAccount(acc3);

        // Prepare account balance and transaction history
        acc3.deposit(1000.125);
        acc3.withdraw(500);

        //Test case 1
        System.out.println("\nTest Case 1: Deposit negative amount");
        acc3.deposit(-500);

        //Test case 2
        System.out.println("\nTest Case 2: Deposit when account is frozen");
        acc3.freezeAccount();
        acc3.deposit(11500);
        acc3.unfreezeAccount();

        //Test case 3
        System.out.println("\nTest Case 3: Withdraw negative amount");
        acc3.withdraw(-100);

        //Test case 4
        System.out.println("\nTest Case 4: Insufficient funds");
        acc3.withdraw(1500);

        //Test case 5
        System.out.println("\nTest Case 5: Withdraw when account is frozen");
        acc3.freezeAccount();
        acc3.withdraw(500);
        acc3.unfreezeAccount();

        //Test case 6
        System.out.println("\nTest Case 6: Filter transactions");
        System.out.println("Filtering transactions at or above 200...");
        System.out.println(
            accM3.filterTransactionsAtOrAbove(
                200, acc3.getTransactionHistory())
        );

        // Add another valid withdrawal for the sorting test
        acc3.withdraw(100);

        //Test case 7
        System.out.println("\nTest Case 7: Sort transactions");
        System.out.println("Sorting transactions by amount...");
        System.out.println(
            accM3.sortTransactionsByAmount(
                acc3.getTransactionHistory())
        );
    }
}

