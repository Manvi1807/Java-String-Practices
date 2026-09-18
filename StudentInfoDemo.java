import java.util.Scanner;

class Student {
    private String name;
    private double attendance;

    public static String collegeName = "SRM Institute of Science and Technology";
    public static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentInfoDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String name1 = scanner.next();
            double att1 = scanner.nextDouble();
            Student s1 = new Student(name1, att1);

            String name2 = scanner.next();
            double att2 = scanner.nextDouble();
            Student s2 = new Student(name2, att2);

            // Access static method via class name directly
            Student.printCollegeInfo();
        } catch (Exception e) {
            System.out.println("Error processing student information: " + e.getMessage());
        }
    }
}