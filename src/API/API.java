package API;

public interface API {
    boolean authenticateUser(DetailsAPI userDetails);

    boolean updateBalance(DetailsAPI senderDetails, double amount);
    
    double getAccountBalance(DetailsAPI userDetails);
}
