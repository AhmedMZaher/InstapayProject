package API;

public class WalletDetails implements DetailsAPI {
  private String mobileNumber;
  private String provider;

  public WalletDetails(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  @Override
  public boolean equals(DetailsAPI other) {
    if (other == null) {
      return false;
    }
    if (other.getClass() != this.getClass()) {
      return false;
    }

    WalletDetails otherUser = (WalletDetails) other;

    return this.mobileNumber.equals(otherUser.mobileNumber);
  }
}
