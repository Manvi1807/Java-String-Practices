import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSumSolver {

    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> uniqueTripletsList = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate outer elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int leftPointer = i + 1;
            int rightPointer = nums.length - 1;

            while (leftPointer < rightPointer) {
                int currentSum = nums[i] + nums[leftPointer] + nums[rightPointer];

                if (currentSum == 0) {
                    uniqueTripletsList.add(new int[]{nums[i], nums[leftPointer], nums[rightPointer]});

                    // Skip duplicates for left and right pointers
                    while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer + 1]) {
                        leftPointer++;
                    }
                    while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer - 1]) {
                        rightPointer--;
                    }

                    leftPointer++;
                    rightPointer--;
                } else if (currentSum < 0) {
                    leftPointer++;
                } else {
                    rightPointer--;
                }
            }
        }

        return uniqueTripletsList.toArray(new int[uniqueTripletsList.size()][]);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arraySize = scanner.nextInt();
            int[] inputArray = new int[arraySize];
            for (int i = 0; i < arraySize; i++) {
                inputArray[i] = scanner.nextInt();
            }

            int[][] resultMatrix = threeSum(inputArray);
            System.out.println(Arrays.deepToString(resultMatrix));
        } catch (Exception e) {
            System.out.println("Error evaluating 3Sum triplets: " + e.getMessage());
        }
    }
}