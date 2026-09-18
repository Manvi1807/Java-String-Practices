import java.util.Scanner;

public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return "Rejected — invalid file type";
        }
        try {
            int dotIndex = filename.lastIndexOf('.');
            String extension = filename.substring(dotIndex + 1);

            if (extension.equalsIgnoreCase("pdf") || 
                extension.equalsIgnoreCase("docx") || 
                extension.equalsIgnoreCase("zip")) {
                return "Accepted";
            } else {
                return "Rejected — invalid file type";
            }
        } catch (IndexOutOfBoundsException e) {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String filename = scanner.nextLine();
            System.out.println(validateFileExtension(filename));
        } catch (Exception e) {
            System.out.println("Error validating file extension.");
        }
    }
}