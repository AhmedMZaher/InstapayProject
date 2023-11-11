public class SquareBankAPI implements API{

    @Override
    public double getBalance(String accountID) {
        // For simplicity, we'll use a dummy value; you should replace this with actual API calls
        return 120;
    }

    @Override
    public void updateBalance(double amount) {
//        you should replace this with actual API calls
    }

    @Override
    public boolean search(String mobileNumber) {
        // For simplicity, we'll assume that account is exist; you should replace this with actual API calls
        return true;
    }
}
