
/**
 * A bank account that stores savings account owner information.
 */
public class SavingsAccount extends BankAccount {

    private String ownerName;

    public SavingsAccount(String ownerName) {
        super(ownerName);
        this.ownerName = ownerName;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
