import java.util.ArrayList;

public class BankManager {
    private ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account a) {
        accounts.add(a);
        System.out.println("Account added successfully!");
    }

    public void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("\nAccount List:");
        for (Account a : accounts) {
            a.display();
        }
    }

    public Account searchAccount(int accountNumber) {
        for (Account a : accounts) {
            if (a.getAccountNumber() == accountNumber) {
                return a;
            }
        }
        return null;
    }

    public void deleteAccount(int accountNumber) {
        Account a = searchAccount(accountNumber);
        if (a != null) {
            accounts.remove(a);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found.");
        }
    }
}
