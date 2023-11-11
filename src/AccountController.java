public class AccountController {
    private static AccountController instance;

    private AccountController() {

    }
    
    public static AccountController getInstance() {
        if (instance == null) {
            instance = new AccountController();
        }
        return instance;
    }
    public boolean transferToWalletAccount(String senderMobileNumber, String recieverMobileNumber, double amount) {
        UserDetailsAPI recieverAccount = new WalletUser(recieverMobileNumber);
        UserDetailsAPI senderAccount = new WalletUser(senderMobileNumber);
        double senderBalance = WalletAPI.getInstance().getAccountBalance(senderAccount);
        double recieverBalance = WalletAPI.getInstance().getAccountBalance(recieverAccount);
        if(senderBalance >= amount) {
            WalletAPI.getInstance().updateBalance(senderAccount, senderBalance - amount);
            WalletAPI.getInstance().updateBalance(recieverAccount, recieverBalance + amount);
            return true;
        }
        return false;
    }
    public boolean transferToInstaPayAccount(Account instaPayAccount, double amount) {
        // TODO
        return false;
    }

}
