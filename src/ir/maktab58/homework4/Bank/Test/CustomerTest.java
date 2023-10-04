package ir.maktab58.homework4.Bank.Test;
import ir.maktab58.homework4.Bank.AccountType;
import ir.maktab58.homework4.Bank.Customer;
import ir.maktab58.homework4.Bank.Account;
import org.junit.jupiter.api.*;

public class CustomerTest {
    private Customer customer;
    private static Account[] accounts;

    @BeforeAll
    static void beforeAll() {
        Account account1 = new Account(1000, 123456789, AccountType.SAVING_ACCOUNT);
        Account account2 = new Account(2000, 123456789, AccountType.CHECKING_ACCOUNT);
        Account account3 = new Account(3000, 123456789, AccountType.LOAN_ACCOUNT);
        accounts = new Account[]{account1, account2, account3};
    }

    @BeforeEach
    public void setUp() {
        customer = new Customer("Ali", "Ahmadi");
        customer.setAccounts(accounts);
    }

    @Test
    @DisplayName("Test to add a new account for a customer")
    void addNewAccountInExistingAccountArrayTest() {
        Account account = new Account(1000, 123456789, AccountType.SAVING_ACCOUNT);
        customer.addNewAccount(account);
        Assertions.assertEquals(account, customer.getAccounts()[customer.getAccounts().length - 1]);
    }

    @Test
    @DisplayName("Test to add a new transaction for addNewTransaction method")
    void addNewTransactionInEmptyTransactionArrayTest() {
        Account account = new Account(1000, 123456789, AccountType.SAVING_ACCOUNT);
        customer.setAccounts(new Account[0]);
        customer.addNewAccount(account);
        Assertions.assertEquals(account, customer.getAccounts()[customer.getAccounts().length - 1]);
    }

    @Test
    @DisplayName("Test to calculate index of an existing account")
    void calcIndexOfExistingAccountTest() {
        int accountIndex = customer.calcIndexOfAccounts(123456789);
        Assertions.assertEquals(0, accountIndex);
    }

    @Test
    @DisplayName("Test to calculate index of a non-existing account")
    void calcIndexOfNonExistingAccountTest() {
        int accountIndex = customer.calcIndexOfAccounts(987654321);
        Assertions.assertEquals(-1, accountIndex);
    }

    @Test
    @DisplayName("Test to calculate index of an account in an empty account array")
    void calcIndexOfAccountInEmptyAccountArrayTest() {
        customer.setAccounts(new Account[0]);
        int accountIndex = customer.calcIndexOfAccounts(123456789);
        Assertions.assertEquals(-1, accountIndex);
    }

    @Test
    @DisplayName("Test to inquire account balance of an existing account")
    void inquireAccountBalanceOfExistingAccountTest() {
        boolean result = customer.inquireAccountBalance(0);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Test to inquire account balance of a non-existing account")
    void inquireAccountBalanceOfNonExistingAccountTest() {
        boolean result = customer.inquireAccountBalance(-1);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Test to deposit money in an existing account")
    void depositMoneyInExistingAccountTest() {
        boolean result = customer.deposit(0, 1000);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Test to deposit money in a non-existing account")
    void depositMoneyInNonExistingAccountTest() {
        boolean result = customer.deposit(-1, 1000);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Test to withdraw money from an existing account")
    void withdrawMoneyFromExistingAccountTest() {
        boolean result = customer.withdraw(0, 1000);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Test to withdraw money from a non-existing account")
    void withdrawMoneyFromNonExistingAccountTest() {
        boolean result = customer.withdraw(-1, 1000);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Test to withdraw money from an existing account with a withdrawal limit")
    void withdrawMoneyFromExistingAccountWithWithdrawalLimitTest() {
        boolean result = customer.withdraw(1, 1000);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Test to withdraw money exceeding limit from an existing account with a withdrawal limit")
    void withdrawMoneyExceedingLimitFromExistingAccountWithWithdrawalLimitTest() {
        boolean result = customer.withdraw(1, 100000);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Test to withdraw money from a checking account")
    void withdrawMoneyFromCheckingAccountTest() {
        boolean result = customer.withdraw(1, 3000);
        Assertions.assertFalse(result);
    }

}
