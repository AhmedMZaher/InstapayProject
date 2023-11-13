package MainClasses;


import API.BankAPI;
import API.DetailsAPI;
import API.WalletDetails;
import Controllers.BankAccountController;
import Controllers.AccountController;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sign Up/Sign In Program!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    InstaPaySystem.getInstance().signUp();
                    break;
                case 2:
                    String username, pass;
                    System.out.println("Enter your username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    pass = scanner.nextLine();
                    User user = InstaPaySystem.getInstance().signIn(username, pass);
                    if (user != null) {
                        System.out.println("\nChoose an option:");
                        System.out.println("1. Transfer to a wallet");
                        System.out.println("2. Transfer to a instapay account");
                        if (user.getAccountType() instanceof BankAccount)
                            System.out.println("3. Transfer to a bank account");
                         choice = scanner.nextInt();

                        if(choice == 1){
                            WalletDetails sender,reciver;
                            String recieverPhone = scanner.nextLine();
                            double amount = scanner.nextDouble();
                            sender = new WalletDetails(user.getAccountType().getMobileNumber());
                            reciver = new WalletDetails(recieverPhone);
                            AccountController.getInstance().transferToWalletAccount(sender,reciver,amount);

                        } else if (choice == 2) {
                            // TODO
                        }else if (choice == 3) {
                            // TODO
                        }
                        else{
                            System.out.println("Invalid input! process is aborted");
                            return;
                        }
                    }
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
