import java.util.HashMap;
import java.util.Map;

public class BankAPI{

    private Map<String, API> bankApis;

    public double getBalance(String accountID, String bankName) {
        API currentAPI = bankApis.get(bankName);
        return currentAPI.getBalance(accountID);
    }



    public void updateBalance(double amount, String bankName) {
        API currentAPI = bankApis.get(bankName);
        currentAPI.updateBalance(amount);
    }

    public boolean search(String mobileNumber) {
        API currentAPI = bankApis.get(bankName);
        return currentAPI.search(mobileNumber);
    }
}
