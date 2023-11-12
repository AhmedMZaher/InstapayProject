package Controllers;

import API.BankAPI;
import API.DetailsAPI;
import API.WalletAPI;
import MainClasses.Account;

class AccountController {
    private static AccountController instance;

    private AccountController() {

    }
    
    public static AccountController getInstance() {
        if (instance == null) {
            instance = new AccountController();
        }
        return instance;
    }
    public boolean transferToWalletAccount(DetailsAPI senderUserDetails, DetailsAPI recieverUserDetails, double amount) {

        double senderBalance = BankAPI.getInstance().getAccountBalance(senderUserDetails);
        double recieverBalance = BankAPI.getInstance().getAccountBalance(recieverUserDetails);
        if(senderBalance >= amount) {
            WalletAPI.getInstance().updateBalance(senderUserDetails, senderBalance - amount);
            WalletAPI.getInstance().updateBalance(recieverUserDetails, recieverBalance + amount);
            return true;
        }
        return false;
    }
    public boolean transferToInstaPayAccount(Account instaPayAccount, double amount) {
        // TODO
        return false;
    }

}
