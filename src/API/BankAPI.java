package API;

import java.util.HashMap;
public class BankAPI implements API {
    private HashMap<BankDetails, Double> bankUsers;
    private static BankAPI instance;
    private BankAPI() {
        bankUsers = new HashMap<>();
        bankUsers.put(new BankDetails("1234567890123456", "123", "1234567890"), 1000.0);
        bankUsers.put(new BankDetails("1234567890123457", "123", "1234567890"), 1000.0);
        bankUsers.put(new BankDetails("1234567890123458", "123", "1234567890"), 1000.0);
    }
    public static BankAPI getInstance() {
        if (instance == null) {
            instance = new BankAPI();
        }
        return instance;
    }
    @Override
    public boolean authenticateUser(DetailsAPI userDetails) {
        for (BankDetails bankDetailsUser : bankUsers.keySet()) {
            if (bankDetailsUser.equals(userDetails)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean updateBalance(DetailsAPI fromAccount, double amount) {
        if(!authenticateUser(fromAccount)) {
            return false;
        }
        for (HashMap.Entry<BankDetails, Double> entry : bankUsers.entrySet()) {
            if (entry.getKey().equals(fromAccount)) {
                entry.setValue(amount);
                return true;
            }
        }
        return false;
    }
    @Override
    public double getAccountBalance(DetailsAPI userDetails) {
        for(HashMap.Entry<BankDetails, Double> entry : bankUsers.entrySet()) {
            if(entry.getKey().equals(userDetails)) {
                return entry.getValue();
            }
        }
        return 0.0;
    }

}
