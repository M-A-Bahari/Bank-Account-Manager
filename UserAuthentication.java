/**
 * UserAuthentication.java
 *
 * This class manages user authentication and account lifecycle operations
 * for the Bank Account Manager application. It is responsible for:
 *  - Registering new users
 *  - Authenticating user logins
 *  - Loading and persisting user/account data
 *  - Terminating user accounts
 *
 * Authors:
 *  - Md Ataullah Bahari
 *      * Account initialization logic
 *      * User registration and login flow
 *      * In-memory data management
 *
 *  - Hassan Afzaal
 *      * Account termination functionality
 *      * File rewrite logic for account deletion
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


public class UserAuthentication {
	//In-memory storage for users, passwords, accounts
    private static final HashMap<String, String> credentials = new HashMap<>();
    private static final HashMap<String, BankAccount> accounts = new HashMap<>();
    private static final HashMap<String, User> users = new HashMap<>();
    private static final String FILE_NAME = "accounts.txt";  // Path to the accounts file


    // Loads existing accounts from accounts.txt (skips header)
    //@author MD Ataullah Bahari
    public static void initialize() {
        File file = new File("accounts.txt");
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine(); // skip header line
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8) {
                    String username = parts[0];
                    String hashedPassword = parts[1];
                    double chequing = Double.parseDouble(parts[2]);
                    double savings = Double.parseDouble(parts[3]);
                    String firstName = parts[4];
                    String lastName = parts[5];
                    String dob = parts[6];
                    String userId = parts[7];
                    credentials.put(username, hashedPassword);
                    accounts.put(username, new BankAccount(username, chequing, savings));
                    users.put(username, new User(username, firstName, lastName, dob, userId));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	// Creates a new user and saves to file (returns false if username already taken)
    public static boolean register(String username, String password, String firstName, String lastName, String dob, double initialBalance) {
        if (credentials.containsKey(username)) {
            return false;
        }
        String userId = UUID.randomUUID().toString().substring(0, 8);
        User user = new User(username, firstName, lastName, dob, userId);
        BankAccount account = new BankAccount(username, initialBalance, 0.0);

        // Store plain text password in memory for updating (file storage uses hash)
        credentials.put(username, password);
        accounts.put(username, account);
        users.put(username, user);

        FileStorage.saveAccount(user, password, account);
        return true;
    }
    
	// Verifies credentials and loads account into memory
    public static boolean login(String username, String password) {
        if (!FileStorage.verifyLogin(username, password)) {
            return false;
        }
        BankAccount account = FileStorage.loadAccount(username);
        User user = FileStorage.loadUser(username);
        if (account != null && user != null) {
            credentials.put(username, password);
            accounts.put(username, account);
            users.put(username, user);
            return true;
        }
        return false;
    }
    
    //@author Hassan Afzaal
    // Deletes a user's account from storage
    public static boolean terminateAccount(String username) {
        // Read the existing accounts into a list
        List<String> accountsList = new ArrayList<>();
        boolean accountFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
            	if (parts[0].equals(username)) {
                accountFound = true;
                continue; 
           	 }
                accountsList.add(line);  
            }

            // If account was found, overwrite the file without this account
            if (accountFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                    for (String account : accountsList) {
                        writer.write(account);
                        writer.newLine();
                    }
                    return true; 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    
	// Returns account object for given username
    public static BankAccount getAccount(String username) {
        return accounts.get(username);
    }
    // Returns user object for given username
    public static User getUser(String username) {
        return users.get(username);
    }
  	// Checks if username exists in memory
    public static boolean userExists(String username) {
        return credentials.containsKey(username);
    }
	// Pushes all current account data to disk
    public static void updateAllAccounts() {
        FileStorage.updateAllAccounts(accounts, credentials, users);
    }
}
