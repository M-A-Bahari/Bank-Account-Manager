## UserAuthentication.java Overview

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

This class is integral to user management and ensures secure login, account access, and account management.
