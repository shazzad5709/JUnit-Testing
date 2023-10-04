package ir.maktab58.homework4.Bank;

public enum TransactionType {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw"),
    FEES("fees"),
    INTEREST("interest");

    private String type;

    TransactionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
