import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager manager = new BankManager();

        int choice;
        do {
            System.out.println("\n==== Bank Account Management System ====");
            System.out.println("1. Add Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Delete Account");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String holder = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    Account a = new Account(accNo, holder, balance);
                    manager.addAccount(a);
                    break;
                case 2:
                    manager.viewAllAccounts();
                    break;
                case 3:
                    System.out.print("Enter Account Number to Deposit: ");
                    int depNo = sc.nextInt();
                    Account acc1 = manager.searchAccount(depNo);
                    if (acc1 != null) {
                        System.out.print("Enter Amount to Deposit: ");
                        double depAmount = sc.nextDouble();
                        acc1.deposit(depAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number to Withdraw: ");
                    int wNo = sc.nextInt();
                    Account acc2 = manager.searchAccount(wNo);
                    if (acc2 != null) {
                        System.out.print("Enter Amount to Withdraw: ");
                        double wAmount = sc.nextDouble();
                        acc2.withdraw(wAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account Number to Delete: ");
                    int dNo = sc.nextInt();
                    manager.deleteAccount(dNo);
                    break;
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }
}
