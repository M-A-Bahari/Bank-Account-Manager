# Bank Account Manager

**Bank Account Manager** is a Java-based banking application that simulates core online banking operations such as account creation, deposits, withdrawals, transfers, and transaction tracking. The application provides a graphical user interface (GUI) that allows users to manage their accounts in an intuitive and structured way.

This project was developed as a **team-based academic project** and is shared publicly for **learning and portfolio purposes only**.

---

## Project Context

- **Project Type**: Academic Group Project  
- **Team Size**: 4 contributors  
- **Methodology**: Agile (Scrum)  
- **Project Management Tool**: Jira  

Jira board (archived / reference only):  
https://team5cs2043.atlassian.net/jira/software/projects/SCRUM/summary

---

## Features

### Core Functionality
- User account registration with age verification (16+)
- Secure login system using hashed passwords
- Support for multiple account types:
  - Chequing
  - Savings
  - Interest
  - Student
- Banking operations:
  - Deposit funds
  - Withdraw funds (with balance validation)
  - Transfer funds between accounts
  - Send money to other users
- Transaction history (up to 5 recent transactions)
- Account termination

### Additional Functionality
- Prevention of negative balances
- Persistent transaction logging
- File-based data storage

---

## Technologies Used

- **Java**
- **JavaFX** (Graphical User Interface)
- **SHA-256** (Password hashing)
- **JUnit** (Unit testing)

---

## How It Works

### Backend Storage
- **File Storage**:  
  All user data, including account balances and personal details, are stored in a text file (`accounts.txt`).  
  This file is updated whenever a user logs in, performs a transaction, or updates account information.
- **Password Hashing**:  
  User passwords are securely stored using **SHA-256 hashing**. Plain-text passwords are never persisted.

### Account Management
- **User Registration**:  
  Users register by providing a username, password, first name, last name, date of birth, and an initial balance.  
  The system enforces a minimum age requirement of **16 years**.
- **User Login**:  
  Login credentials are verified against stored hashed passwords.

### Bank Account Operations
- **Withdrawals**:  
  Users may withdraw money from their chequing account if sufficient funds are available.
- **Deposits**:  
  Users can deposit funds into their chequing account.
- **Transfers**:  
  Funds can be transferred between chequing and savings accounts.

---

## Test Cases

### Primary Test Cases
- **Account Creation**:  
  Validates successful user registration with valid input data.
- **Login**:  
  Ensures users can log in with correct credentials.
- **Withdraw**:  
  Verifies correct balance updates after withdrawals.
- **Deposit**:  
  Confirms deposits are accurately reflected in account balances.
- **Transfer**:  
  Ensures transfers between chequing and savings accounts function correctly.

### Secondary Test Cases
- **Account Termination**:  
  Validates that users can successfully close their accounts.
- **Transaction History Logging**:  
  Confirms transaction records are stored and retrievable.
- **Negative Balance Handling**:  
  Ensures withdrawals exceeding available balances are blocked.

---

## System Design Overview

### Data Storage
- User and account data are stored locally in a text file (`accounts.txt`)
- Data is updated on login, transactions, and account changes
- No external database is used

### Security
- Passwords are stored as **SHA-256 hashes**
- Plain-text passwords are never persisted

### Application Structure
- Object-oriented design
- Clear separation of concerns
- Modular classes for authentication, storage, and transactions

---

## File Structure

| File | Description |
|----|----|
| `BankAccount.java` | Core account operations (deposit, withdraw, transfer) |
| `BankGUI.java` | JavaFX-based graphical user interface |
| `FileStorage.java` | Reads/writes user and account data |
| `TransactionStorage.java` | Manages transaction history |
| `User.java` | Stores user profile information |
| `UserAuthentication.java` | Handles login, registration, and validation |
| `PrimaryTestCases.java` | Core functionality tests |
| `SecondaryTestCases.java` | Additional edge-case tests |

---

## Individual Contribution Disclosure

This repository represents **collaborative work** completed by a team of four.

**My personal contributions include work on the following components:**
- Four core classes related to application logic and system functionality

I did **not** author all files in this repository.  
All contributors share ownership of the project work unless otherwise stated.

This disclosure is provided to ensure transparency and accurate attribution.

---

## Limitations

- Data persistence is file-based (no database)
- Application state may reset if data files are manually altered
- Designed for educational use, not production deployment
- No encryption beyond password hashing is implemented

---

## Academic Integrity Notice

This project was developed as part of a university course.

It is shared publicly **for educational reference and portfolio demonstration only**.

**Do not copy, reuse, or submit this code for academic credit.**  
Doing so may violate your institution’s academic integrity policies.

---

## License

This repository contains **student-authored academic work**.

Unless otherwise specified:

- The code is shared under the **MIT License**
- Contributors retain ownership of their respective work
- No warranty or guarantee is provided

See the `LICENSE` file for full details.

---

## Contributors

- **Ataullah Bahari** — Documentation Lead  
- **Naz Karaman** — Technical Lead  
- **Hassan Afzaal** — Project Manager  
- **Yashasvi Gawaria** — Progress Facilitator  

---

## Disclaimer

This project is a **simulation** and does **not** represent a real banking system.  
It should **not** be used to manage real financial data.

---

## How to Run

1. Clone the repository.
2. Compile the Java files using javac.
```bash
   javac BankAccount.java BankGUI.java FileStorage.java User.java UserAuthentication.java TransactionStorage.java PrimaryTestCases.java SecondaryTestCases.java
```
3. Run the BankGUI.java file to start the application. 