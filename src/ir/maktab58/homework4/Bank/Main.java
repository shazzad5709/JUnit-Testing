package ir.maktab58.homework4.Bank;

import java.util.Scanner;
import ir.maktab58.homework4.MyDate.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        while (true) {
            System.out.println("***Welcome to bank system***");
            System.out.println("1) login as an admin");
            System.out.println("2) login as a customer");
            System.out.println("3) Exit");
            String inputLine = input.nextLine();
            inputLine = deleteLastSpaces(inputLine);
            if (inputLine.equals("1")) {
                System.out.println("Please Enter your username: ");
                String username = deleteLastSpaces(input.nextLine());
                System.out.println("Please Enter your password: ");
                String password = deleteLastSpaces(input.nextLine());
                if (!(username.equals(Bank.username))){
                    System.out.println("You are not allowed to access manager menu.");
                    System.out.println("Please try again.");
                    continue;
                }
                if (!(password.equals(Bank.password))){
                    System.out.println("You are not allowed to access manager menu.");
                    System.out.println("Please try again.");
                    continue;
                }
                boolean backToMainMenuFlag = false;
                while (!backToMainMenuFlag){
                    System.out.println("***Manager Menu***");
                    System.out.println("1) Add new account");
                    System.out.println("2) View accounts");
                    System.out.println("3) Withdraw");
                    System.out.println("4) Deposit");
                    System.out.println("5) Calculate interests");
                    System.out.println("6) View Transactions");
                    System.out.println("7) Exit");
                    inputLine = input.nextLine();
                    inputLine = deleteLastSpaces(inputLine);
                    if (inputLine.equals("1")){
                        System.out.println("Enter firstname of customer.");
                        String firstName = deleteLastSpaces(input.nextLine());
                        System.out.println("Enter lastname of customer.");
                        String lastName = deleteLastSpaces(input.nextLine());
                        int customerIndex = bank.calcCustomerIndex(firstName, lastName);
                        if (customerIndex == -1) {
                            bank.addNewCustomer(firstName, lastName);
                        }
                        System.out.println("PLease enter type of account.");
                        String typeOfAccount = input.nextLine();
                        if (typeOfAccount.equalsIgnoreCase(AccountType.CHECKING_ACCOUNT.getType())){
                            System.out.println("Please Enter Initial Balance.");
                            inputLine = deleteLastSpaces(input.nextLine());
                            boolean checker = isItValidInt(inputLine);
                            if (!checker){
                                System.out.println("Invalid amount of initial balance! Please try again.");
                                continue;
                            }
                            String initialBalanceStr = inputLine;
                            System.out.println("Please enter current year, month, day.");
                            boolean intChecker = true;
                            inputLine = input.nextLine();
                            String[] tokens = inputLine.split(" ");
                            for (int i = 0; i < tokens.length; i++){
                                tokens[i] = deleteLastSpaces(tokens[i]);
                                if (!isItValidInt(tokens[i]))
                                    intChecker = false;
                            }
                            if (!intChecker){
                                System.out.println("Invalid input.");
                                continue;
                            }
                            int[] dateElements = convertStrArrayToInt(tokens);
                            if (dateElements.length != 3){
                                System.out.println("Invalid num of elements");
                                continue;
                            }
                            MyDate date = new MyDate(dateElements[0], dateElements[1], dateElements[2]);
                            if (!date.isValidDate(dateElements[2], dateElements[1], dateElements[0])){
                                System.out.println("Invalid date elements");
                                continue;
                            }
                            long initialBalance = Long.parseLong(initialBalanceStr);
                            customerIndex = bank.calcCustomerIndex(firstName, lastName);
                            bank.addNewAccount(customerIndex, initialBalance, date, AccountType.CHECKING_ACCOUNT);
                        } else if (typeOfAccount.equalsIgnoreCase(AccountType.SAVING_ACCOUNT.getType())){
                            System.out.println("Please Enter Initial Balance.");
                            inputLine = deleteLastSpaces(input.nextLine());
                            boolean checker = isItValidInt(inputLine);
                            if (!checker){
                                System.out.println("Invalid amount of initial balance! Please try again.");
                                continue;
                            }
                            String initialBalanceStr = inputLine;
                            System.out.println("Please enter current year, month, day.");
                            boolean intChecker = true;
                            inputLine = input.nextLine();
                            String[] tokens = inputLine.split(" ");
                            for (int i = 0; i < tokens.length; i++){
                                if (!isItValidInt(tokens[i]))
                                    intChecker = false;
                            }
                            if (!intChecker){
                                System.out.println("Invalid input.");
                                continue;
                            }
                            int[] dateElements = convertStrArrayToInt(tokens);
                            if (dateElements.length != 3){
                                System.out.println("Invalid date elements");
                                continue;
                            }
                            MyDate date = new MyDate(dateElements[0], dateElements[1], dateElements[2]);
                            if (!date.isValidDate(dateElements[2], dateElements[1], dateElements[0])){
                                System.out.println("Invalid date elements");
                                continue;
                            }
                            long initialBalance = Long.parseLong(initialBalanceStr);
                            customerIndex = bank.calcCustomerIndex(firstName, lastName);
                            bank.addNewAccount(customerIndex, initialBalance, date, AccountType.SAVING_ACCOUNT);
                        } else if (typeOfAccount.equalsIgnoreCase(AccountType.LOAN_ACCOUNT.getType())){
                            System.out.println("Please Enter Initial Balance.");
                            inputLine = deleteLastSpaces(input.nextLine());
                            boolean checker = isItValidInt(inputLine);
                            if (!checker){
                                System.out.println("Invalid amount of initial balance! Please try again.");
                                continue;
                            }
                            String initialBalanceStr = inputLine;
                            System.out.println("Please enter current year, month, day.");
                            boolean intChecker = true;
                            inputLine = input.nextLine();
                            String[] tokens = inputLine.split(" ");
                            for (int i = 0; i < tokens.length; i++){
                                if (!isItValidInt(tokens[i]))
                                    intChecker = false;
                            }
                            if (!intChecker){
                                System.out.println("Invalid input.");
                                continue;
                            }
                            int[] dateElements = convertStrArrayToInt(tokens);
                            if (dateElements.length != 3){
                                System.out.println("Invalid date elements");
                                continue;
                            }
                            MyDate date = new MyDate(dateElements[0], dateElements[1], dateElements[2]);
                            if (!date.isValidDate(dateElements[2], dateElements[1], dateElements[0])){
                                System.out.println("Invalid date elements");
                                continue;
                            }
                            long initialBalance = Long.parseLong(initialBalanceStr);
                            System.out.println("Please enter num of months.");
                            inputLine = deleteLastSpaces(input.nextLine());
                            checker = isItValidInt(inputLine);
                            if (!checker){
                                System.out.println("Invalid amount of initial balance! Please try again.");
                                continue;
                            }
                            int numOfMonths = Integer.parseInt(inputLine);
                            System.out.println("Please enter loan Interest.");
                            inputLine = deleteLastSpaces(input.nextLine());
                            double loanInterest = Double.parseDouble(inputLine);
                            System.out.println("Please enter loan amount.");
                            inputLine = deleteLastSpaces(input.nextLine());
                            checker = isItValidInt(inputLine);
                            if (!checker){
                                System.out.println("Invalid amount of initial balance! Please try again.");
                                continue;
                            }
                            long loanAmount = Long.parseLong(inputLine);
                            customerIndex = bank.calcCustomerIndex(firstName, lastName);
                            bank.addNewAccount(customerIndex, initialBalance, date, loanAmount, loanInterest, numOfMonths);
                        } else {
                            System.out.println("Invalid Input please try again!");
                            continue;
                        }
                    } else if (inputLine.equals("2")){
                        System.out.println("Please enter customer firstname.");
                        String firstName = deleteLastSpaces(input.nextLine());
                        System.out.println("Please enter customer lastname.");
                        String lastName = deleteLastSpaces(input.nextLine());
                        bank.showAllCustomerAccount(firstName, lastName);
                    }else if (inputLine.equals("3")){
                        System.out.println("Please Enter AccountID.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        boolean checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of accountId! Please try again.");
                            continue;
                        }
                        long accountId = Long.parseLong(inputLine);
                        System.out.println("Please enter current year, month, day.");
                        boolean intChecker = true;
                        inputLine = input.nextLine();
                        String[] tokens = inputLine.split(" ");
                        for (int i = 0; i < tokens.length; i++){
                            if (!isItValidInt(tokens[i]))
                                intChecker = false;
                        }
                        if (!intChecker){
                            System.out.println("Invalid input.");
                            continue;
                        }
                        int[] dateElements = convertStrArrayToInt(tokens);
                        if (dateElements.length != 3){
                            System.out.println("Invalid date elements");
                            continue;
                        }
                        System.out.println("Please Enter Amount of transfer.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of amount of transfer! Please try again.");
                            continue;
                        }
                        long amountOfTransfer = Long.parseLong(inputLine);
                        bank.withdraw(accountId, amountOfTransfer, dateElements[2], dateElements[1], dateElements[0]);
                    }else if (inputLine.equals("4")){
                        System.out.println("Please Enter AccountID.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        boolean checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of accountId! Please try again.");
                            continue;
                        }
                        long accountId = Long.parseLong(inputLine);
                        System.out.println("Please enter current year, month, day.");
                        boolean intChecker = true;
                        inputLine = input.nextLine();
                        String[] tokens = inputLine.split(" ");
                        for (int i = 0; i < tokens.length; i++){
                            if (!isItValidInt(tokens[i]))
                                intChecker = false;
                        }
                        if (!intChecker){
                            System.out.println("Invalid input.");
                            continue;
                        }
                        int[] dateElements = convertStrArrayToInt(tokens);
                        if (dateElements.length != 3){
                            System.out.println("Invalid date elements");
                            continue;
                        }
                        System.out.println("Please Enter Amount of transfer.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of amount of transfer! Please try again.");
                            continue;
                        }
                        long amountOfTransfer = Long.parseLong(inputLine);
                        bank.deposit(accountId, amountOfTransfer, dateElements[2], dateElements[1], dateElements[0]);
                    }else if (inputLine.equals("5")){
                        System.out.println("Please Enter AccountID.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        boolean checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of accountId! Please try again.");
                            continue;
                        }
                        long accountId = Long.parseLong(inputLine);
                        System.out.println("Please enter current year, month, day.");
                        boolean intChecker = true;
                        inputLine = input.nextLine();
                        String[] tokens = inputLine.split(" ");
                        for (int i = 0; i < tokens.length; i++){
                            if (!isItValidInt(tokens[i]))
                                intChecker = false;
                        }
                        if (!intChecker){
                            System.out.println("Invalid input.");
                            continue;
                        }
                        int[] dateElements = convertStrArrayToInt(tokens);
                        if (dateElements.length != 3){
                            System.out.println("Invalid date elements");
                            continue;
                        }
                        bank.calculateInterests(accountId, dateElements[2], dateElements[1], dateElements[0]);
                    }else if (inputLine.equals("6")){
                        System.out.println("Please Enter AccountID.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        boolean checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of accountId! Please try again.");
                            continue;
                        }
                        long accountId = Long.parseLong(inputLine);
                        bank.viewTransactions(accountId);
                    } else if (inputLine.equals("7")){
                        backToMainMenuFlag = true;
                    }else {
                        System.out.println("Your choice must be between 1 to 7.");
                    }
                }

            } else if (inputLine.equals("2")) {
                System.out.println("Please enter your firstname");
                String firstName = deleteLastSpaces(input.nextLine());
                System.out.println("Please enter your lastname");
                String lastName = deleteLastSpaces(input.nextLine());
                int customerIndex = bank.calcCustomerIndex(firstName, lastName);
                if (customerIndex == -1){
                    System.out.println("You're not allowed to access customers Information.");
                    System.out.println("Pleas try again.");
                    continue;
                }
                boolean backToMainMenuFlag = false;
                while (!backToMainMenuFlag) {
                    System.out.println("***Costumer Menu***");
                    System.out.println("1) Inquire account balance");
                    System.out.println("2) Withdraw");
                    System.out.println("3) Deposit");
                    System.out.println("4) Exit");
                    inputLine = input.nextLine();
                    inputLine = deleteLastSpaces(inputLine);
                    int year = 1400;
                    int month = 6;
                    int day = 31;
                    if (inputLine.equals("1")) {
                        bank.showAllCustomerAccount(firstName, lastName);
                    } else if (inputLine.equals("2")) {
                        System.out.println("Please Enter AccountID.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        boolean checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of accountId! Please try again.");
                            continue;
                        }
                        long accountId = Long.parseLong(inputLine);
                        System.out.println("Please Enter Amount of transfer.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of amount of transfer! Please try again.");
                            continue;
                        }
                        long amountOfTransfer = Long.parseLong(inputLine);
                        bank.withdraw(accountId, amountOfTransfer, day, month, year);
                    } else if (inputLine.equals("3")) {
                        System.out.println("Please Enter AccountID.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        boolean checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of accountId! Please try again.");
                            continue;
                        }
                        long accountId = Long.parseLong(inputLine);
                        System.out.println("Please Enter Amount of transfer.");
                        inputLine = deleteLastSpaces(input.nextLine());
                        checker = isItValidInt(inputLine);
                        if (!checker){
                            System.out.println("Invalid amount of amount of transfer! Please try again.");
                            continue;
                        }
                        long amountOfTransfer = Long.parseLong(inputLine);
                        bank.deposit(accountId, amountOfTransfer, day, month, year);
                    } else {
                        backToMainMenuFlag = true;
                    }
                }
            } else if (inputLine.equals("3")) {
                break;
            } else {
                System.out.println("Invalid input! Your choice must be one number between 1 to 3.");
                continue;
            }
        }
    }

    public static String deleteLastSpaces(String inputLine) {
        if (inputLine.length() == 0) {
            System.out.println("Input buffer is empty.");
            return inputLine;
        }

        if (inputLine.charAt(inputLine.length() - 1) != ' ')
            return inputLine;

        if (inputLine.equals(" ")){
            System.out.println("Input buffer is just a space char.");
            return inputLine;
        }

        inputLine = inputLine.substring(0, inputLine.length() - 2);
        return deleteLastSpaces(inputLine);
    }

    public static boolean isItValidInt(String phoneNumberStr){
        for (int i = 0; i < phoneNumberStr.length(); i++){
            if ((phoneNumberStr.charAt(i) < 48) || (phoneNumberStr.charAt(i) > 57))
                return false;
        }
        return true;
    }

    public static int[] convertStrArrayToInt(String[] inputArray){
        int[] result = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++){
            result[i] = Integer.parseInt(inputArray[i]);
        }
        return result;
    }
}