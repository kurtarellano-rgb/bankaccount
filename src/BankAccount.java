
/** Represents a bank account with deposit, withdrawal, and freeze controls. */
public class BankAccount {

    private double balance;
    private boolean isFrozen;

    public BankAccount() {
        balance = 0.0;
        isFrozen = false;
    }

    public void deposit(double amount) {
        if (isFrozen) {
<<<<<<< HEAD
            System.out.println("The account is frozen!");
        } else if (amount<= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            balance += amount;
            System.out.printf("Deposited: %.2f%n", amount);
        }
   }

   public void withdraw(double amount){
        if (isFrozen) {
            System.out.println("The account is frozen!");
        } else if (amount<= 0 || amount > balance) {
            System.out.println("Invalid withdrawal amount.");
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f%n", amount);
=======
            System.out.println("Account is FROZEN.");
            System.out.println("Unable to transact.");
            return;
>>>>>>> a9b7c2dd70800d35b9705b41f7aeeb825366a70b
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
