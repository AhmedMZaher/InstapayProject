public class WalletUser implements UserDetailsAPI {
  private String mobileNumber;

  public WalletUser(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  @Override
  public boolean equals(UserDetailsAPI other) {
    if (other == null) {
      return false;
    }
    if (other.getClass() != this.getClass()) {
      return false;
    }

    WalletUser otherUser = (WalletUser) other;

    return this.mobileNumber.equals(otherUser.mobileNumber);
  }
}
