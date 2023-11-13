package Controllers;

import java.util.Scanner;

import API.BankDetails;
import API.WalletDetails;
import MainClasses.BankAccount;
import MainClasses.InstaPaySystem;
import MainClasses.User;

public class ApplicationController {
  Scanner scanner = new Scanner(System.in);
  int choice;
  User user;
  private static ApplicationController instance;

  private ApplicationController() {

  }
  
  public static ApplicationController getInstance() {
    if (instance == null) {
      instance = new ApplicationController();
    }
    return instance;
  }

  private void signedInHome() {
    while (true) {
      System.out.println("\nChoose an option:");
      System.out.println("0. Logout");
      System.out.println("1. Check balance");
      System.out.println("2. Check account details");
      System.out.println("3. Pay bill");
      System.out.println("4. Transfer to a wallet");
      System.out.println("5. Transfer to a instapay account");
      
      if (user.getAccountType() instanceof BankAccount)
        System.out.println("6. Transfer to a bank account");
          
      choice = scanner.nextInt();
      scanner.nextLine();
      if(choice == 0) {
        user = null;
        System.out.println("Logged out");
        break;
      }
      else if (choice == 1) {
        System.out.println("Balance: " + user.getAccountType().getAccountBalance());
      } else if(choice == 2) {
        System.out.println("Account ID: " + user.getAccountType().getAccountID());
      }
      else if (choice == 3) {
        if (AccountController.getInstance().payBill(user)) {
          System.out.println("Payment successful");
        } else {
          System.out.println("Payment failed");
        }
      }else if (choice == 4) {
          WalletDetails sender, receiver;
          
          System.out.println("Enter receiver phone number: ");
          String receiverPhone = scanner.nextLine();

          System.out.println("Enter amount: ");
          double amount = scanner.nextDouble();

          sender = new WalletDetails(user.getAccountType().getMobileNumber());
          receiver = new WalletDetails(receiverPhone);

          AccountController.getInstance().transferToWalletAccount(sender, receiver, amount);
      }else if (choice == 5) {
          System.out.println("Enter account ID: ");
          String accountID = scanner.nextLine();

          System.out.println("Enter amount: ");
          double amount = scanner.nextDouble();
          
          boolean result = AccountController.getInstance().transferToInstaPayAccount(user.getAccountType(), accountID,
              amount);
          if(!result) {
            System.out.println("Insufficient balance");
          } else {
            System.out.println("Transfer successful");
          }
      }else if (choice == 6 && user.getAccountType() instanceof BankAccount) {
          BankDetails sender, receiver;

          System.out.println("Enter receiver credit card number: ");
          String receiverCreditCard = scanner.nextLine();

          System.out.println("Enter receiver cvv: ");
          String receiverCvv = scanner.nextLine();

          System.out.println("Enter receiver phone number: ");
          String receiverPhone = scanner.nextLine();

          System.out.println("Enter amount: ");
          double amount = scanner.nextDouble();

          String senderCreditCard = ((BankAccount) user.getAccountType()).getCreditCardNumber();
          String senderCvv = ((BankAccount) user.getAccountType()).getCvv();

          sender = new BankDetails(senderCreditCard, senderCvv, user.getAccountType().getMobileNumber());
          receiver = new BankDetails(receiverCreditCard, receiverCvv, receiverPhone);

          BankAccountController.getInstance().transferToBankAccount(sender, receiver, amount);
      }else {
          System.out.println("Invalid input! process is aborted");
          return;
      }
    }
    
  }
  private void signInHandler() {
        String username, pass;
        System.out.println("Enter your username: ");
        username = scanner.nextLine();
        System.out.println("Enter your password: ");
        pass = scanner.nextLine();
        user = InstaPaySystem.getInstance().signIn(username, pass);
        if (user != null) {
            this.signedInHome();
        }
    }
  public void home() {
    System.out.println("Welcome to InstaPay System!");
    while (true) {
        System.out.println("\nChoose an option:");
        System.out.println("1. Sign Up");
        System.out.println("2. Sign In");
        System.out.println("3. Exit");
        choice = scanner.nextInt();
        scanner.nextLine(); 
        switch (choice) {
            case 1:
                InstaPaySystem.getInstance().signUp();
                break;
            case 2:
                this.signInHandler();
                break;
            case 3:
                System.out.println("Exiting program. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
        }
    }
  }
}
