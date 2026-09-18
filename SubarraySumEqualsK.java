import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumFrequencies = new HashMap<>();
        // Base case: prefix sum of 0 appears once before processing elements
        prefixSumFrequencies.put(0, 1);

        int cumulativeSum = 0;
        int matchingSubarrayCount = 0;

        for (int currentVal : nums) {
            cumulativeSum += currentVal;

            if (prefixSumFrequencies.containsKey(cumulativeSum - k)) {
                matchingSubarrayCount += prefixSumFrequencies.get(cumulativeSum - k);
            }

            prefixSumFrequencies.put(cumulativeSum, prefixSumFrequencies.getOrDefault(cumulativeSum, 0) + 1);
        }

        return matchingSubarrayCount;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalElements = scanner.nextInt();
            int[] numbersArray = new int[totalElements];
            for (int i = 0; i < totalElements; i++) {
                numbersArray[i] = scanner.nextInt();
            }
            int targetSum = scanner.nextInt();

            int totalMatches = subarraySum(numbersArray, targetSum);
            System.out.println(totalMatches);
        } catch (Exception e) {
            System.out.println("Error calculating sub-array sum frequency: " + e.getMessage());
        }
    }
}