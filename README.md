
# 💸 Expense Tracker - Java Console Application

A **console-based Expense Tracker** built in Java using **JDBC** and **MySQL**.  
It helps you manage your **daily financial transactions**, track **credits/debits**, and calculate **balances** within date ranges.

---

## 🚀 Features

- ✅ Add credit and debit transactions  
- ✅ View all transactions  
- ✅ Filter transactions by type (Credit/Debit)  
- ✅ Calculate balance in a specific date range   
- ✅ Console-based interface  
- ✅ MySQL database integration  

---

## 🛠️ Tech Stack

| Layer        | Technology       |
|--------------|------------------|
| Language     | Java (JDK)   |
| Database     | MySQL            |
| Connection   | JDBC             |
| IDE          | IntelliJ IDEA    |

---

## 🗃️ Database Setup

1. Install MySQL Server and Workbench.
2. Open `finance_manager.sql` from the `/sql/` folder.
3. Execute the script to create the `finance_tracker` database and `transactions` table.

```sql
CREATE DATABASE finance_tracker;

USE finance_tracker;

CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE NOT NULL,
    type VARCHAR(20) NOT NULL,
    category VARCHAR(50),
    description VARCHAR(255),
    date DATE NOT NULL
);
```

---

## 📦 How to Run

### ▶️ Using IntelliJ IDEA

1. Open the project in IntelliJ
2. Set your MySQL credentials inside `DBConnection.java`
3. Run `Main.java`

### ▶️ From Terminal

```bash
javac -d bin src/**/*.java
java -cp bin Main
```

---

## 📁 Project Structure

```
ExpenseTracker/
├── src/
│   ├── dao/           # Data access (JDBC)
│   ├── db/            # DBConnection
│   ├── model/         # Transaction class
│   └── Main.java      # App Entry Point
├── sql/
│   └── finance_manager.sql
├── README.md
├── .gitignore
```

---

## Sample Output

```
Enter choice:
1. Add Transaction
2. View All Transactions
3. Filter by Type
4. Calculate Balance (Date Range)
5. Export to CSV
0. Exit
```

---

## ✅ Sample Transaction Output

```text
Transaction [id=1, amount=500.0, type=credit, category=Salary, description=August Pay, date=2025-08-05]
Transaction [id=2, amount=200.0, type=debit, category=Food, description=Lunch, date=2025-08-05]
```

---


## ✨ Author

**Parth Kourwar**  
*Developer | Student | Java Enthusiast*

---

## ⭐ Contribute

Feel free to fork the repo, improve it, and raise a pull request!

---

## 🔮 Future Scope

Here are some possible enhancements to expand this project:

- 🔐 User authentication system (login/signup) to support multiple users
- 📊 Graphical reports using JavaFX or external chart libraries
- 📅 Recurring transactions (e.g., monthly rent, subscriptions)
- 📈 Monthly spending analysis and budgeting suggestions
- 🌐 Web-based version using Spring Boot or Java Servlets
- ☁️ Cloud-hosted MySQL integration for portability
- 📱 Android app version using Java/Kotlin for mobile expense tracking
- 🔔 Email/SMS alerts for threshold breaches or reminders

These features can transform the basic tracker into a full-fledged personal finance management system.
