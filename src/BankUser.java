class BankUser {
  private String creditCardNumber;
  private String cvv;
  private double accountBalance;

  public BankUser(String creditCardNumber, String cvv, double accountBalance) {
      this.creditCardNumber = creditCardNumber;
      this.cvv = cvv;
      this.accountBalance = accountBalance;
  }

  public String getCreditCardNumber() {
      return creditCardNumber;
  }

  public String getCvv() {
      return cvv;
  }

  public double getAccountBalance() {
    return accountBalance;
  }
  
  public void setAccountBalance(double accountBalance) {
      this.accountBalance = accountBalance;
  }
}