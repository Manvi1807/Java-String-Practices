import java.util.Arrays;
import java.util.Scanner;

public class TwoSumSolver {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] nums = new int[length];
            for (int i = 0; i < length; i++) {
                nums[i] = scanner.nextInt();
            }
            int target = scanner.nextInt();

            int[] resultIndices = twoSum(nums, target);
            System.out.println(Arrays.toString(resultIndices));
        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
        }
    }
}