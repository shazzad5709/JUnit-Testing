package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.*;

public class CheckingAccount extends Account{
    private static long Fees = 700;
    private static long withdrawalLimit = 2000000;

    public CheckingAccount(long balance, MyDate dateOfOpening, long accountNum) {
        super(balance, dateOfOpening, accountNum, AccountType.CHECKING_ACCOUNT);
    }

    @Override
    public void updateBalance() {
        balance -= Fees;
    }

    public static long getFees() {
        return Fees;
    }

    public static void setFees(long fees) {
        Fees = fees;
    }

    public static long getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public static void setWithdrawalLimit(long withdrawalLimit) {
        CheckingAccount.withdrawalLimit = withdrawalLimit;
    }
}
