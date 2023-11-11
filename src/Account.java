public class Account {
    private String accountID;
    private String mobileNumber;
    private double balance;

    public Account(String accountID, String mobileNumber, double balance) {
        this.accountID = accountID;
        this.mobileNumber = mobileNumber;
        this.balance = balance;
    }

    public boolean transferToWalletAccount(WalletAccount walletAccount, double amount) {
        // TODO
        return false;
    }
    public boolean transferToInstaPayAccount(Account instaPayAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            instaPayAccount.setBalance(instaPayAccount.getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }
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
}
