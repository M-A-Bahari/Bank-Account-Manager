# Team-5
<<<<<<< HEAD

**Bank Account Manager - CS2043 Team 13 Project**

**Project Overview**

The Bank Account Manager is a simple banking application that allows users to:
1. Create accounts (with basic age verification).
2. Log in to their accounts securely.
3. Deposit, withdraw, and transfer money between accounts.
4. Manage multiple account types like chequing and savings.
5. View transaction history.
6. Handle negative balances and maintain secure account operations.

**Features**

**Primary Use Cases:**

1. Account Creation: Allows users to create an account by entering their name, age, username, password, and starting balance.
2. Login: Validates the username and password to allow users to access their accounts.
3. Deposit: Users can deposit money into their chequing account.
4. Withdraw: Allows users to withdraw money from their chequing account (with balance check).
5. Transfer: Enables users to transfer money between their chequing and savings accounts.

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
