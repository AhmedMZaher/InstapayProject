import java.util.HashMap;

public class WalletAPI implements API {
    private HashMap<WalletUser, Double> walletUsers;
    private static WalletAPI instance;

    private WalletAPI() {
        walletUsers = new HashMap<>();
        walletUsers.put(new WalletUser("1234567890"), 1000.0);
        walletUsers.put(new WalletUser("1234567891"), 1000.0);
        walletUsers.put(new WalletUser("1234567892"), 1000.0);
    }
    
    public static WalletAPI getInstance() {
        if (instance == null) {
            instance = new WalletAPI();
        }
        return instance;
    }

    @Override
    public boolean authenticateUser(UserDetailsAPI userDetails) {
        for (WalletUser walletUser : walletUsers.keySet()) {
            if (walletUser.equals(userDetails)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateBalance(UserDetailsAPI senderDetails, double amount) {
        if(!authenticateUser(senderDetails)) {
            return false;
        }
        for (HashMap.Entry<WalletUser, Double> entry : walletUsers.entrySet()) {
            if (entry.getKey().equals(senderDetails)) {
                entry.setValue(amount);
                return true;
            }
        }
        return true;
    }

    @Override
    public double getAccountBalance(UserDetailsAPI userDetails) {
        for(HashMap.Entry<WalletUser, Double> entry : walletUsers.entrySet()) {
            if(entry.getKey().equals(userDetails)) {
                return entry.getValue();
            }
        }
        return 0.0;
    }
}