package bankingapp;

import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = null;

        System.out.println("Choose Bank Type: 1. Nationalized  2. Cooperative");
        int bankType = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();
        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();

        if (bankType == 1) {
            bank = new NationalizedBank(bankName, branchName);
        } else {
            bank = new CooperativeBank(bankName, branchName);
        }

        Account acc = null;
        while (true) {
            System.out.println("\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Display Bank Info\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Account Type: 1. Savings 2. Current 3. Loan");
                    int type = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    String accNum = sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = sc.nextDouble();
                    acc = switch (type) {
                        case 1 -> new SavingsAccount(accNum, name, bal);
                        case 2 -> new CurrentAccount(accNum, name, bal);
                        case 3 -> new LoanAccount(accNum, name, bal);
                        default -> null;
                    };
                    if (acc != null) bank.openAccount(acc);
                    break;
                case 2:
                    if (acc != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                    } else {
                        System.out.println("No account found.");
                    }
                    break;
                case 3:
                    if (acc != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double with = sc.nextDouble();
                        acc.withdraw(with);
                    } else {
                        System.out.println("No account found.");
                    }
                    break;
                case 4:
                    bank.displayBankInfo();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
