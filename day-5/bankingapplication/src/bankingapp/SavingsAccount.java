package bankingapp;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    public void showAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}
