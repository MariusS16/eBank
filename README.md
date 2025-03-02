# 🏦 eBanking Application

  This project represents an eBank application, implemented in **Java**, that simulates the functionality of an online bank. The application allows users to create accounts, perform banking operations such as deposits, withdrawals, transfers, invest in stocks, receive stock recommendations and loan management. Additionally, the system includes a user management mechanism, authentication support, and account administration.

Built using **Design Patterns** to ensure scalability, maintainability, and extensibility.

## 🌐 Features

- **User Management** – Create and manage user profiles, including name, email, address, and friends.
- **Multi-Currency Accounts** – Supports USD, EUR, GBP, CAD, and JPY.
- **Money Transactions** – Transfer money to friends, add funds, and exchange currencies.
- **Stock Trading** – Buy stocks using USD and receive recommendations based on Simple Moving Averages (SMA) Crossover Strategy.
- **Command-Based Architecture** – Efficient command execution using Singleton + Command pattern.
- **Premium Accounts** – Users can purchase a premium subscription for benefits like:
    - No 1% exchange fee for currency conversions.
    - 5% discount on stocks recommended by the system.
- **Error Handling** – Ensures smooth banking operations and prevents invalid transactions.

## 🏗 Design Patterns Used
- **Builder Pattern (User Creation)**
  - Provides a flexible way to create users step-by-step.
  - Ensures all necessary attributes are initialized before a user object is created.

- **Factory Method (Account Creation)**
  - Used to instantiate different types of accounts (USD, EUR, GBP, CAD, JPY).
  - Ensures a structured approach for handling multiple currency accounts.

- **Singleton + Command Pattern (Commands Execution)**
  - `Singleton` ensures a single instance for managing all banking commands.
  - `Command Pattern` enables a structured way of handling operations such as:

    - **CREATE USER** – Registers a new user.
    - **ADD FRIEND** – Adds a user to the friend list.
    - **ADD ACCOUNT** – Creates an account in a specified currency.
    - **ADD MONEY** – Deposits money into a user's account.
    - **TRANSFER MONEY** – Transfers money between users.
    - **EXCHANGE MONEY** – Converts funds between currencies.
    - **BUY STOCKS** – Purchases company stocks.
    - **RECOMMEND STOCKS** – Suggests profitable stocks based on SMA analysis.
    - **LIST USER** - Displays user details in JSON format.
    - **LIST PORTFOLIO** - Displays the user's portfolio in JSON format, including stock holdings and currency balances.
    - **BUY PREMIUM** - Upgrades the user to premium status for 100 USD (one-time fee).

## 🔧 Technology Stack
- Java (JDK 11 or later) – Ensures cross-platform compatibility and object-oriented programming principles.
- Gradle – Dependency and build management.
- Used JSON format for input and output.
- Design Patterns to ensure scalability, maintainability, and extensibility.

## 🛠 Build & Installation

Before installing, ensure that all necessary dependencies are already installed.

### Build Instructions

Follow these steps to clone, build, and run the eBanking application:

```sh
# Clone the repository
git clone https://github.com/MariusS16/eBank.git
cd eBank

# Build the project using Gradle
./gradlew build

```
## 💫 Contributing
Contributions are welcome! 🎉 If you have new ideas, suggestions for improvements, or have found bugs, feel free to share them.

We encourage discussions and feedback to enhance the project. If you would like to contribute, open an issue or submit a pull request with your improvements.

