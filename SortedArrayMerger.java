import java.util.Arrays;
import java.util.Scanner;

public class SortedArrayMerger {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        int firstArrayLength = arr1.length;
        int secondArrayLength = arr2.length;
        int[] mergedResultArray = new int[firstArrayLength + secondArrayLength];

        int firstPointer = 0;
        int secondPointer = 0;
        int resultPointer = 0;

        while (firstPointer < firstArrayLength && secondPointer < secondArrayLength) {
            if (arr1[firstPointer] <= arr2[secondPointer]) {
                mergedResultArray[resultPointer++] = arr1[firstPointer++];
            } else {
                mergedResultArray[resultPointer++] = arr2[secondPointer++];
            }
        }

        while (firstPointer < firstArrayLength) {
            mergedResultArray[resultPointer++] = arr1[firstPointer++];
        }

        while (secondPointer < secondArrayLength) {
            mergedResultArray[resultPointer++] = arr2[secondPointer++];
        }

        return mergedResultArray;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size1 = scanner.nextInt();
            int[] arr1 = new int[size1];
            for (int i = 0; i < size1; i++) {
                arr1[i] = scanner.nextInt();
            }

            int size2 = scanner.nextInt();
            int[] arr2 = new int[size2];
            for (int i = 0; i < size2; i++) {
                arr2[i] = scanner.nextInt();
            }

            int[] mergedArray = mergeSortedArrays(arr1, arr2);
            System.out.println(Arrays.toString(mergedArray));
        } catch (Exception e) {
            System.out.println("Error parsing arrays: " + e.getMessage());
        }
    }
}