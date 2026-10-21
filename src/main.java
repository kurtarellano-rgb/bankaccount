public class main {

    public static void main(String[] args) {
       
    //Test 1
        BankAccount acc1 = new SavingsAccount("Test 0");
        System.out.println("Account Owner: " + ((SavingsAccount) acc1).getOwnerName());
    //Test 2
        acc1.deposit(1000.125);
    }

}
