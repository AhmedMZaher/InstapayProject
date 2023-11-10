public class BankAccount extends Account {
    // Additional field
    private String bankName;

    // Constructors (You can add more as needed)
    public BankAccount(String accountID, String mobileNumber, double balance, String bankName) {
        super(accountID, mobileNumber, balance);
        this.bankName = bankName;
    }

    // Getter and Setter for bankName
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    // Method for transferring to another bank account
    public void transferToBankAccount() {
        // Implementation for transferring to another bank account
        // You can add your logic here
        System.out.println("Transfer to another bank account initiated.");
    }
}
