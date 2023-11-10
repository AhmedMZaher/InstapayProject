public class InstaPaySystem {
    private User[] usersList;

    private List<User> usersList;
    public InstaPaySystem() {
        this.usersList = new ArrayList<>();
    }

    // Method to sign up a new user
    public void signUp(User newUser) {
        // Logic to add the new user to the usersList array
        // You may want to add error handling for cases where the array is full
        // or the username/mobileNumber is already taken
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

    // Method to verify user information
    public boolean verify(String username, String mobileNumber) {
        // Logic to verify if the provided username and mobileNumber match any existing user
        // Return true if a match is found, otherwise return false
        return false; // Placeholder, replace with actual implementation
    }

    // Other methods can be added as needed
}
