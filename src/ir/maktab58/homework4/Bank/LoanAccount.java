package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.*;

public class LoanAccount extends Account{
    private long loanAmount;
    private double loanInterest;
    private int numOfMonths;

    public LoanAccount(long balance, MyDate dateOfOpening, long accountNum,
                       long loanAmount, double loanInterest, int numOfMonths) {
        super(balance, dateOfOpening, accountNum, AccountType.LOAN_ACCOUNT);
        this.loanAmount = loanAmount;
        this.loanInterest = loanInterest;
        this.numOfMonths = numOfMonths;
    }

    @Override
    public void updateBalance() {
        balance -= loanAmount * loanInterest / numOfMonths;
    }

    @Override
    public long calculateAmountOfInterest() {
        return (long) ((loanAmount * loanInterest) / numOfMonths);
    }

    public long getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(long loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getLoanInterest() {
        return loanInterest;
    }

    public void setLoanInterest(double loanInterest) {
        this.loanInterest = loanInterest;
    }

    public int getNumOfMonths() {
        return numOfMonths;
    }

    public void setNumOfMonths(int numOfMonths) {
        this.numOfMonths = numOfMonths;
    }

    @Override
    public String toString() {
        return "LoanAccount{" +
                "balance=" + balance +
                ", dateOfOpening=" + dateOfOpening.toString() +
                ", accountNum=" + accountNum +
                ", accountType=" + accountType.getType() +
                ", loanAmount=" + loanAmount +
                ", loanInterest=" + loanInterest +
                ", numOfMonths=" + numOfMonths +
                '}';
    }
}
