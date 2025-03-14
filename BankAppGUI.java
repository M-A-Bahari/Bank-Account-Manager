//@author Hassan Afzaal
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.UUID;

public class BankGUI extends Application {
    private static final String FILE_NAME = "accounts.txt";
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, Double[]> balances = new HashMap<>();
    private static HashMap<String, String> userIDs = new HashMap<>();
    

    private Stage window;
    private Scene loginScene, registerScene, mainBankingScene, transferScene, historyScene;
    private String loggedInUser;
    private Label balanceLabel;
    private Label fullNameLabel;
    private Label usernameLabel;

    
    private TextField usernameInput;
    private PasswordField passwordInput;

    public static void main(String[] args) {
        loadAccounts();
        launch(args);
    }
    
	private static void saveAccount(String userId, String firstName, String lastName, String username, String password, double balance) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
        	writer.write(userId + "," + firstName + "," + lastName + "," + username + "," + password + "," + balance);
        	writer.newLine();
    	} catch (IOException e) {
        	e.printStackTrace();
    	}
	}
}