package MainClasses;

import API.BankAPI;
import API.BankDetails;
import API.DetailsAPI;

public class BankAccount extends Account {
    private String bankName;
    private String cvv;
    private String creditCardNumber;
    public BankAccount(String mobileNumber, String bankName, String cvv, String creditCardNumber) {
        super(mobileNumber);
        this.bankName = bankName;
        this.cvv = cvv;
        this.creditCardNumber = creditCardNumber;
    }
    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getCreditCardNumber() {
        return creditCardNumber;
    }
    @Override
    public String getUserDetails() {
        return this.getMobileNumber() + " " + this.getBankName() + " " + this.getCreditCardNumber() + " " + this.getCvv();
    }
    @Override
    public double getAccountBalance() {
        DetailsAPI userDetails = new BankDetails(this.getCreditCardNumber(), this.getCvv(), this.getMobileNumber());
        return BankAPI.getInstance().getAccountBalance(userDetails);
    }

    @Override
    public void UpdateAccountBalance(double amount) {
        DetailsAPI userDetails = new BankDetails(this.getCreditCardNumber(), this.getCvv(), this.getMobileNumber());
        BankAPI.getInstance().updateBalance(userDetails, amount);
    }
}
