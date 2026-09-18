import java.util.Arrays;
import java.util.Scanner;

public class HackathonScoreBooster {

    public static void curveScores(int[] scores, int bonus) {
        if (scores == null || bonus < 0) {
            return;
        }

        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalScores = scanner.nextInt();
            int[] scores = new int[totalScores];
            for (int i = 0; i < totalScores; i++) {
                scores[i] = scanner.nextInt();
            }
            int bonusAmount = scanner.nextInt();

            curveScores(scores, bonusAmount);
            System.out.println(Arrays.toString(scores));
        } catch (Exception e) {
            System.out.println("Error processing scores: " + e.getMessage());
        }
    }
}