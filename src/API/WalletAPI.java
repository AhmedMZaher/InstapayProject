package API;

import java.util.HashMap;

public class WalletAPI implements API {
    private HashMap<WalletDetails, Double> walletUsers;
    private static WalletAPI instance;

    private WalletAPI() {
        walletUsers = new HashMap<>();
        walletUsers.put(new WalletDetails("1234567890"), 1000.0);
        walletUsers.put(new WalletDetails("1234567891"), 1000.0);
        walletUsers.put(new WalletDetails("1234567892"), 1000.0);
    }
    
    public static WalletAPI getInstance() {
        if (instance == null) {
            instance = new WalletAPI();
        }
        return instance;
    }

    @Override
    public boolean authenticateUser(DetailsAPI userDetails) {
        for (WalletDetails walletDetailsUser : walletUsers.keySet()) {
            if (walletDetailsUser.equals(userDetails)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateBalance(DetailsAPI senderDetails, double amount) {
        if(!authenticateUser(senderDetails)) {
            return false;
        }
        for (HashMap.Entry<WalletDetails, Double> entry : walletUsers.entrySet()) {
            if (entry.getKey().equals(senderDetails)) {
                entry.setValue(amount);
                return true;
            }
        }
        return true;
    }

    @Override
    public double getAccountBalance(DetailsAPI userDetails) {
        for(HashMap.Entry<WalletDetails, Double> entry : walletUsers.entrySet()) {
            if(entry.getKey().equals(userDetails)) {
                return entry.getValue();
            }
        }
        return 0.0;
    }
}

