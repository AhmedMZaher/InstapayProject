public class VodafoneAPI implements API{
    @Override
    public double getBalance(String accountID) {
        // For simplicity, we'll use a dummy value; you should replace this with actual API calls
        return 150;
    }

    @Override
    public void updateBalance(double amount) {
        // you should replace this with actual API calls
    }

    @Override
    public boolean search(String mobileNumber) {
        // For simplicity, we'll assume that account is not exist; you should replace this with actual API calls

        return false;
    }
}
