package MainClasses;

import API.BankAPI;
import API.BankDetails;

public class BankAccount extends Account {
    private String bankName;
    
    public BankAccount(String mobileNumber, String bankName, BankDetails bankDetails) {
        super(mobileNumber);
        this.bankName = bankName;
        this.userDetails = bankDetails;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
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
