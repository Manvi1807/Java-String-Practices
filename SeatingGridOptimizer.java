import java.util.Scanner;

public class SeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double scoreSum = 0;
        for (int score : row) {
            scoreSum += score;
        }

        return scoreSum / row.length;
    }

    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder resultBuilder = new StringBuilder();

        for (int rowIndex = 0; rowIndex < seatingScores.length; rowIndex++) {
            double averageScore = rowAverage(seatingScores[rowIndex]);

            resultBuilder.append("Row ").append(rowIndex).append(": ");
            if (averageScore < threshold) {
                resultBuilder.append("Quiet Zone");
            } else {
                resultBuilder.append("Buzzing Zone");
            }

            if (rowIndex < seatingScores.length - 1) {
                resultBuilder.append(" | ");
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalRows = scanner.nextInt();
            int[][] seatingGrid = new int[totalRows][];

            for (int i = 0; i < totalRows; i++) {
                int rowColumns = scanner.nextInt();
                seatingGrid[i] = new int[rowColumns];
                for (int j = 0; j < rowColumns; j++) {
                    seatingGrid[i][j] = scanner.nextInt();
                }
            }

            int performanceThreshold = scanner.nextInt();
            String gridClassification = classifyRows(seatingGrid, performanceThreshold);
            System.out.println(gridClassification);
        } catch (Exception e) {
            System.out.println("Error evaluating seating grid: " + e.getMessage());
        }
    }
}