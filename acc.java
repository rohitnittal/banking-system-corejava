import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private ArrayList<Account> accounts;

    public BankingSystem() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        Account account = new Account(accountNumber, accountHolder, initialBalance);
        accounts.add(account);
    }

    public void deposit(String accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.deposit(amount);
                break;
            }
        }
    }

    public void withdraw(String accountNumber, double amount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.withdraw(amount);
                break;
            }
        }
    }

    public double getBalance(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account.getBalance();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BankingSystem bs = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.println("Enter account holder: ");
                    String accountHolder = scanner.next();
                    System.out.println("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();

                    bs.createAccount(accountNumber, accountHolder, initialBalance);
                    break;
                case 2:
                    System.out.println("Enter account number: ");
                    String accountNumberToDeposit = scanner.next();
                    System.out.println("Enter amount to deposit: ");
                    double amountToDeposit = scanner.nextDouble();

                    bs.deposit(accountNumberToDeposit, amountToDeposit);
                    break;
                case 3:
                    System.out.println("Enter account number: ");
                    String accountNumberToWithdraw = scanner.next();
                    System.out.println("Enter amount to withdraw: ");
                    double amountToWithdraw = scanner.nextDouble();

                    bs.withdraw(accountNumberToWithdraw, amountToWithdraw);
                    break;
                case 4:
                    System.out.println("Enter account number: ");
                    String accountNumberToCheck = scanner.next();

                    double balance = bs.getBalance(accountNumberToCheck);
                    System.out.println("Balance: " + balance);
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
