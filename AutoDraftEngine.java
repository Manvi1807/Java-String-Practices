import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    @Override
    public int compareTo(Player other) {
        // Descending order ranking based on batting average (fantasy points)
        return Double.compare(other.getBattingAverage(), this.getBattingAverage());
    }
}

public class AutoDraftEngine {

    public static boolean isDraftable(int matchesPlayed) {
        // Experience-only rule (Established threshold: 10 matches)
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        // Combined experience & fitness check for newer players
        return matchesPlayed >= 5 && !injured;
    }

    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "";
        }

        List<Player> draftableList = new ArrayList<>();

        for (Player player : players) {
            if (player == null) continue;

            if (isDraftable(player.getMatchesPlayed()) || isDraftable(player.getMatchesPlayed(), player.isInjured())) {
                draftableList.add(player);
            }
        }

        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder leaderboard = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            leaderboard.append(i + 1)
                       .append(". ")
                       .append(draftableArray[i].getName());

            if (i < draftableArray.length - 1) {
                leaderboard.append(" | ");
            }
        }

        return leaderboard.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int playerNum = scanner.nextInt();
            scanner.nextLine(); // Consume remaining newline

            Player[] players = new Player[playerNum];

            for (int i = 0; i < playerNum; i++) {
                String name = scanner.next();
                int matchesPlayed = scanner.nextInt();
                double battingAverage = scanner.nextDouble();
                boolean injured = scanner.nextBoolean();
                players[i] = new Player(name, matchesPlayed, battingAverage, injured);
            }

            String draftRankings = draftAndRank(players);
            System.out.println(draftRankings);
        } catch (Exception e) {
            System.out.println("Error processing auto-draft engine: " + e.getMessage());
        }
    }
}