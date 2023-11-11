import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstaPaySystem {

    private List<User> usersList;
    private API api;

    public InstaPaySystem(API api) {
        this.usersList = new ArrayList<>();
        this.api = api;
    }

    public void signUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Choose account type (1 for Bank, 2 for Wallet):");
        int accountTypeChoice = scanner.nextInt();
        scanner.nextLine();
        UserDetailsAPI userDetails;
        if (accountTypeChoice == 1) {
            System.out.println("Enter your credit card number:");
            String creditCardNumber = scanner.nextLine();
            System.out.println("Enter your CVV:");
            String cvv = scanner.nextLine();
            userDetails = new BankUser(creditCardNumber, cvv, phoneNumber);
        } else if (accountTypeChoice == 2) {
            userDetails = new WalletUser(phoneNumber);
        } else {
            System.out.println("Invalid choice. Sign-up aborted.");
            return;
        }

        // Authenticate user through API
        if (api.authenticateUser(userDetails)) {
            // Send OTP to the phone number
            String generatedOTP = generateOTP();
            System.out.println("OTP sent to your phone number. Enter the OTP to complete sign-up:");

            // Verify OTP
            String enteredOTP = scanner.nextLine();
            if (enteredOTP.equals(generatedOTP)) {
                // OTP verification successful, proceed with the sign-up process

                // Get username and verify uniqueness
                System.out.println("Enter a username:");
                String username = scanner.nextLine();
                if (isUsernameTaken(username)) {
                    System.out.println("Username is already taken. Sign-up aborted.");
                    return;
                }

                // Get password
                System.out.println("Enter a password:");
                String password = scanner.nextLine();

                // Create and add a new user to the usersList
                Account account;
                if(userDetails instanceof BankUser) {
                    account = new BankAccount(phoneNumber, "Bank", ((BankUser) userDetails).getCvv(), ((BankUser) userDetails).getCreditCardNumber());
                } else {
                    account = new WalletAccount(phoneNumber, "Wallet");
                }
                User newUser = new User("Ahmed Zaher", username, password, account);
                usersList.add(newUser);
                System.out.println("Sign-up successful!");
            } else {
                System.out.println("OTP verification failed. Sign-up aborted.");
            }
        } else {
            System.out.println("User authentication failed. Sign-up aborted.");
        }
    }

    public boolean signIn(String username, String password) {
        // Logic to check if the user with the provided credentials exists in the usersList
        boolean userExists = usersList.stream()
                .anyMatch(user -> user.getUsername().equals(username) && user.getPassword().equals(password));
        if (userExists) {
            System.out.println("Sign-in successful!");
            return true;
        } else {
            System.out.println("Invalid username or password. Sign-in failed.");
            return false;
        }
    }


    private boolean isUsernameTaken(String username) {
        return usersList.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    private String generateOTP() {
        // Placeholder for OTP generation logic
        // For demonstration purposes, a simple implementation is used
        return "123456";
    }
}