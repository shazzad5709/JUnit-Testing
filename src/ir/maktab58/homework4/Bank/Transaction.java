package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.*;

enum TransactionType{
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

public class Transaction {
    private MyDate dateOfTransaction;
    private long amount;
    private TransactionType transactionType;

    public Transaction(MyDate dateOfTransaction, long amount, TransactionType transactionType) {
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public MyDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public void setDateOfTransaction(MyDate dateOfTransaction) {
        this.dateOfTransaction = dateOfTransaction;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "dateOfTransaction=" + dateOfTransaction.toString() +
                ", amount=" + amount +
                ", transactionType=" + transactionType.getType() +
                '}';
    }
}
