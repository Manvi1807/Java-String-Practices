import java.util.Scanner;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int highestOverallSum = nums[0];
        int currentRunningSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend running subarray or start fresh from current index
            currentRunningSum = Math.max(nums[i], currentRunningSum + nums[i]);
            highestOverallSum = Math.max(highestOverallSum, currentRunningSum);
        }

        return highestOverallSum;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalNumbers = scanner.nextInt();
            int[] numberSequence = new int[totalNumbers];
            for (int i = 0; i < totalNumbers; i++) {
                numberSequence[i] = scanner.nextInt();
            }

            int maximumSum = maxSubArray(numberSequence);
            System.out.println(maximumSum);
        } catch (Exception e) {
            System.out.println("Error processing maximum subarray sum: " + e.getMessage());
        }
    }
}