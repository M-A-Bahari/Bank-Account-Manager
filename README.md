<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> b163bc8398fbaa99e383fb43cb1c3a2d642a7ae5
# Team-5

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
<<<<<<< HEAD
=======
4. Yashasvi (Project Facilitator & Support Role)
>>>>>>> origin/spike-user-authentication


=======
Overview:
This project implements a User Authentication System in Java, featuring user registration and login functionalities. It securely handles user credentials and ensures proper authentication mechanisms.

Features:
(1) User Registration: Users can create an account with a username and password.
(2) User Login: Users can log in using their credentials.
(3) Password Hashing: Ensures security using hashing techniques.(This is/ will be implemented on the FileStorage.java class)
(4) Error Handling: Provides meaningful error messages for invalid credentials.
(5) File-Based Storage (Optional): Users' credentials can be stored in a file/database.(We are using file based storage)
>>>>>>> 1a94cb949350f7019ab99e9cd5d8756ebd9a6431
=======
# Team-5
Spike 4: Storage Solution (Database vs. File)
Spike Owners: Hassan
Spike Branch Name: spike-storage
Goals:
Test  file-based storage for saving user data.
Implement basic read/write operations.
Ensure data persists between sessions.
Outcome:
text file (if simple, single-user).

Jira Access:
https://team5cs2043.atlassian.net/jira/software/projects/SCRUM/boards/1
>>>>>>> spike-file-storage
=======
>>>>>>> b163bc8398fbaa99e383fb43cb1c3a2d642a7ae5
