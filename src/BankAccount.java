
public class BankAccount {

    private double balance;
    private boolean isFrozen;

    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
    }

 
     public void deposit(double amount) {
          if (isFrozen) {
               System.out.println("Account is FROZEN.");
               System.out.println("Unable to transact.");
               return;
          }

          if (amount <= 0) {
               System.out.println("Amount deposited: " + amount);
               System.out.println("Invalid amount. Must be greater than 0");
          } else {
               balance += amount;
               System.out.printf("Amount deposited: %.2f%n", amount);
               System.out.printf("Current balance: %.2f%n", balance);
          }
}


    public void withdraw(double amount) {
        if (isFrozen) {
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
        } else {
            System.out.println("Amount withdrawn: " + amount);

            if (!Double.isFinite(amount) || amount <= 0) {
                System.out.println("Invalid amount. Must be greater than 0");
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
                System.out.printf("Current balance: %.2f%n", balance);
            } else {
                balance -= amount;
                System.out.printf("Current balance: %.2f%n", balance);
            }
        }
    }

    public double getBalance() {
        return balance;
    }

    public void freezeAccount() {
        isFrozen = true;
    }

    public void unfreezeAccount() {
        isFrozen = false;
    }

    public boolean isFrozen() {
        return isFrozen;
    }
}
