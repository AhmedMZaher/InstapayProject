public class WalletUser {
  private String walletId;
  private double walletBalance;

  public WalletUser(String walletId, double walletBalance) {
    this.walletId = walletId;
    this.walletBalance = walletBalance;
  }

  public String getWalletId() {
    return walletId;
  }

  public double getWalletBalance() {
    return walletBalance;
  }

  public void setWalletBalance(double walletBalance) {
    this.walletBalance = walletBalance;
  }
}
