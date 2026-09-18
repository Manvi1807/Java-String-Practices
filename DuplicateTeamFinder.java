import java.util.Scanner;

public class DuplicateTeamFinder {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length < 2) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i] != null && teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int totalTeams = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String[] teamNames = new String[totalTeams];
            for (int i = 0; i < totalTeams; i++) {
                teamNames[i] = scanner.nextLine().trim();
            }

            String resultMessage = findDuplicateTeam(teamNames);
            System.out.println(resultMessage);
        } catch (Exception e) {
            System.out.println("Error checking duplicate team names: " + e.getMessage());
        }
    }
}