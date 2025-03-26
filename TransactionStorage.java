/**
 * Handles logging and retrieving transaction history for user accounts.
 * Stores all transactions in a flat file ("transactions.txt").
 *
 * @author Naz Karaman
 * @author Yashasvi
 */
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionStorage {
    private static final String FILE_NAME = "transactions.txt";

	//Logs a transaction entry to the transactions file.
    public static void logTransaction(String username, String action, double amount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(username + "," + action + "," + amount + "," + timestamp);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	//Retrieves all transaction entries for the given user.
    public static String getTransactionHistory(String username) {
        StringBuilder history = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
            // Only append lines that belong to the user
                if (line.startsWith(username + ",")) {
                    history.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return history.toString();
    }
}
