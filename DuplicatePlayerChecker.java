import java.util.Scanner;

public class DuplicatePlayerChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i] != null && playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalPlayers = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String[] playerNames = new String[totalPlayers];
            for (int i = 0; i < totalPlayers; i++) {
                playerNames[i] = scanner.nextLine().trim();
            }

            String result = findDuplicatePick(playerNames);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error checking duplicate picks: " + e.getMessage());
        }
    }
}