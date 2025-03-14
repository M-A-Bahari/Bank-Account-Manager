import java.util.HashMap;
import java.util.Scanner;

public class UserAuthentication{
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, Double> balances = new HashMap<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Register\n2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1){
            registerUser(scanner);
        }
        else{
            loginUser(scanner);
        }

        scanner.close();
    }

    private static void registerUser(Scanner scanner){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your starting balance: ");
        double balance = scanner.nextDouble();

        users.put(username, password);
        balances.put(username, balance);
        System.out.println("Registration successful! You can now log in.");
    }

    private static void loginUser(Scanner scanner){
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if(users.containsKey(username) && users.get(username).equals(password)){
            System.out.println("Login successful! Balance: $" + balances.get(username));
        }
        else {
            System.out.println("Login failed. Incorrect credentials.");
        }
    }
}