import java.util.Scanner;

class CompanyEmployee {
    private String empName;
    private double salary;

    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyInfoDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countToCreate = scanner.nextInt();

            for (int i = 0; i < countToCreate; i++) {
                String name = scanner.next();
                double salary = scanner.nextDouble();
                new CompanyEmployee(name, salary);
            }

            // Call static method using class name directly
            CompanyEmployee.printCompanyInfo();
        } catch (Exception e) {
            System.out.println("Error processing company information: " + e.getMessage());
        }
    }
}