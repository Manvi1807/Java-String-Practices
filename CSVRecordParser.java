import java.util.Scanner;

public class CSVRecordParser {
    public static void parseStudentRecord(String csvLine) {
        try {
            if (csvLine == null || csvLine.trim().isEmpty()) {
                System.out.println("Invalid Record");
                return;
            }
            String[] fields = csvLine.split(",");
            if (fields.length != 3) {
                System.out.println("Invalid Record");
                return;
            }
            String name = fields[0].trim();
            String rollNo = fields[1].trim();
            String dept = fields[2].trim();

            System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
        } catch (Exception e) {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            parseStudentRecord(input);
        } catch (Exception e) {
            System.out.println("Error reading input");
        }
    }
}