
/** Runs the bank account test cases. */
class BankAccountTestRunner {

    /** Runs the bank account test cases. */
    public static void main(String[] args) {

        //Test case 1
        BankAccount acc1 = new SavingsAccount("Test0");
        System.out.println("Account Owner: "
                        + ((SavingsAccount) acc1).getOwnerName());

        //Test case 2
        System.out.println();
        acc1.deposit(1000.125);

        //Test case 3
        System.out.println();
        acc1.deposit(0);

        //Test case 4
        System.out.println();
        acc1.deposit(-500);

        //Test case 5
        System.out.println();
        acc1.withdraw(500);

        //Test case 6
        System.out.println();
        acc1.withdraw(1500);

        //Test case 7
        System.out.println();
        acc1.withdraw(-100);

        //Test case 8
        System.out.println();
        acc1.freezeAccount();
        acc1.deposit(11500);

        //Test case 9
        System.out.println();
        acc1.withdraw(500);

        //Test case 10
        System.out.println();
        acc1.unfreezeAccount();
        acc1.withdraw(100);
    }
}
