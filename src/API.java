interface API {
    boolean authenticateUser(UserDetailsAPI userDetails);

    boolean updateBalance(UserDetailsAPI senderDetails, double amount);
    
    double getAccountBalance(UserDetailsAPI userDetails);
}
