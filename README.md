# Team-5
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
