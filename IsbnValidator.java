import java.util.Scanner;

public class IsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmedCode = raw.trim();
        if (trimmedCode.length() < 3) {
            return trimmedCode;
        }
        return trimmedCode.substring(0, 3).toUpperCase() + trimmedCode.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7, 13);

        StringBuilder formattedOutput = new StringBuilder();
        formattedOutput.append("[").append(publisherCode).append("] YEAR: ")
                       .append(year).append(" | CATALOG: ").append(catalogNumber);

        return formattedOutput.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String rawInput = scanner.nextLine();
            String normalizedCode = normalizeCode(rawInput);
            String result = validateAndFormat(normalizedCode);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error processing ISBN code: " + e.getMessage());
        }
    }
}