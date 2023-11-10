public class Account {
    // Fields
    private String accountID;
    private String mobileNumber;
    private double balance;

    // Constructors (You can add more as needed)
    public Account(String accountID, String mobileNumber, double balance) {
        this.accountID = accountID;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    // Getters and Setters (You can generate these using your IDE)
    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Other methods can be added as needed
}
