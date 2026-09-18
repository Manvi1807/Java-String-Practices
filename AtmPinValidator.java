import java.util.Scanner;

public class AtmPinValidator {
    
    public static void checkPinLength(String pin) {
        if (pin == null || pin.length() != 4) {
            System.out.println("Invalid PIN must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String userPinInput = scanner.nextLine();
            checkPinLength(userPinInput);
        } catch (Exception e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }
}