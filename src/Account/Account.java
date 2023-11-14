package Account;

import API.DetailsAPI;

public abstract class Account {
    protected String accountID;
    protected String mobileNumber;
    protected DetailsAPI userDetails;
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

    public abstract void updateAccountBalance(double amount);

    public DetailsAPI getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(DetailsAPI userDetails) {
        this.userDetails = userDetails;
    }
}
