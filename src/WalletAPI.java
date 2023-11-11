import java.util.HashMap;
import java.util.Map;

public class WalletAPI{

    private Map<String, API> walletApis;

    public double getBalance(String accountID, String proivder) {
        API currentAPI = walletApis.get(proivder);
        return currentAPI.getBalance(accountID);
    }



    public void updateBalance(double amount, String proivder) {
        API currentAPI = walletApis.get(proivder);
        currentAPI.updateBalance(amount);
    }

    public boolean search(String mobileNumber) {
        API currentAPI = walletApis.get(mobileNumber);
        return currentAPI.search(mobileNumber);
    }
}
