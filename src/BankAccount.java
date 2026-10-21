public class BankAccount {

    private double balance;
    private boolean isFrozen;

   public BankAccount(){
        balance = 0.0;
        isFrozen = false;
   }

   public void deposit(double amount){
        if (isFrozen) {
            System.out.println("The account is frozen!");
        }  else if (!Double.isFinite(amount) || amount <= 0) {
        System.out.println("Invalid deposit amount.");
        }  else {
        balance += amount;
        System.out.printf("Deposited: %.2f%n", amount);
        System.out.printf("Current balance: %.2f%n", balance);
   }

   public void withdraw(double amount){
        if (isFrozen) {
            System.out.println("The account is frozen!");
        } else if (amount<= 0 || amount > balance) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f%n", amount);
        }
   }

   public double getBalance(){
        return balance;
   }

   public void freezeAccount(){
        isFrozen = true;
   }

   public void unfreezeAccount(){
        isFrozen = false;
   }
   
   public boolean isFrozen(){
        return isFrozen;
   }

}
