/**
 * JavaFX GUI for a personal banking application.
 * Allows users to register, log in, manage chequing/savings accounts,
 * perform transactions, and view transaction history.
 *
 * Scenes include:
 * - Login and Registration
 * - Main Banking Panel
 * - Savings Management
 * - Fund Transfer
 * - Transaction History
 *
 * Built with modular scene setup for easy navigation and styling.
 * 
 * @AUTHOR HASSAN AFZAAL (MAINLY DONE BY HASSAN)
 *
 * @Support Provided by (Md Ataullah Bahari)
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Period;
import javafx.geometry.Pos;

public class BankGUI extends Application {
    private Stage window;
    private Scene loginScene, registerScene, mainScene, savingsScene, transferScene, historyScene;
    private String currentUser;
    private BankAccount currentAccount;
    private User currentUserInfo;
    private Label balanceLabel;
    private Label savingsLabel;
    private Label savingsBalanceLabel;
    private TextArea historyArea;
    private Label welcomeLabel;

    public static void main(String[] args) {
        // Load existing accounts from file before launching the GUI
        UserAuthentication.initialize();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Bank Account Manager");
		String css = getClass().getResource("style.css").toExternalForm();  
        setupLoginScene();
        setupRegisterScene();
        setupMainScene();
        setupSavingsScene();
        setupTransferScene();
        setupHistoryScene();
		loginScene.getStylesheets().add(css);
		mainScene.getStylesheets().add(css);
        window.setScene(loginScene);
        window.setWidth(850);
   		window.setHeight(650);
        window.show();
    }

    // ===== Login Scene =====
    private void setupLoginScene() {
         VBox layout = new VBox(10);
    layout.setPadding(new Insets(20));
    layout.getStyleClass().add("login-background");

    // Username and Password Labels
    Label usernameLabel = new Label("Username");
    usernameLabel.getStyleClass().add("login-label"); 

    Label passwordLabel = new Label("Password");
    passwordLabel.getStyleClass().add("login-label");  
    
    // Username and Password Fields
    TextField userField = new TextField();
    userField.setPromptText("Username");
    PasswordField passField = new PasswordField();
    passField.setPromptText("Password");

    // Message Label
    Label msg = new Label();

    // Login Button
    Button loginBtn = new Button("Login");
    loginBtn.setOnAction(e -> {
        String u = userField.getText();
        String p = passField.getText();
        if (UserAuthentication.login(u, p)) {
            currentUser = u;
            currentAccount = UserAuthentication.getAccount(u);
            currentUserInfo = UserAuthentication.getUser(u);
            welcomeLabel.setText("Welcome " + currentUserInfo.getFullName());
            welcomeLabel.getStyleClass().add("welcome-label");
            updateBalanceLabels();
            window.setScene(mainScene);
            // Clear the input fields after successful login
            userField.clear();
            passField.clear();
        } else {
           showAlert("Login Failed", "Invalid credentials. Please try again.", Alert.AlertType.ERROR);
           userField.clear();
       	 passField.clear();
        }
    });

        Button regBtn = new Button("Register");
        regBtn.setOnAction(e -> window.setScene(registerScene));

        layout.getChildren().addAll(usernameLabel,userField,passwordLabel, passField, loginBtn, regBtn, msg);
        loginScene = new Scene(layout, 400, 300);
    }

    // ===== Registration Scene =====
    private void setupRegisterScene() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        TextField firstName = new TextField();
        firstName.setPromptText("First Name");
        TextField lastName = new TextField();
        lastName.setPromptText("Last Name");
        TextField dob = new TextField();
        dob.setPromptText("Date of Birth (YYYY-MM-DD)");
        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        PasswordField confirmPassword = new PasswordField();
        confirmPassword.setPromptText("Confirm Password");
        TextField balance = new TextField();
        balance.setPromptText("Initial Balance");
        Label msg = new Label();

        Button register = new Button("Register");
        register.setOnAction(e -> {
            try {
            // Validate date of birth format (YYYY-MM-DD)
            String dobText = dob.getText();
            if (!dobText.matches("\\d{4}-\\d{2}-\\d{2}")) {
                showAlert("Input Error", "Invalid date format. Use YYYY-MM-DD.", Alert.AlertType.ERROR);
                return;
            }
            
            LocalDate birthDate = LocalDate.parse(dobText);
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            if (age < 16) {
                showAlert("Age Restriction", "You must be at least 16 years old.", Alert.AlertType.WARNING);
                return;
            }
            if (!password.getText().equals(confirmPassword.getText())) {
                showAlert("Input Error", "Passwords do not match.", Alert.AlertType.ERROR);
                return;
            }
            
                double initial = Double.parseDouble(balance.getText());
			if (initial < 0) {
    		showAlert("Invalid Balance", "Initial balance cannot be negative.", Alert.AlertType.ERROR);
    		return;
			}

			boolean success = UserAuthentication.register(
    		username.getText(), password.getText(),
    			firstName.getText(), lastName.getText(), dob.getText(), initial
				);
               if (success) {
    			Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Registration Successful");
				alert.setHeaderText(null);
				alert.setContentText("Account created successfully!");
				alert.showAndWait();


   				 firstName.clear();
    		lastName.clear();
  		  dob.clear();
  			  username.clear();
   			 password.clear();
		    confirmPassword.clear();
				balance.clear();
			} else {
  			  showAlert("Registration Failed", "Username already exists.", Alert.AlertType.WARNING);
				}
            } catch (Exception ex) {
                showAlert("Registration Error", "Invalid input. Please check all fields.", Alert.AlertType.ERROR);
            }
        });

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(loginScene));

        layout.getChildren().addAll(
            new Label("Personal Information:"), firstName, lastName, dob,
            new Label("Login Information:"), username, password, confirmPassword,
            new Label("Initial Balance:"), balance,
            register, back, msg
        );
        registerScene = new Scene(layout, 500, 600);
    }

    // ===== Main Banking Scene =====
    private void setupMainScene() {
    	welcomeLabel = new Label();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getStyleClass().add("login-background");

        balanceLabel = new Label();
        savingsLabel = new Label();
        TextField amount = new TextField();
        amount.setPromptText("Amount");

		 HBox firstRow = new HBox(20);  
   		 firstRow.setAlignment(Pos.CENTER);
        Button deposit = new Button("Deposit");
		deposit.setOnAction(e -> {
    try {
        double val = Double.parseDouble(amount.getText());
        if (val <= 0) {
            showErrorDialog("Cannot deposit zero or negative amounts.");
        } else {
            currentAccount.deposit(val);
            TransactionStorage.logTransaction(currentUser, "Deposit", val);
            updateBalanceLabels();
            UserAuthentication.updateAllAccounts();
        }
        amount.clear();
    } catch (IllegalArgumentException ex) {
        showErrorDialog("Invalid deposit. Please enter a valid amount.");
    } catch (Exception ex) {
        showErrorDialog("Invalid deposit.");
    }
		});
		
       Button withdraw = new Button("Withdraw");
		withdraw.setOnAction(e -> {
    try {
        double val = Double.parseDouble(amount.getText());
        if (val <= 0) {
            showErrorDialog("Cannot withdraw zero or negative amounts.");
        } else if (currentAccount.withdraw(val)) {
            TransactionStorage.logTransaction(currentUser, "Withdraw", val);
            updateBalanceLabels();
            UserAuthentication.updateAllAccounts();
        } else {
            showErrorDialog("Insufficient funds.");
        }
        amount.clear();
    } catch (Exception ex) {
        showErrorDialog("Invalid withdraw. Please enter a valid amount.");
    }
		});


       	Button toSavings = new Button("Transfer to Savings");
		toSavings.setOnAction(e -> {
    try {
        double val = Double.parseDouble(amount.getText());
        
        if (val <= 0) {
            showErrorDialog("Cannot transfer zero or negative amounts.");
        } else if (currentAccount.getChequingBalance() < val) {
            showErrorDialog("Not enough funds in Chequing.");
        } else if (val > currentAccount.getChequingBalance()) {
            showErrorDialog("Not enough funds.");
        } else if (currentAccount.getSavingsBalance() < 0) {
            showErrorDialog("Cannot transfer to Savings with a negative balance.");
        } else if (currentAccount.transferToSavings(val)) {
            TransactionStorage.logTransaction(currentUser, "Transfer to Savings", val);
            updateBalanceLabels();
            UserAuthentication.updateAllAccounts();
        }
        amount.clear();
    } catch (Exception ex) {
        showErrorDialog("Transfer failed. Please enter a valid amount.");
    }
		});
		
		firstRow.getChildren().addAll(deposit, withdraw, toSavings);
        HBox secondRow = new HBox(20); 
    	secondRow.setAlignment(Pos.CENTER);
        Button transferBtn = new Button("Send to User");
        transferBtn.setOnAction(e -> window.setScene(transferScene));
        secondRow.getChildren().add(transferBtn);
		HBox thirdRow = new HBox(20);  
    	thirdRow.setAlignment(Pos.CENTER);
        Button savingsSceneBtn = new Button("Savings Account");
        savingsSceneBtn.setOnAction(e -> {
        	updateSavingsLabel();
        	window.setScene(savingsScene);
	});
	thirdRow.getChildren().add(savingsSceneBtn);

		HBox fourthRow = new HBox(20);  
    	fourthRow.setAlignment(Pos.CENTER);
        Button historyBtn = new Button("Transaction History");
        historyBtn.setOnAction(e -> {
            historyArea.setText(TransactionStorage.getTransactionHistory(currentUser));
            window.setScene(historyScene);
        });
		fourthRow.getChildren().add(historyBtn);
		
		HBox fifthRow = new HBox(20); 
    	fifthRow.setAlignment(Pos.CENTER);
    	Button terminateAccountBtn = new Button("Terminate Account");
    	terminateAccountBtn.setStyle("-fx-background-color: red; -fx-text-fill: white;");
    	terminateAccountBtn.setOnAction(e -> terminateAccountAction());  // Call the terminate account method
		fifthRow.getChildren().add(terminateAccountBtn);
    
    
    	HBox sixthRow = new HBox(20); 
   		sixthRow.setAlignment(Pos.CENTER);
        Button logout = new Button("Logout");
        logout.setOnAction(e -> window.setScene(loginScene));
		sixthRow.getChildren().add(logout);
		
        layout.getChildren().addAll(
        welcomeLabel, balanceLabel, savingsLabel, amount,
        firstRow, secondRow, thirdRow, fourthRow, fifthRow, sixthRow
    );
        mainScene = new Scene(layout, 350, 500);
    }
    
	private void terminateAccountAction() {
    	boolean isTerminated = UserAuthentication.terminateAccount(currentUser);
    	if (isTerminated) {
        // Inform the user that the account was terminated and navigate to the login screen
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Account Termination");
        alert.setHeaderText("Your account has been successfully terminated.");
        alert.setContentText("You will now be logged out.");
        alert.showAndWait();

        // Log the user out and redirect to the login scene
        window.setScene(loginScene);
    } else {
        // Handle the case where the account was not found
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Account Termination Failed");
        alert.setContentText("There was an issue terminating your account. Please try again later.");
        alert.showAndWait();
    }
		}
    // ===== Savings Scene =====
	private void setupSavingsScene() {
    	VBox layout = new VBox(20);  
    	layout.setPadding(new Insets(20));
    	layout.setStyle("-fx-background-color: #ccffcc; -fx-alignment: center;");

    	// Savings balance label
   		savingsBalanceLabel = new Label();
    	savingsBalanceLabel.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-alignment: center;");
    	updateSavingsLabel();

    	// HBox for transfer buttons
    	HBox transferBackLayout = new HBox(20); 
   	 	transferBackLayout.setAlignment(Pos.CENTER);  

    	TextField transferBackAmount = new TextField();
    	transferBackAmount.setPromptText("Amount");

    	Button transferBackButton = new Button("Transfer to Chequing");
    	transferBackButton.getStyleClass().add("button");  

    	Button backToMain = new Button("Back to Main");
    	backToMain.getStyleClass().add("button back-to-main");  

    	transferBackLayout.getChildren().addAll(transferBackAmount, transferBackButton);
    	layout.getChildren().addAll(savingsBalanceLabel, transferBackLayout, backToMain);

    // Action for transfer button
    transferBackButton.setOnAction(e -> {
        try {
            double val = Double.parseDouble(transferBackAmount.getText());

            if (val <= 0) {
                showErrorDialog("Cannot transfer zero or negative amounts.");
            } else if (val > currentAccount.getSavingsBalance()) {
                showErrorDialog("Not enough funds in Savings.");
            } else if (currentAccount.transferToChequing(val)) {
                TransactionStorage.logTransaction(currentUser, "Transfer from Savings to Chequing", val);
                updateSavingsLabel();
                updateBalanceLabels();
                UserAuthentication.updateAllAccounts();
            }
            transferBackAmount.clear();
        } catch (NumberFormatException ex) {
            showErrorDialog("Invalid amount.");
        }
    });

    // Action for back to main button
    	backToMain.setOnAction(e -> {
        updateBalanceLabels();
        window.setScene(mainScene);
    });
    	savingsScene = new Scene(layout, 400, 500);  
	}

    // ===== Transfer Scene =====
    private void setupTransferScene() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        TextField recipientField = new TextField();
        recipientField.setPromptText("Recipient Username");
        TextField amountField = new TextField();
        amountField.setPromptText("Amount");
        Label msg = new Label();

        Button sendBtn = new Button("Send");
        sendBtn.setOnAction(e -> {
            String recipient = recipientField.getText();
            try {
                double val = Double.parseDouble(amountField.getText());
                BankAccount recipientAccount = UserAuthentication.getAccount(recipient);
                if (recipientAccount == null) {
                    msg.setText("Recipient not found.");
                    return;
                }
                // Use the new sendTo method for transferring funds
                if (currentAccount.sendTo(recipientAccount, val)) {
                    TransactionStorage.logTransaction(currentUser, "Transfer to " + recipient, val);
                    updateBalanceLabels();
                    UserAuthentication.updateAllAccounts();
                    msg.setText("Transfer successful.");
                } else {
                    msg.setText("Insufficient funds.");
                }
            } catch (NumberFormatException ex) {
                msg.setText("Invalid amount.");
            }
            recipientField.clear();
            amountField.clear();
        });

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainScene));

        layout.getChildren().addAll(new Label("Recipient Username"), recipientField, new Label("Amount"), amountField, sendBtn, back, msg);
        transferScene = new Scene(layout, 300, 300);
    }

    // ===== Transaction History Scene =====
    private void setupHistoryScene() {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        historyArea = new TextArea();
        historyArea.setEditable(false);

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(mainScene));

        layout.getChildren().addAll(new Label("Transaction History"), historyArea, back);
        historyScene = new Scene(layout, 400, 400);
    }
	
	private void showErrorDialog(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setHeaderText(null); 
    alert.setContentText(message);
    
    ButtonType okButton = new ButtonType("OK");
    alert.getButtonTypes().setAll(okButton); 
    
    alert.showAndWait();
		}
		
	private void showAlert(String title, String message, Alert.AlertType type) {
    Alert alert = new Alert(type);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

    // ===== Utility: Update Balance Labels =====
    private void updateBalanceLabels() {
        // Updating the balance labels with style classes
	balanceLabel.setText("Chequing: $" + String.format("%.2f", currentAccount.getChequingBalance()));
	balanceLabel.getStyleClass().add("balance-label");  

	savingsLabel.setText("Savings: $" + String.format("%.2f", currentAccount.getSavingsBalance()));
	savingsLabel.getStyleClass().add("balance-label");  
	}
    
    private void updateSavingsLabel() {
    	if(currentAccount != null) {
    		savingsBalanceLabel.setText("Savings Balance: $" + String.format("%.2f", currentAccount.getSavingsBalance()));
    	}
    }
}
