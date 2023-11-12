import java.util.HashMap;
public class BankAPI implements API {
    private HashMap<BankUser, Double> bankUsers;
    private static BankAPI instance;
    private BankAPI() {
        bankUsers = new HashMap<>();
        bankUsers.put(new BankUser("1234567890123456", "123", "1234567890"), 1000.0);
        bankUsers.put(new BankUser("1234567890123457", "123", "1234567890"), 1000.0);
        bankUsers.put(new BankUser("1234567890123458", "123", "1234567890"), 1000.0);
    }
    public static BankAPI getInstance() {
        if (instance == null) {
            instance = new BankAPI();
        }
        return instance;
    }
    @Override
    public boolean authenticateUser(UserDetailsAPI userDetails) {
        for (BankUser bankUser : bankUsers.keySet()) {
            if (bankUser.equals(userDetails)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean updateBalance(UserDetailsAPI fromAccount, double amount) {
        if(!authenticateUser(fromAccount)) {
            return false;
        }
        for (HashMap.Entry<BankUser, Double> entry : bankUsers.entrySet()) {
            if (entry.getKey().equals(fromAccount)) {
                entry.setValue(amount);
                return true;
            }
        }
        return false;
    }
    @Override
    public double getAccountBalance(UserDetailsAPI userDetails) {
        for(HashMap.Entry<BankUser, Double> entry : bankUsers.entrySet()) {
            if(entry.getKey().equals(userDetails)) {
                return entry.getValue();
            }
        }
        return 0.0;
    }

}
