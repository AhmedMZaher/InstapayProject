package Controllers;

import API.BankAPI;
import API.DetailsAPI;
import MainClasses.InstaPaySystem;
import MainClasses.User;

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
  public boolean transferToBankAccount(DetailsAPI senderUserDetails, DetailsAPI recieverUserDetails, double amount) {
    double senderBalance = BankAPI.getInstance().getAccountBalance(senderUserDetails);
    double recieverBalance = BankAPI.getInstance().getAccountBalance(recieverUserDetails);
    if(senderBalance >= amount) {
      BankAPI.getInstance().updateBalance(senderUserDetails, senderBalance - amount);
      BankAPI.getInstance().updateBalance(recieverUserDetails, recieverBalance + amount);
      return true;
    }
    return false;
  }

  public boolean transferToInstaPayAccount(DetailsAPI senderUserDetails, String accountID, double amount){
    User recieverUser = InstaPaySystem.getInstance().isUserExist(accountID);

    if (recieverUser == null || senderUserDetails == null) {
      return false;
    }

    return transferToBankAccount(senderUserDetails, recieverUser.getAccountType().getUserDetails(), amount);
  }
}
