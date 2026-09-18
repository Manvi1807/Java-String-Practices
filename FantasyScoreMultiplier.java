import java.util.Arrays;
import java.util.Scanner;

public class FantasyScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null || captainIndex < 0 || captainIndex >= playerScores.length 
                || viceCaptainIndex < 0 || viceCaptainIndex >= playerScores.length) {
            return;
        }

        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalPlayers = scanner.nextInt();
            double[] scores = new double[totalPlayers];
            for (int i = 0; i < totalPlayers; i++) {
                scores[i] = scanner.nextDouble();
            }

            int captainIndex = scanner.nextInt();
            int viceCaptainIndex = scanner.nextInt();

            applyMultipliers(scores, captainIndex, viceCaptainIndex);
            System.out.println(Arrays.toString(scores));
        } catch (Exception e) {
            System.out.println("Error processing player scores: " + e.getMessage());
        }
    }
}