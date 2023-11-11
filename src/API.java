import java.util.HashMap;
interface API {
    boolean authenticateUser(HashMap<String, String> userDetails);
    boolean transferMoney(HashMap<String, String> fromAccount, HashMap<String, String> toAccount, double amount);
}
