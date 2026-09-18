import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Chaining constructor for theory-only courses
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return this.credits + this.labCredits;
    }

    public String getCode() {
        return this.code;
    }
}

public class CourseCreditDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Theory Course
            String c1Code = scanner.next();
            String c1Title = scanner.next();
            int c1Credits = scanner.nextInt();
            Course theoryCourse = new Course(c1Code, c1Title, c1Credits);

            // Lab Course
            String c2Code = scanner.next();
            String c2Title = scanner.next();
            int c2Credits = scanner.nextInt();
            int c2LabCredits = scanner.nextInt();
            Course labCourse = new Course(c2Code, c2Title, c2Credits, c2LabCredits);

            System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());
            System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
        } catch (Exception e) {
            System.out.println("Error processing courses: " + e.getMessage());
        }
    }
}