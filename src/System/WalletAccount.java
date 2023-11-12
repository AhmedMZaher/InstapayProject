public class WalletAccount extends Account {
    private String provider;
    public WalletAccount(String mobileNumber, String provider) {
        super(mobileNumber);
        this.provider = provider;
    }
    public String getProvider() {
        return provider;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    @Override
    public String getUserDetails() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserDetails'");
    }
    @Override
    public double getAccountBalance() {
        UserDetailsAPI userDetails = new WalletUser(this.getMobileNumber());
        return WalletAPI.getInstance().getAccountBalance(userDetails);
    }

}
