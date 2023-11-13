package MainClasses;

import API.API;
import API.BankDetails;
import API.DetailsAPI;
import API.WalletDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import  API.BankAPI;
import  API.WalletAPI;

public class InstaPaySystem {

    private static InstaPaySystem instance ;
    private List<User> usersList;
    private API api;

    private InstaPaySystem() {
        usersList = new ArrayList<User>();
    }
    
    public List<User> getUsersList() {
        return usersList;
    }

    public static InstaPaySystem  getInstance(){
        if (instance == null){
            instance = new InstaPaySystem();
        }
        return instance;
    }


    public void signUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Choose account type (1 for Bank, 2 for Wallet):");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine();
        DetailsAPI userDetails;
        if (accountTypeChoice == 1) {
            api = BankAPI.getInstance();
            System.out.println("Enter your credit card number:");
            String creditCardNumber = scanner.nextLine();
            System.out.println("Enter your CVV:");
            String cvv = scanner.nextLine();
            System.out.println("Enter your bank name:");
            String bankName = scanner.nextLine();
            userDetails = new BankDetails(creditCardNumber,cvv,phoneNumber, bankName);
        } else if (accountTypeChoice == 2) {
            api = WalletAPI.getInstance();
            userDetails = new WalletDetails(phoneNumber);
        } else {
            System.out.println("Invalid choice. Sign-up aborted.");
            return;
        }

        // Authenticate user through API.API
        if (api.authenticateUser(userDetails)) {
            // Send OTP to the phone number
            String generatedOTP = generateOTP();
            System.out.println("OTP sent to your phone number. Enter the OTP to complete sign-up:");

            // Verify OTP
            String enteredOTP = scanner.nextLine();
            if (enteredOTP.equals(generatedOTP)) {
                // OTP verification successful, proceed with the sign-up process
                System.out.println("Enter a full name:");
                String fullName = scanner.nextLine();
                // Get username and verify uniqueness
                System.out.println("Enter a username:");
                String username = scanner.nextLine();
                if (isUsernameTaken(username)) {
                    System.out.println("Username is already taken. Sign-up aborted.");
                    return;
                }
                // Get password
                String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

                // Prompt the user to enter a password
                String password;
                do {
                    System.out.println("Enter a password (at least 8 characters, including uppercase, lowercase, digit, and special character):");
                    password = scanner.nextLine();

                    // Check if the entered password matches the regex
                    if (!password.matches(passwordRegex)) {
                        System.out.println("Invalid password! Please follow the specified criteria.");
                    }
                } while (!password.matches(passwordRegex));

                // Create and add a new user to the usersList
                Account account;
                if(userDetails instanceof BankDetails) {
                    account = new BankAccount(phoneNumber, (BankDetails) userDetails);
                } else {
                    account = new WalletAccount(phoneNumber, (WalletDetails) userDetails);
                }
                User newUser = new User(fullName, username, password, account);
                usersList.add(newUser);
                System.out.println("Sign-up is successful!");
            } else {
                System.out.println("OTP verification failed. Sign-up aborted.");
            }
        } else {
            System.out.println("Authentication failed. Sign-up aborted.");
        }
    }

    public User signIn(String username, String password) {
        // Logic to check if the user with the provided credentials exists in the usersList
        for (User user : usersList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Sign-in is successful!");
                return user; // Return the User object if found
            }
        }
        System.out.println("Invalid username or password. Sign-in failed.");
        return null; // Return null if user not found
    }


    private boolean isUsernameTaken(String username) {
        return usersList.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    public User isUserExist(String accountID) {
        for (User user : usersList) {
            if (user.getAccountType().getAccountID().equals(accountID)) {
                return user;
            }
        }
        return null;
    }

    private String generateOTP() {
        // Placeholder for OTP generation logic
        // For demonstration purposes, a simple implementation is used
        return "123456";
    }

    

}