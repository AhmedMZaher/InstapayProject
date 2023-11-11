import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankAPI implements API {
    private List<BankUser> bankUsers;

    public BankAPI() {
        bankUsers = new ArrayList<>();
        bankUsers.add(new BankUser("1234567890123456", "123", 1000.0));
        bankUsers.add(new BankUser("1234567890123457", "156", 1000.0));
        bankUsers.add(new BankUser("1234567890123458", "245", 1000.0));
    }

    @Override
    public boolean authenticateUser(HashMap<String, String> userDetails) {
        for (BankUser bankUser : bankUsers) {
            if (bankUser.getCreditCardNumber().equals(userDetails.get("creditCardNumber"))
                    && bankUser.getCvv().equals(userDetails.get("cvv"))) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean transferMoney(HashMap<String, String> fromAccount, HashMap<String, String> toAccount, double amount) {
        for (BankUser bankUser : bankUsers) {
            if (bankUser.getCreditCardNumber().equals(fromAccount.get("creditCardNumber"))
                    && bankUser.getCvv().equals(fromAccount.get("cvv"))
                    && bankUser.getAccountBalance() >= amount) {
                bankUser.setAccountBalance(bankUser.getAccountBalance() - amount);
                return true;
            }
        }
        return false;
    }

}
