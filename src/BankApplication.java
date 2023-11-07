import java.util.Scanner;

public class BankApplication {


    public static void main(String[] args) {
    	
        Scanner scan =new Scanner(System.in);
        System.out.println("Enter your 'Name' and 'CustomerId' to access your Bank account:");
        String name=scan.nextLine();
        String customerId=scan.nextLine();
        
        BankAccount obj1=new BankAccount(name,customerId);
        
        obj1.menu();
        
        scan.close();
        
    }
}

