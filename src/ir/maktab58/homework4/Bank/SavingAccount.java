package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.*;

public class SavingAccount extends Account{
    private static double monthlyInterest = 0.1;

    public SavingAccount(long balance, MyDate dateOfOpening, long accountNum) {
        super(balance, accountNum, AccountType.SAVING_ACCOUNT);
    }

    @Override
    public void updateBalance() {
        balance += balance * monthlyInterest;
    }

    @Override
    public long calculateAmountOfInterest() {
        return (long)(balance * monthlyInterest);
    }

    public static double getMonthlyInterest() {
        return monthlyInterest;
    }

    public static void setMonthlyInterest(double monthlyInterest) {
        SavingAccount.monthlyInterest = monthlyInterest;
    }
}

