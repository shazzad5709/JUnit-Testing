package ir.maktab58.homework4.Bank;

import ir.maktab58.homework4.MyDate.MyDate;

public class Bank {
    public static String username = "admin";
    public static String password = "admin";
    private final static int minimumId = 100000;
    private final static int maximumId = 999999;
    private Customer[] customers = new Customer[0];
    private Account[] accounts = new Account[0];

    public void addNewCustomer(String firstName, String lastName){
        Customer[] newCustomers = new Customer[customers.length + 1];
        for (int i = 0; i < customers.length; i++){
            newCustomers[i] = new Customer(customers[i].getFirstName(), customers[i].getLastName());
            newCustomers[i].setAccounts(customers[i].getAccounts());
        }
        newCustomers[customers.length] = new Customer(firstName, lastName);
        customers = newCustomers;
    }

    public int calcCustomerIndex(String firstName, String lastName){
        for (int i = 0; i < customers.length; i++){
            if(firstName.equals(customers[i].getFirstName()) && lastName.equals(customers[i].getLastName()))
                return i;
        }
        return -1;
    }

    public long generateRandomId(){
        boolean checker = false;
        boolean uniqueness = true;
        int randomId = minimumId + (int) (Math.random() * (maximumId - minimumId + 1));
        while (!checker) {
            for (int i = 0; i < accounts.length; i++){
                if (accounts[i].getAccountNum() == (long)randomId) {
                    randomId = minimumId + (int) (Math.random() * (maximumId - minimumId + 1));
                    uniqueness = false;
                    break;
                }
            }
            if (uniqueness)
                checker = true;
        }
        return (long)randomId;
    }

    //add new checkingAccount or SavingAccount
    public void addNewAccount(int customerIndex, long initialBalance,
                              MyDate dateOfOpening, AccountType accountType){
        Account newAccount;
        switch (accountType) {
            case CHECKING_ACCOUNT:
                newAccount = new CheckingAccount(initialBalance, dateOfOpening, generateRandomId());
                break;
            case SAVING_ACCOUNT:
                newAccount = new SavingAccount(initialBalance, dateOfOpening, generateRandomId());
                break;
            default:
                newAccount = new Account(initialBalance, generateRandomId(), AccountType.CHECKING_ACCOUNT);
                break;
        }
        Account[] newAccounts = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++){
            newAccounts[i] = accounts[i];
            newAccount.setTransactions(accounts[i].getTransactions());
        }
        newAccounts[accounts.length] = newAccount;
        accounts = newAccounts;
        customers[customerIndex].addNewAccount(newAccount);
        System.out.println("New account is added successfully.");
    }

    //add new loanAccount
    public void addNewAccount(int customerIndex, long initialBalance, MyDate dateOfOpening,
                              long loanAmount, double loanInterest, int numOfMonths){
        Account newAccount = new LoanAccount(initialBalance, generateRandomId(),
                loanAmount, loanInterest, numOfMonths);
        Account[] newAccounts = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++){
            newAccounts[i] = accounts[i];
            newAccount.setTransactions(accounts[i].getTransactions());
        }
        newAccounts[accounts.length] = newAccount;
        accounts = newAccounts;
        customers[customerIndex].addNewAccount(newAccount);
        System.out.println("New account is added successfully.");
    }

    public void showAllCustomerAccount(String firstName, String lastName){
        int customerIndex = calcCustomerIndex(firstName, lastName);
        if (customerIndex == -1){
            System.out.println("This customer is not existed!");
            return;
        }
        customers[customerIndex].printAllAccounts();
    }

    public void withdraw(long accountId, long amountOfTransfer, int day, int month, int year){
        MyDate dateOfTransaction = new MyDate(year, month, day);
        if (!dateOfTransaction.isValidDate(day, month, year)){
            System.out.println("Date is not valid. Please try again.");
            return;
        }
        for (int i = 0; i < accounts.length; i++){
            if (accountId == accounts[i].getAccountNum()){
                AccountType accountType = accounts[i].getAccountType();
                if (AccountType.CHECKING_ACCOUNT.getType().equals(accountType.getType())){
                    if (amountOfTransfer > CheckingAccount.getWithdrawalLimit()){
                        System.out.println("This is checking account and you're not allowed to withdraw " + amountOfTransfer + " T");
                        return;
                    }
                }
                if (accounts[i].getBalance() < amountOfTransfer){
                    System.out.println("This account balance is not enough.");
                    return;
                }
                long newAccountBalance = accounts[i].getBalance() - amountOfTransfer;
                accounts[i].setBalance(newAccountBalance);
                System.out.println("Transaction happened successfully!");
                System.out.println("Now, This account balance is " + newAccountBalance);
                Transaction newTransaction = new Transaction(amountOfTransfer, TransactionType.WITHDRAW);
                accounts[i].addNewTransaction(newTransaction);
                if (accounts[i].getAccountType().getType().equals(AccountType.CHECKING_ACCOUNT.getType())){
                    accounts[i].updateBalance();
                    Transaction feesTransaction = new Transaction(CheckingAccount.getFees(), TransactionType.FEES);
                    accounts[i].addNewTransaction(feesTransaction);
                }
                updateCustomerAccount(accountId, accounts[i]);
                return;
            }
        }
        System.out.println("Sorry! " + accountId + " This account is not existed.");
    }

    public void updateCustomerAccount(long accountId, Account account){
        long[] accountIds;
        for (int i = 0; i < customers.length; i++){
            accountIds = customers[i].calcAccountIds();
            for (int j = 0; j < accountIds.length; j++){
                if (accountIds[j] == accountId){
                    customers[i].editAccount(account);
                    return;
                }
            }
        }
    }

    public void deposit(long accountId, long amountOfTransfer, int day, int month, int year){
        MyDate dateOfTransaction = new MyDate(year, month, day);
        if (!dateOfTransaction.isValidDate(day, month, year)){
            System.out.println("Date is not valid. Please try again.");
            return;
        }
        for (int i = 0; i < accounts.length; i++){
            if (accountId == accounts[i].getAccountNum()){
                long newAccountBalance = accounts[i].getBalance() + amountOfTransfer;
                accounts[i].setBalance(newAccountBalance);
                System.out.println("Transaction happened successfully!");
                System.out.println("Now, This account balance is " + newAccountBalance);
                Transaction newTransaction = new Transaction(amountOfTransfer, TransactionType.DEPOSIT);
                accounts[i].addNewTransaction(newTransaction);
                if (accounts[i].getAccountType().getType().equals(AccountType.CHECKING_ACCOUNT.getType())){
                    accounts[i].updateBalance();
                    Transaction feesTransaction = new Transaction(CheckingAccount.getFees(), TransactionType.FEES);
                    accounts[i].addNewTransaction(feesTransaction);
                }
                updateCustomerAccount(accountId, accounts[i]);
                return;
            }
        }
        System.out.println("Sorry! " + accountId + "This account is not existed.");
    }

    public void calculateInterests(long accountId, int day, int month, int year){
        MyDate dateOfTransaction = new MyDate(year, month, day);
        if (!dateOfTransaction.isValidDate(day, month, year)){
            System.out.println("Date is not valid. Please try again.");
            return;
        }
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].getAccountNum() == accountId){
                AccountType accountType = accounts[i].getAccountType();
                if(accountType.getType().equals(AccountType.CHECKING_ACCOUNT.getType())){
                    System.out.println("This type of account doesn't have any interest.");
                    return;
                }
                if(accountType.getType().equals(AccountType.SAVING_ACCOUNT.getType())){
                    accounts[i].updateBalance();
                    Transaction newTransaction = new Transaction(accounts[i].calculateAmountOfInterest(), TransactionType.INTEREST);
                    accounts[i].addNewTransaction(newTransaction);
                    updateCustomerAccount(accountId, accounts[i]);
                    return;
                }
                if(accountType.getType().equals(AccountType.LOAN_ACCOUNT.getType())){
                    accounts[i].updateBalance();
                    Transaction newTransaction = new Transaction(accounts[i].calculateAmountOfInterest(), TransactionType.INTEREST);
                    accounts[i].addNewTransaction(newTransaction);
                    updateCustomerAccount(accountId, accounts[i]);
                    return;
                }
            }
        }
    }

    public void viewTransactions(long accountId){
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].getAccountNum() == accountId) {
                accounts[i].printAllTransactions();
                return;
            }
        }
        System.out.println("This accountId: " + accountId + " is not existed.");
    }
}
