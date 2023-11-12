public class User {
    // Fields
    private String fullName;
    private String username;
    private String password;
    private Account accountType;

    // Constructors (You can add more as needed)
    public User(String fullName, String username, String password, Account accountType) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    }

    // Getters and Setters (You can generate these using your IDE)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccountType() {
        return accountType;
    }

    public void setAccountType(Account accountType) {
        this.accountType = accountType;
    }

    // Other methods can be added as needed
}
