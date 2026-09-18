import java.util.Scanner;

public class MatchGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        double totalRuns = 0;
        for (int runs : row) {
            totalRuns += runs;
        }

        return totalRuns / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder outputBuilder = new StringBuilder();

        for (int matchIndex = 0; matchIndex < runsPerOver.length; matchIndex++) {
            double averageRuns = rowAverage(runsPerOver[matchIndex]);

            outputBuilder.append("Match ").append(matchIndex).append(": ");
            if (averageRuns >= threshold) {
                outputBuilder.append("Power Surge");
            } else {
                outputBuilder.append("Normal");
            }

            if (matchIndex < runsPerOver.length - 1) {
                outputBuilder.append(" | ");
            }
        }

        return outputBuilder.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalMatches = scanner.nextInt();
            int[][] matchGrid = new int[totalMatches][];

            for (int i = 0; i < totalMatches; i++) {
                int totalOvers = scanner.nextInt();
                matchGrid[i] = new int[totalOvers];
                for (int j = 0; j < totalOvers; j++) {
                    matchGrid[i][j] = scanner.nextInt();
                }
            }

            int threshold = scanner.nextInt();
            String classificationResult = classifyMatches(matchGrid, threshold);
            System.out.println(classificationResult);
        } catch (Exception e) {
            System.out.println("Error analyzing match grid: " + e.getMessage());
        }
    }
}