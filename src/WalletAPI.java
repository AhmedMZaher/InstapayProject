import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletAPI implements API {
    private List<WalletUser> walletUsers;
    public WalletAPI(){
        walletUsers = new ArrayList<>();
        walletUsers.add(new WalletUser("1234567890123456", 1000.0));
        walletUsers.add(new WalletUser("1234567890123457", 1000.0));
        walletUsers.add(new WalletUser("1234567890123458", 1000.0));
    }

    @Override
    public boolean authenticateUser(HashMap<String, String> userDetails) {
        for (WalletUser walletUser : walletUsers) {
            if (walletUser.getWalletId().equals(userDetails.get("walletId"))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean transferMoney(HashMap<String, String> fromAccount, HashMap<String, String> toAccount, double amount) {
        for (WalletUser walletUser : walletUsers) {
            if (walletUser.getWalletId().equals(fromAccount.get("walletId"))
                    && walletUser.getWalletBalance() >= amount) {
                walletUser.setWalletBalance(walletUser.getWalletBalance() - amount);
                return true;
            }
        }
        return false;
    }

}
