public class WalletAccount extends Account {
    // Additional field
    private String provider;

    // Constructors (You can add more as needed)
    public WalletAccount(String accountID, String mobileNumber, double balance, String provider) {
        super(accountID, mobileNumber, balance);
        this.provider = provider;
    }

    // Getter and Setter for provider
    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    // Other methods specific to WalletAccount can be added as needed
}
