import java.util.Scanner;

class PlacementRecord {
    private String studentName;
    private String company;
    private double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(this.studentName + " -> " + this.company + " @ " + this.packageLpa + " LPA");
    }
}

public class PlacementRecordDemo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalRecords = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            PlacementRecord[] records = new PlacementRecord[totalRecords];

            for (int i = 0; i < totalRecords; i++) {
                String name = scanner.next();
                String company = scanner.next();
                double pkg = scanner.nextDouble();
                records[i] = new PlacementRecord(name, company, pkg);
            }

            for (PlacementRecord record : records) {
                record.printRecord();
            }
        } catch (Exception e) {
            System.out.println("Error processing placement records: " + e.getMessage());
        }
    }
}