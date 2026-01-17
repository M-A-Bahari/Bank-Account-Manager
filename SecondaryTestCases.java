/**
 * Secondary Test Cases
 *
 * @author Hassan Afzaal
 * @author Naz Karaman
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SecondaryTestCases {

    // Test Account Termination
    @Test
    public void testAccountTermination() {
        // Register a user first
        UserAuthentication.register("userToDelete", "password123", "Jake", "Smith", "1985-12-12", 1500.0);
        
        // Now, terminate the user account
        boolean result = UserAuthentication.terminateAccount("userToDelete");
        
        // Check if the account was successfully terminated
        assertTrue(result);
    }

    // Test Transaction History Logging
    @Test
    public void testTransactionHistoryLogging() {
        // Create a BankAccount object
        BankAccount account = new BankAccount("testUser", 1000.0, 500.0);
        
        // Perform a transaction (e.g., Deposit)
        TransactionStorage.logTransaction("testUser", "Deposit", 500.0);
        
        // Retrieve the transaction history
        String history = TransactionStorage.getTransactionHistory("testUser");
        
        // Ensure the transaction is recorded
        assertTrue(history.contains("Deposit"));
    }

    // Test Negative Balance Handling (ensure withdrawal doesn't occur if insufficient funds)
    @Test
    public void testNegativeBalanceHandling() {
        // Create a BankAccount with a balance
	    BankAccount account = new BankAccount("testUser", 500.0, 1000.0);

        
        // Try to withdraw more than available in chequing
        boolean result = account.withdraw(600.0);  
        
        // Ensure the withdrawal is not allowed (insufficient funds)
        assertFalse(result);
        
        // Ensure the balance remains the same (no money withdrawn)
        assertEquals(500.0, account.getChequingBalance(), 0.0);
    }
}
