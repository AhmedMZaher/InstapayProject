package API;

public class BankDetails implements DetailsAPI {
  private String creditCardNumber;
  private String cvv;
  private String phoneNumber;
  private String bankName;

  public BankDetails(String creditCardNumber, String cvv, String phoneNumber, String bankName) {
    this.creditCardNumber = creditCardNumber;
    this.cvv = cvv;
    this.phoneNumber = phoneNumber;
    this.bankName = bankName;
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
  public boolean equals(DetailsAPI other) {
    if (other == null) {
      return false;
    }

    if (other.getClass() != this.getClass()) {
      return false;
    }

    BankDetails otherUser = (BankDetails) other;

    return this.creditCardNumber.equals(otherUser.creditCardNumber) && this.cvv.equals(otherUser.cvv) && this.phoneNumber.equals(otherUser.phoneNumber) && this.bankName.equals(otherUser.bankName);
  }
}