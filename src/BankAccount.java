import java.util.Scanner;

public class BankAccount {
    private double savingBalance;
    private double checkingBalance;
    private double prevTrans;
    private String customerName;
    private String customerId;

    public BankAccount(String customerName, String customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public void depositSaving(double amount) {
        if (amount > 0) {
            savingBalance += amount;
            prevTrans = amount;
            System.out.println("Balance: "+ savingBalance);
        }
    }

    public void depositChecking(double amount) {
        if (amount > 0) {
            checkingBalance += amount;
            prevTrans = amount;
            System.out.println("Balance: "+ checkingBalance);
        }
    }

    public void withdrawSaving(double amount) {
        if (amount > 0 && savingBalance >= amount) {
            savingBalance -= amount;
            prevTrans = -amount;
            System.out.println("Balance: "+ savingBalance);
        } else if (savingBalance < amount) {
            System.out.println("Saving account balance insufficient");
        }
    }

    public void withdrawChecking(double amount) {
        if (amount > 0 && checkingBalance >= amount) {
            checkingBalance -= amount;
            prevTrans = -amount;
            System.out.println("Balance: "+ checkingBalance);
        } else if (checkingBalance < amount) {
            System.out.println("Checking account balance insufficient");
        }
    }

    public void getPreviousTrans() {
        if (prevTrans > 0) {
            System.out.println("Deposited: " + prevTrans);
        } else if (prevTrans < 0) {
            System.out.println("Withdrawn: " + Math.abs(prevTrans));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void menu() {
        char option;
        char account;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID: " + customerId);
        System.out.println("\n");
        System.out.println("a) Savings");
        System.out.println("b) Checking");

        do {
            System.out.println("********************************************");
            System.out.println("Choose an Account");
            account = scan.next().charAt(0);
            System.out.println("\n");

            switch (account) {

                case 'a':

                    System.out.println("a) Check Balance");
                    System.out.println("b) Deposit Amount");
                    System.out.println("c) Withdraw Amount");
                    System.out.println("d) Previous Transaction");
                    System.out.println("e) Exit");

                    do {
                        System.out.println("********************************************");
                        System.out.println("Choose an option");
                        option = scan.next().charAt(0);
                        System.out.println("\n");

                        switch (option) {
                            case 'a':
                                System.out.println("......................");
                                System.out.println("Balance = " + savingBalance);
                                System.out.println("......................");
                                System.out.println("\n");
                                break;
                            case 'b':
                                System.out.println("......................");
                                System.out.println("Enter an amount to deposit:");
                                System.out.println("......................");
                                double amount = scan.nextDouble();
                                depositSaving(amount);
                                System.out.println("\n");
                                break;
                            case 'c':
                                System.out.println("......................");
                                System.out.println("Enter an amount to withdraw:");
                                System.out.println("......................");
                                double amtW = scan.nextDouble();
                                withdrawSaving(amtW);
                                System.out.println("\n");
                                break;
                            case 'd':
                                System.out.println("......................");
                                System.out.println("Previous Transaction:");
                                getPreviousTrans();
                                System.out.println("......................");
                                System.out.println("\n");
                                break;

                            case 'e':
                                System.out.println("......................");
                                break;
                            default:
                                System.out.println("Choose a correct option to proceed");
                                break;
                        }

                    } while (option != 'e');

                    System.out.println("Thank you for using our banking services");
                    break;

                case 'b':

                    System.out.println("a) Check Balance");
                    System.out.println("b) Deposit Amount");
                    System.out.println("c) Withdraw Amount");
                    System.out.println("d) Previous Transaction");
                    System.out.println("e) Exit");

                    do {
                        System.out.println("********************************************");
                        System.out.println("Choose an option");
                        option = scan.next().charAt(0);
                        System.out.println("\n");

                        switch (option) {
                            case 'a':
                                System.out.println("......................");
                                System.out.println("Balance = " + checkingBalance);
                                System.out.println("......................");
                                System.out.println("\n");
                                break;
                            case 'b':
                                System.out.println("......................");
                                System.out.println("Enter an amount to deposit:");
                                System.out.println("......................");
                                double amount = scan.nextDouble();
                                depositChecking(amount);
                                System.out.println("\n");
                                break;
                            case 'c':
                                System.out.println("......................");
                                System.out.println("Enter an amount to withdraw:");
                                System.out.println("......................");
                                double amtW = scan.nextDouble();
                                withdrawChecking(amtW);
                                System.out.println("\n");
                                break;
                            case 'd':
                                System.out.println("......................");
                                System.out.println("Previous Transaction:");
                                getPreviousTrans();
                                System.out.println("......................");
                                System.out.println("\n");
                                break;

                            case 'e':
                                System.out.println("......................");
                                break;
                            default:
                                System.out.println("Choose a correct option to proceed");
                                break;
                        }

                    } while (option != 'e');

                    System.out.println("Thank you for using our banking services");
                    break;

                default:
                    System.out.println("Choose a correct option to proceed");
                    break;
            }

        } while (account != 'a' && account != 'b');
    }
}
