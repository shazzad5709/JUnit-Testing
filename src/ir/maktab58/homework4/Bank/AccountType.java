package ir.maktab58.homework4.Bank;

public enum AccountType {
    CHECKING_ACCOUNT("checking"),
    SAVING_ACCOUNT("saving"),
    LOAN_ACCOUNT("loan");

    private String type;

    AccountType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
