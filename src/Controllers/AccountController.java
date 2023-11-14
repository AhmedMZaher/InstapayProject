package Controllers;

import API.*;
import Account.Account;
import Account.BankAccount;
import Bill.ElectricityBill;
import Bill.GasBill;
import MainClasses.*;
import Account.WalletAccount;

import java.util.Scanner;

public class  AccountController {
    private static AccountController instance;

    private AccountController() {

    }

    public static AccountController getInstance() {
        if (instance == null) {
            instance = new AccountController();
        }
        return instance;
    }

    public boolean transferToWalletAccount(DetailsAPI senderUserDetails, DetailsAPI recieverUserDetails, double amount) {
        if(!WalletAPI.getInstance().authenticateUser(recieverUserDetails))
            return false;
        double senderBalance;
        if(senderUserDetails instanceof BankDetails)
            senderBalance = BankAPI.getInstance().getAccountBalance(senderUserDetails);
        else
            senderBalance = WalletAPI.getInstance().getAccountBalance(senderUserDetails);

        double recieverBalance = WalletAPI.getInstance().getAccountBalance(recieverUserDetails);

        if (senderBalance >= amount) {
            if(senderUserDetails instanceof BankDetails)
                BankAPI.getInstance().updateBalance(senderUserDetails, senderBalance - amount);
            else
                WalletAPI.getInstance().updateBalance(senderUserDetails, senderBalance - amount);

            WalletAPI.getInstance().updateBalance(recieverUserDetails, recieverBalance + amount);

            return true;
        }

        return false;
    }

    public boolean transferToInstaPayAccount(DetailsAPI senderUserDetails, String accountID, double amount) {
        User recieverUser = InstaPaySystem.getInstance().isUserExist(accountID);
        
        if (recieverUser == null || senderUserDetails == null) {
            return false;
        }

        return transferToWalletAccount(senderUserDetails, recieverUser.getAccountType().getUserDetails(), amount);
    }

    public boolean payBill(User user) {
        Scanner scanner = new Scanner(System.in);
        // ask the user for the type of bill
        System.out.println("Enter the type of bill you want to pay");
        System.out.println("1. Electricity");
        System.out.println("2. Gas");

        // get the type of bill
        int billType = scanner.nextInt();
        scanner.nextLine();
        if (billType == 1) {
            System.out.println("Enter the bill ID");
//            String billID = System.console().readLine();
            String billID = scanner.nextLine();
            ElectricityDetails electricityDetails = (ElectricityDetails) ElectricityBill.getInstance().getBillDetails(billID);
            if (electricityDetails != null) {
                double amount = electricityDetails.getRatePerUnit() * electricityDetails.getUnitsConsumed();
                Account account = user.getAccountType();

                if (account instanceof WalletAccount) {
                    WalletAccount walletAccount = (WalletAccount) account;
                    if (walletAccount.getAccountBalance() >= amount) {
                        walletAccount.updateAccountBalance(walletAccount.getAccountBalance() - amount);
                        return true;
                    }

                } else if (account instanceof BankAccount) {
                    BankAccount bankAccount = (BankAccount) account;
                    if (bankAccount.getAccountBalance() >= amount) {
                        bankAccount.updateAccountBalance(bankAccount.getAccountBalance() - amount);
                        return true;
                    }
                }
            }
        } else if (billType == 2) {
            System.out.println("Enter the bill ID");
            String billID = scanner.nextLine();

            GasDetails gasDetails = (GasDetails) GasBill.getInstance().getBillDetails(billID);
            if (gasDetails != null) {
                double amount = gasDetails.getPrice();
                Account account = user.getAccountType();

                if (account instanceof WalletAccount) {
                    WalletAccount walletAccount = (WalletAccount) account;
                    if (walletAccount.getAccountBalance() >= amount) {
                        walletAccount.updateAccountBalance(walletAccount.getAccountBalance() - amount);
                        return true;
                    }

                } else if (account instanceof BankAccount) {
                    BankAccount bankAccount = (BankAccount) account;
                    if (bankAccount.getAccountBalance() >= amount) {
                        bankAccount.updateAccountBalance(bankAccount.getAccountBalance() - amount);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
