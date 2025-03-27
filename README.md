<<<<<<< HEAD
# Team-5
<<<<<<< HEAD
=======
## UserAuthentication.java Overview
>>>>>>> spike-user-authentication

The `UserAuthentication.java` class is responsible for handling user-related operations, including registration, login, and account management. It interacts with the `BankAccount` and `User` classes to provide a smooth banking experience. This class stores user credentials, manages account data, and handles account termination and updates.

### Key Features

1. **Initialize**: Loads existing user accounts from a file (`accounts.txt`), which contains user credentials, account balances, and personal details.
2. **Register**: Registers a new user by creating a user account with provided details such as username, password, first name, last name, date of birth, and an initial balance.
3. **Login**: Authenticates a user by verifying their username and password. If the login is successful, the corresponding user account and details are loaded into memory.
4. **Terminate Account**: Allows users to terminate their accounts by removing them from the stored accounts file (`accounts.txt`).
5. **Get Account/User Information**: Retrieves the `BankAccount` and `User` objects associated with a specific username.
6. **Account Existence Check**: Verifies if a user already exists in the system by checking the stored credentials.
7. **Update Accounts**: Updates all stored accounts (credentials, bank accounts, and user details) to ensure synchronization across sessions.

### File Structure
- **accounts.txt**: A file used to store user account details, including username, password (hashed), account balances, and personal information. This file is read and updated whenever a user registers, logs in, or terminates their account.

### How it Works

- **Registration**: When a new user registers, their details are saved to `accounts.txt` through the `FileStorage` class.
- **Login**: The login process verifies the user's credentials by checking against the stored data. If successful, the user is granted access to their bank account.
- **Termination**: If a user wishes to terminate their account, their entry in the `accounts.txt` file is deleted.

<<<<<<< HEAD
**Secondary Use Cases:**

1. Transaction History: View the last 5 transactions for the logged-in user.
2. Handle Negative Balances: The system manages overdraft situations and handles negative balances when withdrawing more than the available funds.
3. Account Termination: Users can close their accounts and delete their information from the system.

**Additional Features:**
1. Input and Output GUI: The system includes a graphical user interface for user interactions and displays account information.
2. Account Switching: Users can switch between multiple account types (e.g., savings, chequing).


**Installation**

**Requirements:**
1. Java 11 or later
2. JavaFX (for GUI)
3. Eclipse, or any Java-compatible editor

**Steps to Run:**

1. Clone the repository:
2. git clone <repository_url>

**Navigate to the project directory:**
1. cd BankAccountManager
2. Compile the project (if necessary):
3. javac *.java

**Run the application:**
java BankGUI

**How to Use**

**Login/Register:**

To use the system, start by either registering a new account or logging in with an existing one.
1. Registration: You need to provide a username, password, date of birth (minimum age 16), and an initial balance.
2. Login: Enter your username and password to access your account.

**Performing Transactions:**
After logging in, you can perform the following actions:
1. Deposit: Deposit money into your account.
2. Withdraw: Withdraw money (ensure sufficient balance).
3. Transfer: Transfer money between accounts.

**Viewing Transaction History:**
Click on the Transaction History button to view the last 5 transactions made on your account.

**Switch Account Types:**
In your persoanl have account you have two types (e.g., savings, chequing), you can switch between them using the Switch Account feature.

**Testing**

1. Unit Tests: The project includes unit tests for validating core functionalities like deposit, withdrawal, account creation, and login.
2. Integration Tests: The full system has been tested to ensure all components work together properly, including file I/O, backend operations, and GUI interactions.
3. Edge Cases: Various edge cases, including invalid inputs, negative balances, and transaction limits, have been tested to ensure robustness.

**Team Member**
1. Hassan Afzaal (Manager)
2. Md Ataullah Bahari (Documentation lead)
3. Naz Karaman (Tech Lead)
4. Yashasvi (Project Facilitator)
=======
# Bank Account Manager - JavaFX GUI

This is a simple bank account management application created using JavaFX. It provides a graphical user interface (GUI) for users to manage their bank accounts, including depositing, withdrawing, transferring funds, viewing transaction history, and managing savings. The system supports user authentication, registration, and account termination.

## Features

- **Login/Registration**: Users can register and log in with their credentials.
- **Account Management**: Users can deposit, withdraw, and transfer money to/from savings accounts.
- **Transaction History**: Users can view the history of their transactions.
- **Account Termination**: Users can terminate their accounts if needed.
- **Multiple Scenes**: Includes different scenes for logging in, registering, main banking operations, savings, transfer, and transaction history.

## Prerequisites

- **Java**: Make sure you have Java JDK 8 or later installed on your machine.
- **JavaFX**: This project uses JavaFX for the GUI components. You may need to install JavaFX SDK if you don't have it already.

## Usage
1. **Login**: Enter your username and password to access your account. If you don't have an account, you can register a new one.
2. **Main Banking Operations**:
    - **Deposit**: Deposit money into your chequing account.
    - **Withdraw**: Withdraw money from your chequing account.
    - **Transfer to Savings**: Transfer funds from your chequing account to your savings account.
    - **Transaction History**: View all past transactions associated with your account.
3. **Savings Account**: View your savings balance and transfer funds back to your chequing account.
4. **Account Termination**: If you wish to terminate your account, you can do so from the main menu.

## Code Overview

The `BankGUI.java` file contains the main code for the GUI and functionality of the application. It defines several scenes and actions that users can interact with. Key components include:

- **Login Scene**: The user is prompted to enter their username and password for authentication.
- **Registration Scene**: New users can create an account by providing personal information and an initial balance.
- **Main Scene**: Provides options for depositing, withdrawing, transferring funds, viewing transaction history, and managing savings.
- **Savings Scene**: Displays the user's savings balance and allows transfers between savings and chequing accounts.
- **Transfer Scene**: Allows transferring funds to other users' accounts by specifying a recipient username and amount.
- **History Scene**: Shows a list of past transactions.

## Styling
The project uses external CSS to style the user interface. The CSS file is applied to the various scenes, providing a consistent look and feel.
>>>>>>> spike-bank-gui
=======
This class is integral to user management and ensures secure login, account access, and account management.
>>>>>>> spike-user-authentication
