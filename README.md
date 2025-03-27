# T13 Bank Account Manager

## Overview

T13 Bank Account Manager is an online banking application that allows users to perform basic banking operations such as depositing, withdrawing, transferring money between accounts, and making purchases. The application supports multiple types of accounts, including savings, chequing, interest, and student accounts. The user interface (GUI) provides an intuitive way for users to navigate their account(s), view balances, and interact with banking operations.

## Features

### Primary Features
- **Account Creation**: Users can create an account by providing basic personal information and an initial balance. Age verification is implemented to ensure that the user is 16 or older.
- **Login System**: Users can securely log in to their accounts with a username and password.
- **Bank Operations**:
  - **Deposit**: Users can deposit money into their chequing account.
  - **Withdraw**: Users can withdraw money from their chequing account with sufficient balance.
  - **Transfers**: Users can transfer funds between chequing and savings accounts.
  - **Send Money**: Users can send money to other users' accounts.
- **Multiple Accounts**: Users can manage multiple accounts (e.g., savings, chequing, etc.).
- **Transaction History**: Users can view a history of up to 5 previous transactions.
- **Account Termination**: Users have the option to close their accounts.

### Secondary Features
- **Handle Negative Balances**: If a user attempts to withdraw more than their balance, the transaction is blocked.
- **Transaction Logging**: Every banking transaction is logged and can be reviewed in the transaction history.
  
## How It Works

### Backend Storage
- **File Storage**: All user data, including account balances and personal details, are stored in a text file `accounts.txt`. This file is updated whenever a user logs in, makes a transaction, or updates their account information.
- **Password Hashing**: User passwords are securely stored using SHA-256 hashing.
  
### Account Management
- **User Registration**: A user registers by providing a username, password, first name, last name, date of birth, and an initial balance. The system ensures the user is 16 or older before allowing registration.
- **User Login**: Users log in using their username and password. The system verifies the credentials against the stored hashed passwords.

### Bank Account Operations
- **Withdrawals**: Users can withdraw money from their chequing account, provided they have sufficient funds.
- **Deposits**: Users can deposit funds into their chequing account.
- **Transfers**: Users can transfer money between their chequing and savings accounts.

## Test Cases

### Primary Test Cases
- **Account Creation**: Validates user registration with correct data.
- **Login**: Ensures that users can successfully log in with the correct username and password.
- **Withdraw**: Tests the withdrawal functionality to ensure balances are updated correctly.
- **Deposit**: Verifies that deposits are correctly reflected in the user's chequing balance.
- **Transfer**: Confirms that transfers between chequing and savings accounts work as expected.

### Secondary Test Cases
- **Account Termination**: Validates that users can successfully terminate their accounts.
- **Transaction History Logging**: Ensures that transaction history is correctly logged and accessible.
- **Negative Balance Handling**: Verifies that users cannot withdraw more money than they have in their account.

## Technologies Used
- **Java**: The application is developed using Java, leveraging JavaFX for the graphical user interface (GUI).
- **SHA-256**: Used for secure password hashing.
- **JUnit**: Used for testing the core functionality of the application.

## File Structure

- `BankAccount.java`: Contains the `BankAccount` class that manages account operations like deposits, withdrawals, and transfers.
- `BankGUI.java`: Implements the JavaFX GUI for the application, allowing users to interact with their accounts.
- `FileStorage.java`: Handles reading and writing user data to and from a file.
- `SecondaryTestCases.java`: Contains secondary test cases to validate additional functionality.
- `PrimaryTestCases.java`: Includes primary test cases for account creation, login, and transaction operations.
- `TransactionStorage.java`: Manages the logging of transactions and retrieving transaction history.
- `User.java`: Defines the `User` class that holds personal user information.
- `UserAuthentication.java`: Manages user registration, login, and account management.

## How to Run

1. Clone the repository.
2. Compile the Java files using `javac`.
3. Run the `BankGUI.java` file to start the application.
4. Use the provided login credentials or create a new account.

```bash
javac BankAccount.java BankGUI.java FileStorage.java User.java UserAuthentication.java TransactionStorage.java PrimaryTestCases.java SecondaryTestCases.java
java BankGUI
