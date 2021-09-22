package ir.maktab58.homework4.Bank;

public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts = new Account[0];

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addNewAccount(Account account){
        Account[] newAccounts = new Account[accounts.length + 1];
        for (int i = 0; i < accounts.length; i++){
            newAccounts[i] = accounts[i];
        }
        newAccounts[accounts.length] = account;
        accounts = newAccounts;
    }

    public int calcIndexOfAccounts(long accountId){
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].getAccountNum() == accountId)
                return i;
        }
        return -1;
    }

    public boolean inquireAccountBalance(int accountIndex){
        if (accountIndex == -1) {
            System.out.println("This account is not yours! Please try again.");
            return false;
        }
        System.out.println("Your balance is " + accounts[accountIndex].getBalance());
        return true;
    }

    public boolean deposit(int accountIndex, long chargeAmount){
        if (accountIndex == -1) {
            System.out.println("This account is not yours! Please try again.");
            return false;
        }
        long newAccountBalance = accounts[accountIndex].getBalance() + chargeAmount;
        accounts[accountIndex].setBalance(newAccountBalance);
        System.out.println("Your chargeAmount is added successfully!");
        System.out.println("Now, your balance is " + newAccountBalance);
        return true;
    }

    public boolean withdraw(int accountIndex, long dischargeAmount){
        if (accountIndex == -1) {
            System.out.println("This account is not yours! Please try again.");
            return false;
        }
        AccountType accountType = accounts[accountIndex].getAccountType();
        if (AccountType.CHECKING_ACCOUNT.getType().equals(accountType.getType())){
            if (dischargeAmount > CheckingAccount.getWithdrawalLimit()){
                System.out.println("You're not allowed to withdraw " + dischargeAmount + " T");
                return false;
            }
        }
        if (accounts[accountIndex].getBalance() < dischargeAmount){
            System.out.println("Your balance is not enough.");
            return false;
        }
        long newAccountBalance = accounts[accountIndex].getBalance() - dischargeAmount;
        accounts[accountIndex].setBalance(newAccountBalance);
        System.out.println("Your chargeAmount is added successfully!");
        System.out.println("Now, your balance is " + newAccountBalance);
        return true;
    }

    public void printAllAccounts(){
        for (int i = 0; i < accounts.length; i++){
            System.out.println(accounts[i].toString());
        }
    }

    public long[] calcAccountIds(){
        long[] accountIds = new long[accounts.length];
        for (int i = 0; i < accounts.length; i++)
            accountIds[i] = accounts[i].getAccountNum();
        return accountIds;
    }

    public void editAccount(Account account){
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i].getAccountNum() == account.getAccountNum()){
                accounts[i] = account;
                return;
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
}
