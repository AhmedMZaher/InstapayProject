package MainClasses;

public abstract class Account {
    protected String accountID;
    protected String mobileNumber;

    public Account(String mobileNumber) {
        this.accountID = String.valueOf((int)(Math.random()*9000) + 1000);
        this.mobileNumber = mobileNumber;
    }
    
    public String getAccountID() {
        return accountID;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public abstract double getAccountBalance();

    public abstract String getUserDetails();

    public abstract void UpdateAccountBalance(double amount);
}
