import dao.TransactionDAO;
import model.Transaction;


import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransactionDAO dao = new TransactionDAO();
        boolean running = true;

        Scanner sc = new Scanner(System.in);

        while(running)
        {
            System.out.println("\n========Personal Finance Manager========");
            System.out.println("1. Add Transaction.");
            System.out.println("2. View Balance.");
            System.out.println("3. Sort by Type.");
            System.out.println("4. View All Transactions.");
            System.out.println("5. Filter Transactions by Category and Date.");
            System.out.println("6. Exit.");
            System.out.println("**Enter Your Choice**: ");

            int ch= sc.nextInt();

            switch(ch){
                case 1: try {
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // consume newline

                    System.out.print("Enter type (credit/debit): ");
                    String type = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateInput = sc.nextLine();
                    Date date = Date.valueOf(dateInput); // Convert to java.sql.Date

                    // Create and populate Transaction object
                    Transaction transaction = new Transaction();
                    transaction.setAmount(amount);
                    transaction.setType(type);
                    transaction.setCategory(category);
                    transaction.setDescription(description);
                    transaction.setDate(date);

                    // Insert into DB
                    boolean inserted = dao.insertTransaction(transaction);
                    if (inserted) {
                        System.out.println("✅ Transaction inserted successfully.");
                    } else {
                        System.out.println("❌ Failed to insert transaction.");
                    }

                } catch (Exception e) {
                    System.out.println("⚠️ Invalid input. Please try again.");
                    e.printStackTrace();
                }
                    break;
                case 2: dao.getBalance();
                        break;
                case 3: dao.filterTransactionsType();
                        break;
                case 4: dao.getAllTransactions();
                        break;
                case 5: dao.filterByCategoryandDate();
                        break;
                case 6: running = false;
                    System.out.println("Exiting.... Thank You!!");
                        break;

                default:
                    System.out.println("Enter Valid Choice Option.");

            }
        }



    }
}
