package MainClasses;
import API.BankAPI;
import API.DetailsAPI;
import API.WalletDetails;
import Controllers.BankAccountController;
import Controllers.AccountController;
import Controllers.ApplicationController;

public class Main {
    public static void main(String[] args) {
        ApplicationController.getInstance().home();
    }
}
