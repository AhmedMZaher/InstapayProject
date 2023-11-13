package MainClasses;

import API.DetailsAPI;
import API.WalletAPI;
import API.WalletDetails;

public class WalletAccount extends Account {

    public WalletAccount(String mobileNumber, WalletDetails walletDetails) {
        super(mobileNumber);
        this.userDetails = walletDetails;
    }

    @Override
    public double getAccountBalance() {
        DetailsAPI userDetails = new WalletDetails(this.getMobileNumber());
        return WalletAPI.getInstance().getAccountBalance(userDetails);
    }

    @Override
    public void updateAccountBalance(double amount) {
        DetailsAPI userDetails = new WalletDetails(this.getMobileNumber());
        WalletAPI.getInstance().updateBalance(userDetails, amount);
    }
}