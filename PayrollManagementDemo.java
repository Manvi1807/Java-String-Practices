import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initializing to 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: Amount must be positive.");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: Invalid percentage.");
            return;
        }
        this.basicSalary -= (this.basicSalary * (percent / 100.0));
        System.out.println("Tax deducted: " + (int) percent + "%");
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class PayrollManagementDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double openingSalary = scanner.nextDouble();
            PayrollAccount account = new PayrollAccount(openingSalary);

            double bonusAmount = scanner.nextDouble();
            account.creditBonus(bonusAmount);

            double taxPercent = scanner.nextDouble();
            account.deductTax(taxPercent);

            System.out.println("Net salary: Rs " + account.getNetSalary());
        } catch (Exception e) {
            System.out.println("Error processing payroll: " + e.getMessage());
        }
    }
}