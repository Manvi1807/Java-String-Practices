import java.util.Arrays;
import java.util.Scanner;

public class PodiumFinder {

    public static int[] findTopThreeScores(int[] scores) {
        if (scores == null || scores.length < 3) {
            return new int[0];
        }

        int firstHighest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        int thirdHighest = Integer.MIN_VALUE;

        for (int currentScore : scores) {
            if (currentScore >= firstHighest) {
                thirdHighest = secondHighest;
                secondHighest = firstHighest;
                firstHighest = currentScore;
            } else if (currentScore >= secondHighest) {
                thirdHighest = secondHighest;
                secondHighest = currentScore;
            } else if (currentScore > thirdHighest) {
                thirdHighest = currentScore;
            }
        }

        return new int[]{firstHighest, secondHighest, thirdHighest};
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalScores = scanner.nextInt();
            int[] scores = new int[totalScores];
            for (int i = 0; i < totalScores; i++) {
                scores[i] = scanner.nextInt();
            }

            int[] topThreePodium = findTopThreeScores(scores);
            System.out.println(Arrays.toString(topThreePodium));
        } catch (Exception e) {
            System.out.println("Error processing podium scores: " + e.getMessage());
        }
    }
}