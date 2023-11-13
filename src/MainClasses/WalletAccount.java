package MainClasses;

import API.DetailsAPI;
import API.WalletAPI;
import API.WalletDetails;

public class WalletAccount extends Account {
    private String provider;

    public WalletAccount(String mobileNumber, String provider, WalletDetails walletDetails) {
        super(mobileNumber);
        this.provider = provider;
        this.userDetails = walletDetails;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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