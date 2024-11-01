import java.util.Scanner;

public class BankAccount {
    private double savingBalance;
    private double checkingBalance;
    private double prevTrans;
    private String customerName;
    private String customerId;

    private Scanner scan = new Scanner(System.in);

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.savingBalance = 0.0;
        this.checkingBalance = 0.0;
    }

    // Unified deposit method
    public void deposit(double amount, String accountType) {
        if (amount > 0) {
            if (accountType.equalsIgnoreCase("Savings")) {
                savingBalance += amount;
            } else if (accountType.equalsIgnoreCase("Checking")) {
                checkingBalance += amount;
            }
            prevTrans = amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    // Unified withdraw method
    public void withdraw(double amount, String accountType) {
        if (amount > 0) {
            if (accountType.equalsIgnoreCase("Savings")) {
                if (savingBalance >= amount) {
                    savingBalance -= amount;
                    prevTrans = -amount;
                    System.out.println("Withdrawn: $" + amount);
                } else {
                    System.out.println("Insufficient funds in Savings account.");
                }
            } else if (accountType.equalsIgnoreCase("Checking")) {
                if (checkingBalance >= amount) {
                    checkingBalance -= amount;
                    prevTrans = -amount;
                    System.out.println("Withdrawn: $" + amount);
                } else {
                    System.out.println("Insufficient funds in Checking account.");
                }
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public void getPreviousTransaction() {
        if (prevTrans > 0) {
            System.out.println("Last Transaction: Deposited $" + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Last Transaction: Withdrew $" + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    public void showBalance(String accountType) {
        if (accountType.equalsIgnoreCase("Savings")) {
            System.out.println("Savings Account Balance: $" + savingBalance);
        } else if (accountType.equalsIgnoreCase("Checking")) {
            System.out.println("Checking Account Balance: $" + checkingBalance);
        }
    }

    // Main menu method
    public void menu() {
        char option;
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID: " + customerId);
        System.out.println();

        do {
            System.out.println("==========================================");
            System.out.println("A. Savings Account");
            System.out.println("B. Checking Account");
            System.out.println("C. Exit");
            System.out.println("==========================================");
            System.out.print("Select an option: ");
            option = scan.next().charAt(0);
            System.out.println();

            switch (Character.toUpperCase(option)) {
                case 'A':
                    accountMenu("Savings");
                    break;
                case 'B':
                    accountMenu("Checking");
                    break;
                case 'C':
                    System.out.println("Thank you for using our banking services.");
                    break;
                default:
                    System.out.println("Invalid option. Please enter A, B, or C.");
            }
        } while (Character.toUpperCase(option) != 'C');
    }

    // Account-specific menu
    private void accountMenu(String accountType) {
        char option;
        do {
            System.out.println("==========================================");
            System.out.println(accountType + " Account:");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Back to Main Menu");
            System.out.println("==========================================");
            System.out.print("Select an option: ");
            option = scan.next().charAt(0);
            System.out.println();

            switch (Character.toUpperCase(option)) {
                case 'A':
                    showBalance(accountType);
                    break;
                case 'B':
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scan.nextDouble();
                    deposit(depositAmount, accountType);
                    break;
                case 'C':
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scan.nextDouble();
                    withdraw(withdrawAmount, accountType);
                    break;
                case 'D':
                    getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please enter A, B, C, D, or E.");
            }
            System.out.println();
        } while (Character.toUpperCase(option) != 'E');
    }
}
