package dao;

import db.DBConnection;
import model.Transaction;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionDAO {

    public boolean insertTransaction(Transaction transaction)
    {
        String sql ="INSERT INTO transactions(amount,type,category,description,date) VALUES(?,?,?,?,?)";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql))
            {
                stmt.setDouble(1,transaction.getAmount());
                stmt.setString(2,transaction.getType());
                stmt.setString(3,transaction.getCategory());
                stmt.setString(4,transaction.getDescription());
                stmt.setDate(5,transaction.getDate());

                int rowsInserted = stmt.executeUpdate();
                return rowsInserted>0;
            }
        catch(SQLException e)
        {
            System.out.println("Error inserting transaction "+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public List<Transaction> getAllTransactions()
    {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery())
        {
            while(rs.next()){
                Transaction transaction = new Transaction(
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("type"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getDate("date")
                );
                transactions.add(transaction);

            }
        }catch(SQLException e){
            System.out.println("Error Fetching the Data. "+e.getMessage());
            e.printStackTrace();
        }
        for (Transaction t : transactions) {
            System.out.println(t);
        }
        return transactions;
    }
    public List<Transaction> filterTransactionsType() {
        List<Transaction> transact = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE type = ?";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the type of Transaction (Credit/Debit): ");
        String type = sc.next().toLowerCase();

        if (!type.equals("credit") && !type.equals("debit")) {
            System.out.println("Invalid Type Entered");
            return transact;
        }

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {
            stmt.setString(1, type);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transaction transaction = new Transaction(
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("type"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getDate("date")
                );

                transact.add(transaction);
            }


            if (transact.isEmpty()) {
                System.out.println("No transactions found for type: " + type);
            } else {
                System.out.println("Transactions of type: " + type);
                for (Transaction t : transact) {
                    System.out.println(t);  // uses toString()
                }
            }

        } catch (SQLException e) {
            System.out.println("Error Tracing the Transactions. " + e.getMessage());
            e.printStackTrace();
        }

        return transact;
    }


    public List<Transaction> filterByCategoryandDate()
    {
        List<Transaction> transact = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Category:");
        String category = sc.nextLine();

        System.out.println("Enter Start Date(yyyy-mm-dd:");
        String start_date = sc.nextLine();

        System.out.println("Enter End Date(yyyy-mm-dd:");
        String end_date = sc.nextLine();

        String sql = "SELECT * FROM transactions WHERE category = ? AND date BETWEEN ? AND ?";

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql))
        {
            stmt.setString(1,category);
            stmt.setString(2,start_date);
            stmt.setString(3,end_date);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                Transaction transaction = new Transaction(
                        rs.getInt("id"),
                        rs.getDouble("amount"),
                        rs.getString("type"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getDate("date")
                );
                transact.add(transaction);
            }
        }catch(SQLException e)
        {
            System.out.println("Error while finding transaction "+e.getMessage());
            e.printStackTrace();
        }
        for (Transaction t : transact) {
            System.out.println(t); // Each object gets printed on its own line
        }
        return transact;
    }

    public double getBalance()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Start Date (yyyy-mm-dd):");
        String startDateInput = sc.next();
        System.out.println("Enter End Date (yyyy-mm-dd):");
        String endDateInput = sc.next();

        Date startDate = Date.valueOf(startDateInput); // convert to java.sql.Date
        Date endDate = Date.valueOf(endDateInput);

        double balance = 0.0;
        String sql = "SELECT type, amount FROM transactions WHERE date BETWEEN ? AND ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type").toLowerCase();
                double amount = rs.getDouble("amount");

                if (type.equals("credit")) {
                    balance += amount;
                } else {
                    balance -= amount;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Fetching Balance: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Balance Amount is: ₹" + balance);
        return balance;
    }

}
