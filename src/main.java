
/** Runs the bank account test cases. */
class BankAccountTestRunner {

    /** Runs the bank account test cases. */
    public static void main(String[] args) {


        // //Test case 1
        System.out.println("            EXERCISE 1              ");
        BankAccount acc1 = new SavingsAccount("Test0");
        System.out.println("Test Case 1");
        System.out.println("Account Owner: "
                        + ((SavingsAccount) acc1).getOwnerName());

        //Test case 2
        System.out.println("Test Case 2");
        acc1.deposit(1000.125);

        //Test case 3
        System.out.println("Test Case 3");
        acc1.deposit(0);

        //Test case 4
        System.out.println("Test Case 4");
        acc1.deposit(-500);

        //Test case 5
        System.out.println("Test Case 5");
        acc1.withdraw(500);

        //Test case 6
        System.out.println("Test Case 6");
        acc1.withdraw(1500);

        //Test case 7
        System.out.println("Test Case 7");
        acc1.withdraw(-100);

        //Test case 8
        System.out.println("Test Case 8");
        acc1.freezeAccount();
        acc1.deposit(11500);

        //Test case 9
        System.out.println("Test Case 9");
        acc1.withdraw(500);

        //Test case 10
        System.out.println("Test Case 10");
        acc1.unfreezeAccount();
        acc1.withdraw(100);
        System.out.println();

        
        System.out.println("            EXERCISE 2              ");

        //Test case 1
        System.out.println("\nTest Case 1: Transaction History");
        System.out.println("------------------------------------");

        for (Transaction transaction : acc1.getTransactionHistory()) {
            System.out.println(transaction);
        }

        //Test case 2
        System.out.println("\nTest Case 2: Create Account Manager");
        System.out.println("------------------------------------");

        BankAccountManager accM1 = new BankAccountManager();
        System.out.println("Account Manager Created Successfully.");

        //Test case 3
        System.out.println("\nTest Case 3: Add Existing Account");
        System.out.println("------------------------------------");

        accM1.addAccount(acc1);
        System.out.println("Account Test0 Added Successfully.");

        //Test case 4
        System.out.println("\nTest Case 4: Add New Account");
        System.out.println("------------------------------------");

        accM1.addAccount(new SavingsAccount("Test1"));
        System.out.println("Account Test1 Added Successfully.");

        //Test case 5
        System.out.println("\nTest Case 5: List All Accounts");
        System.out.println("------------------------------------");

        accM1.listAccounts();


}
}