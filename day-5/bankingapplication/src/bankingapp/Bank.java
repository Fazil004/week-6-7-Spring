package bankingapp;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    private static int bankCount = 0;
    private final String bankCode;
    public static final String BANK_CODE_PREFIX = "BANK-";

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankCode = generateBankCode();
    }

    private String generateBankCode() {
        bankCount++;
        return BANK_CODE_PREFIX + String.format("%03d", bankCount);
    }

    public String getBankCode() {
        return bankCode;
    }

    public abstract void openAccount(Account account);
    public abstract void displayBankInfo();
}
