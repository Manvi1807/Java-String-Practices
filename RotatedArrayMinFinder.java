import java.util.Scanner;

public class RotatedArrayMinFinder {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (nums[middleIndex] > nums[rightIndex]) {
                // Minimum value resides in the right half
                leftIndex = middleIndex + 1;
            } else {
                // Minimum value is at middleIndex or in the left half
                rightIndex = middleIndex;
            }
        }

        return nums[leftIndex];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int elementCount = scanner.nextInt();
            int[] rotatedArray = new int[elementCount];
            for (int i = 0; i < elementCount; i++) {
                rotatedArray[i] = scanner.nextInt();
            }

            int minimumValue = findMin(rotatedArray);
            System.out.println(minimumValue);
        } catch (Exception e) {
            System.out.println("Error searching minimum in array: " + e.getMessage());
        }
    }
}