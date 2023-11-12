class BankUser implements UserDetailsAPI {
  private String creditCardNumber;
  private String cvv;
  private String phoneNumber;

  public BankUser(String creditCardNumber, String cvv, String phoneNumber) {
    this.creditCardNumber = creditCardNumber;
    this.cvv = cvv;
    this.phoneNumber = phoneNumber;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public String getCvv() {
    return cvv;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public boolean equals(UserDetailsAPI other) {
    if (other == null) {
      return false;
    }

    if (other.getClass() != this.getClass()) {
      return false;
    }

    BankUser otherUser = (BankUser) other;

    return this.creditCardNumber.equals(otherUser.creditCardNumber) && this.cvv.equals(otherUser.cvv);
  }
}