import java.util.Scanner;

class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor chaining for interns
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(this.empId + " | " + this.empName + " | Rs " + this.salary + " | Intern: " + this.isIntern);
    }
}

public class EmployeeProfileDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Permanent Employee
            String permId = scanner.next();
            String permName = scanner.next();
            double permSalary = scanner.nextDouble();
            Employee permEmp = new Employee(permId, permName, permSalary);

            // Intern
            String internId = scanner.next();
            String internName = scanner.next();
            Employee internEmp = new Employee(internId, internName);

            permEmp.printProfile();
            internEmp.printProfile();
        } catch (Exception e) {
            System.out.println("Error creating employee profiles: " + e.getMessage());
        }
    }
}