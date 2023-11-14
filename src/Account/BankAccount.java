package Account;

import API.BankAPI;
import API.BankDetails;

public class BankAccount extends Account {

    public BankAccount(String mobileNumber, BankDetails bankDetails) {
        super(mobileNumber);
        this.userDetails = bankDetails;
    }


    @Override
    public double getAccountBalance() {
        return BankAPI.getInstance().getAccountBalance(userDetails);
    }

    @Override
    public void updateAccountBalance(double amount) {
        BankAPI.getInstance().updateBalance(userDetails, amount);
    }
}
