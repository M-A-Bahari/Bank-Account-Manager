/**
 * Handles secure file-based storage and retrieval of user accounts.
 * Includes methods to hash passwords, verify login, and persist/update user data.
 * 
 * @author Naz Karaman
 * @author Yashasvi
 */
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class FileStorage {
    private static final String FILE_NAME = "accounts.txt";
    private static final String HEADER = "username,hashedPassword,chequingBalance,savingsBalance,firstName,lastName,dob,userId";
	//@author Naz Karaman
	//Hashes a plain-text password using SHA-256.(Learned it from youtube)
    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing error", e);
        }
    }
	
	//@author Naz Karaman
	//Ensures that the file exists and includes a header row.
    private static void ensureHeaderExists() {
        File file = new File(FILE_NAME);
        if (!file.exists() || file.length() == 0) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(HEADER);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
	//@author Naz Karaman
	//Saves a new account to file. Called during registration.
    public static void saveAccount(User user, String password, BankAccount account) {
        ensureHeaderExists();
        String hashedPassword = hashPassword(password);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.getUsername() + "," + hashedPassword + "," +
                         account.getChequingBalance() + "," +
                         account.getSavingsBalance() + "," +
                         user.getFirstName() + "," +
                         user.getLastName() + "," +
                         user.getDob() + "," +
                         user.getUserId());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	//@author Yashasvi
	//Verifies login credentials by checking stored hashed passwords.
    public static boolean verifyLogin(String username, String password) {
        String hashed = hashPassword(password);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8 && parts[0].equals(username) && parts[1].equals(hashed)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

	//author Yashasvi
	//Loads a user's bank account data from file.
    public static BankAccount loadAccount(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8 && parts[0].equals(username)) {
                    double chequing = Double.parseDouble(parts[2]);
                    double savings = Double.parseDouble(parts[3]);
                    return new BankAccount(username, chequing, savings);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
  	//@author Yashasvi
  	//Loads a user's profile (personal info) from file.
    public static User loadUser(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 8 && parts[0].equals(username)) {
                    return new User(parts[0], parts[4], parts[5], parts[6], parts[7]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

	//@author Yashasvi
	//Updates all user account data in the file.Overwrites the entire file with current memory state.
    public static void updateAllAccounts(HashMap<String, BankAccount> accounts, HashMap<String, String> credentials, HashMap<String, User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(HEADER);
            writer.newLine();
            for (String username : accounts.keySet()) {
                BankAccount acc = accounts.get(username);
                User user = users.get(username);
                String passwordHash = hashPassword(credentials.get(username));
                writer.write(username + "," + passwordHash + "," +
                             acc.getChequingBalance() + "," + acc.getSavingsBalance() + "," +
                             user.getFirstName() + "," +
                             user.getLastName() + "," +
                             user.getDob() + "," + user.getUserId());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
