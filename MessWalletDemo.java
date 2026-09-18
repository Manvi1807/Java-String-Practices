import java.util.Scanner;

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than zero");
            return;
        }
        this.balance += amount;
        System.out.println("Balance after top-up: " + this.balance);
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        this.balance -= amount;
        System.out.println("Balance after deduction: " + this.balance);
    }

    public double getBalance() {
        return this.balance;
    }
}

public class MessWalletDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double opening = scanner.nextDouble();
            MessWallet wallet = new MessWallet(opening);

            double topUpAmount = scanner.nextDouble();
            wallet.topUp(topUpAmount);

            double deductAmount = scanner.nextDouble();
            wallet.deduct(deductAmount);

            System.out.println("Final balance: " + wallet.getBalance());
        } catch (Exception e) {
            System.out.println("Error managing mess wallet: " + e.getMessage());
        }
    }
}