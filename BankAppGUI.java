import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankAppGUI extends Application {
    private double balance = 1000.00; // Sample balance
    private Label balanceLabel;

    @Override
    public void start(Stage primaryStage) {
        balanceLabel = new Label("Current Balance: $" + balance);

        Button depositButton = new Button("Deposit $100");
        depositButton.setOnAction(e -> deposit(100));

        Button withdrawButton = new Button("Withdraw $50");
        withdrawButton.setOnAction(e -> withdraw(50));

        VBox layout = new VBox(10);
        layout.getChildren().addAll(balanceLabel, depositButton, withdrawButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Bank Account Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void deposit(double amount) {
        balance += amount;
        balanceLabel.setText("Current Balance: $" + balance);
    }

    private void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            balanceLabel.setText("Current Balance: $" + balance);
        } else {
            balanceLabel.setText("Insufficient funds!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
