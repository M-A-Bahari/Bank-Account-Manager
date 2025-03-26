/**
 * Primary Test Cases
 *
 * @author Hassan Afzaal
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimaryTestCases {

    // Test Account Creation
    @Test
    void testAccountCreation() {
        boolean result = UserAuthentication.register("newUser", "password123", "John", "Doe", "1990-01-01", 1000.0);
        assertTrue(result);
    }

    // Test Login
    @Test
    void testLogin() {
        UserAuthentication.register("testUser", "password123", "Jane", "Doe", "1995-05-05", 500.0);
        boolean result = UserAuthentication.login("testUser", "password123");
        assertTrue(result);
    }

    // Test Withdraw
    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount("testUser", 1000.0, 500.0);
        account.withdraw(200.0);
        assertEquals(800.0, account.getChequingBalance(), 0.0);
    }

    // Test Deposit
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("testUser", 1000.0, 500.0);
        account.deposit(200.0);
        assertEquals(1200.0, account.getChequingBalance(), 0.0);
    }

    // Test Transfer to Savings
    @Test
    void testTransferToSavings() {
        BankAccount account = new BankAccount("testUser", 1000.0, 500.0);
        account.transferToSavings(200.0);
        assertEquals(700.0, account.getSavingsBalance(), 0.0); 
    	assertEquals(800.0, account.getChequingBalance(), 0.0);
    }
}
