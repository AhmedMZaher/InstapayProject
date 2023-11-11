public class BankAccountController {
  private static BankAccountController instance;

  private BankAccountController() {

  }
  
  public static BankAccountController getInstance() {
    if (instance == null) {
      instance = new BankAccountController();
    }
    return instance;
  }
  public boolean transferToBankAccount(UserDetailsAPI senderUserDetails, UserDetailsAPI recieverUserDetails, double amount) {
    double senderBalance = BankAPI.getInstance().getAccountBalance(senderUserDetails);
    double recieverBalance = BankAPI.getInstance().getAccountBalance(recieverUserDetails);
    if(senderBalance >= amount) {
      BankAPI.getInstance().updateBalance(senderUserDetails, senderBalance - amount);
      BankAPI.getInstance().updateBalance(recieverUserDetails, recieverBalance + amount);
      return true;
    }
    return false;
  }
}
