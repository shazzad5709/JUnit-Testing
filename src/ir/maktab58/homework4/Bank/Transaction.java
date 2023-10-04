package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.*;

public class Transaction {
    private long amount;
    private TransactionType transactionType;

    public Transaction(long amount, TransactionType transactionType) {
        this.amount = amount;
        this.transactionType = transactionType;
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
                ", amount=" + amount +
                ", transactionType=" + transactionType.getType() +
                '}';
    }
}
