package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.*;

public class Account {
    protected long balance;
    protected long accountNum;
    protected final AccountType accountType;
    protected Transaction[] transactions = new Transaction[0];

    public Account(long balance, long accountNum, AccountType accountType) {
        this.balance = balance;
        this.accountNum = accountNum;
        this.accountType = accountType;
    }

    public void updateBalance(){

    }

    public long calculateAmountOfInterest(){
        return 0;
    }

    public void addNewTransaction(Transaction transaction){
        Transaction[] newTransactions = new Transaction[transactions.length + 1];
        for (int i = 0; i < transactions.length; i++){
            newTransactions[i] = transactions[i];
        }
        newTransactions[transactions.length] = transaction;
        transactions = newTransactions;
    }

    public void printAllTransactions(){
        for (int i = 0; i < transactions.length; i++)
            System.out.println(transactions[i].toString());
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }



    public long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(long accountNum) {
        this.accountNum = accountNum;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Transaction[] getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction[] transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNum=" + accountNum +
                ", accountType=" + accountType.getType() +
                '}';
    }
}
