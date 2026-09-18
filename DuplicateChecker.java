import java.util.Scanner;

public class DuplicateChecker {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalElements = scanner.nextInt();
            int[] numbersArray = new int[totalElements];
            for (int i = 0; i < totalElements; i++) {
                numbersArray[i] = scanner.nextInt();
            }

            boolean hasDuplicate = containsDuplicate(numbersArray);
            System.out.println(hasDuplicate);
        } catch (Exception e) {
            System.out.println("Error processing input array: " + e.getMessage());
        }
    }
}