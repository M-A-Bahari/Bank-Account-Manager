/**
 * Represents a user's bank account, including chequing and savings balances.
 * Supports deposits, withdrawals, transfers, and peer-to-peer sending.
 * 
 * @author Naz Karaman
 */
public class BankAccount {
    private final String username;
    private double chequingBalance;
    private double savingsBalance;
	
	//Constructs a bank account for a user with initial balances.
    public BankAccount(String username, double chequing, double savings) {
        this.username = username;
        this.chequingBalance = chequing;
        this.savingsBalance = savings;
    }
	
	//Deposits an amount into the chequing account
    public void deposit(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Deposit amount must be positive.");
    }
    chequingBalance += amount;
	}

	//Withdraws an amount from chequing if sufficient funds exist.
    public boolean withdraw(double amount) {
    if (amount <= 0) {
        return false;  
    }
    if (amount > chequingBalance) {
        return false; 
    }
    chequingBalance -= amount;
    return true;
	}

	//Transfers funds from chequing to savings.
    public boolean transferToSavings(double amount) {
        if (amount > chequingBalance) return false;
        chequingBalance -= amount;
        savingsBalance += amount;
        return true;
    }
    
	//Transfers funds from savings back to chequing.
    public boolean transferToChequing(double amount) {
        if (amount > savingsBalance) return false;
        savingsBalance -= amount;
        chequingBalance += amount;
        return true;
    }

    //Send money to another account holder
    public boolean sendTo(BankAccount recipient, double amount) {
        if (amount > chequingBalance) return false;
        // Deduct from sender and deposit into recipient's chequing account
        this.chequingBalance -= amount;
        recipient.deposit(amount);
        return true;
    }

	//Below all are getter methods
    public double getChequingBalance() {
        return chequingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public String getUsername() {
        return username;
    }
}
