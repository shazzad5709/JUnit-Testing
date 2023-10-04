package ir.maktab58.homework4.Bank.Test;
import ir.maktab58.homework4.Bank.Account;
import ir.maktab58.homework4.Bank.Transaction;
import ir.maktab58.homework4.Bank.TransactionType;
import ir.maktab58.homework4.Bank.AccountType;
import org.junit.jupiter.api.*;

public class AccountTest {
    private Account account;
    private static Transaction[] transactionArrayList;

    @BeforeAll
    static void beforeAll() {
        Transaction deposit = new Transaction(200, TransactionType.DEPOSIT);
        Transaction fees = new Transaction(500, TransactionType.FEES);
        Transaction interest = new Transaction(100, TransactionType.INTEREST);
        Transaction withdraw = new Transaction(100, TransactionType.WITHDRAW);
        transactionArrayList = new Transaction[]{deposit, fees, interest, withdraw};
    }

    @BeforeEach
    public void setUp() {
        account = new Account(1000, 123456789, AccountType.SAVING_ACCOUNT);
        account.setTransactions(transactionArrayList);
    }

    @Test
    @DisplayName("Test to add a new transaction for addNewTransaction method")
    void addNewTransactionInExistingTransactionArrayTest() {
        Transaction transaction = new Transaction(100, TransactionType.DEPOSIT);
        account.addNewTransaction(transaction);
        Assertions.assertEquals(transaction, account.getTransactions()[account.getTransactions().length - 1]);
    }

    @Test
    @DisplayName("Test to add a new transaction for addNewTransaction method")
    void addNewTransactionInEmptyTransactionArrayTest() {
        Transaction transaction = new Transaction(100, TransactionType.DEPOSIT);
        account.setTransactions(new Transaction[0]);
        account.addNewTransaction(transaction);
        Assertions.assertEquals(transaction, account.getTransactions()[account.getTransactions().length - 1]);
    }
}
