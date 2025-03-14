/**
 * This class handles user authentication, including login and registration.
 * @author Md Ataullah Bahari
 * @co-author Hassan Afzaal
 */
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class UserAuthentication {
    private static final String FILE_NAME = "accounts.txt";
    //Username Password as a String
    private static HashMap<String, String> users = new HashMap<>();
    // Username Balance as a Double
    private static HashMap<String, Double> balances = new HashMap<>(); 
    // Username UserID as a String
    private static HashMap<String, String> userIDs = new HashMap<>(); 

    //@author Md Ataullah Bahari
    public static void main(String[] args) {
        //We are loading existing users from the file
        loadAccounts();

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Register\n2. Login");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            registerUser(scanner);
        } else {
            loginUser(scanner);
        }
        scanner.close();
    }
    
    //@author Hassan Afzaal
    private static void registerUser(Scanner scanner) {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        
        // Generating the Unique User ID
        String userId = UUID.randomUUID().toString().substring(0, 8); // 8-char unique ID

        // Ensuring that we have Unique Username
        String username;
        while (true) {
            System.out.print("Enter a unique Username: ");
            username = scanner.nextLine();
            if (users.containsKey(username)) {
                System.out.println("Username already exists! Try a different one.");
            } else {
                break;
            }
        }

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Date of Birth Validation as the Suer must be 16 or older
        System.out.print("Enter Date of Birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString);
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();

        if (age < 16) {
            System.out.println("You must be at least 16 years old to create an account.");
            return;
        }

        System.out.print("Enter Starting Balance: ");
        double balance = scanner.nextDouble();


        users.put(username, password);
        balances.put(username, balance);
        userIDs.put(username, userId);

        // Save to File
        saveAccount(userId, firstName, lastName, username, password, balance);
        System.out.println("Registration successful! Your User ID: " + userId);
    }

    //@author Md Ataullah Bahari
    private static void loginUser(Scanner scanner) {
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful! Balance: $" + balances.get(username));
        } else {
            System.out.println("Login failed. Incorrect credentials.");
        }
    }

    //@author Hassan Afzaal
    private static void saveAccount(String userId, String firstName, String lastName, String username, String password, double balance) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(userId + "," + firstName + "," + lastName + "," + username + "," + password + "," + balance);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //@author Md Ataullah Bahari
    private static void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    String userId = parts[0];
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String username = parts[3];
                    String password = parts[4];
                    double balance = Double.parseDouble(parts[5]);

                    users.put(username, password);
                    balances.put(username, balance);
                    userIDs.put(username, userId);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
