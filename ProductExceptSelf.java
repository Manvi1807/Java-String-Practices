import java.util.Arrays;
import java.util.Scanner;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        int arrayLength = nums.length;
        int[] answerArray = new int[arrayLength];

        // Pass 1: Accumulate left prefix products
        answerArray[0] = 1;
        for (int i = 1; i < arrayLength; i++) {
            answerArray[i] = answerArray[i - 1] * nums[i - 1];
        }

        // Pass 2: Accumulate right suffix products
        int rightRunningProduct = 1;
        for (int i = arrayLength - 1; i >= 0; i--) {
            answerArray[i] = answerArray[i] * rightRunningProduct;
            rightRunningProduct *= nums[i];
        }

        return answerArray;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = scanner.nextInt();
            int[] inputArray = new int[size];
            for (int i = 0; i < size; i++) {
                inputArray[i] = scanner.nextInt();
            }

            int[] result = productExceptSelf(inputArray);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            System.out.println("Error calculating product array: " + e.getMessage());
        }
    }
}