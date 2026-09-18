import java.util.Scanner;

public class InventoryCsvParser {

    public static void parseInventoryRecord(String csvLine) {
        try {
            if (csvLine == null || csvLine.trim().isEmpty()) {
                System.out.println("Invalid Record");
                return;
            }

            String[] recordFields = csvLine.split(",");

            if (recordFields.length != 3) {
                System.out.println("Invalid Record");
                return;
            }

            String productName = recordFields[0].trim();
            String skuCode = recordFields[1].trim();
            String quantity = recordFields[2].trim();

            System.out.println("Product: " + productName + " | SKU: " + skuCode + " | Qty: " + quantity);

        } catch (Exception e) {
            System.out.println("Invalid Record");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputRecord = scanner.nextLine();
            parseInventoryRecord(inputRecord);
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}