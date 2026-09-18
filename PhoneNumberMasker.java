import java.util.Scanner;

public class PhoneNumberMasker {
    public static String maskPhoneNumber(String phone) {
        if (phone == null || phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        StringBuilder masked = new StringBuilder("XXXXXX");
        masked.append("-");
        masked.append(phone.substring(6));
        return masked.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String phoneInput = scanner.nextLine();
            System.out.println(maskPhoneNumber(phoneInput));
        } catch (Exception e) {
            System.out.println("Error processing phone number.");
        }
    }
}