import java.util.Scanner;

public class TopPerformerTracker {

    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "Min: 0 | Max: 0 | Spread: 0";
        }

        int minScore = scores[0];
        int maxScore = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minScore) {
                minScore = scores[i];
            }
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        int spread = maxScore - minScore;
        return "Min: " + minScore + " | Max: " + maxScore + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalScores = scanner.nextInt();
            int[] scores = new int[totalScores];
            for (int i = 0; i < totalScores; i++) {
                scores[i] = scanner.nextInt();
            }

            String performanceReport = findMinMaxSpread(scores);
            System.out.println(performanceReport);
        } catch (Exception e) {
            System.out.println("Error calculating performance spread: " + e.getMessage());
        }
    }
}