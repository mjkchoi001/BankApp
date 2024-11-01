import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = scan.nextLine();
        System.out.print("Enter your Customer ID: ");
        String customerId = scan.nextLine();

        BankAccount account = new BankAccount(name, customerId);
        account.menu();

        scan.close();
    }
}
