import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotator {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int totalLength = nums.length;
        int effectiveRotationSteps = k % totalLength;

        if (effectiveRotationSteps < 0) {
            effectiveRotationSteps += totalLength;
        }

        int[] rotatedArray = new int[totalLength];

        for (int i = 0; i < totalLength; i++) {
            int newPosition = (i + effectiveRotationSteps) % totalLength;
            rotatedArray[newPosition] = nums[i];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int length = scanner.nextInt();
            int[] inputNumbers = new int[length];
            for (int i = 0; i < length; i++) {
                inputNumbers[i] = scanner.nextInt();
            }
            int rotationSteps = scanner.nextInt();

            int[] result = rotateArray(inputNumbers, rotationSteps);
            System.out.println(Arrays.toString(result));
        } catch (Exception e) {
            System.out.println("Error performing rotation: " + e.getMessage());
        }
    }
}