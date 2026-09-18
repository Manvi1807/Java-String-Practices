import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10.0) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order sort by composite score
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementDriveEngine {

    public static boolean isEligible(double cgpa) {
        // CGPA-only quick filter (Direct qualification threshold = 7.5)
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        // Combined CGPA and coding score filter for borderline cases
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        if (candidates == null || candidates.length == 0) {
            return "";
        }

        List<Candidate> shortlistedList = new ArrayList<>();

        for (Candidate candidate : candidates) {
            if (candidate == null) continue;

            if (isEligible(candidate.getCgpa()) || isEligible(candidate.getCgpa(), candidate.getCodingScore())) {
                shortlistedList.add(candidate);
            }
        }

        Candidate[] shortlistedArray = shortlistedList.toArray(new Candidate[0]);
        Arrays.sort(shortlistedArray);

        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < shortlistedArray.length; i++) {
            Candidate candidate = shortlistedArray[i];
            outputBuilder.append(i + 1)
                         .append(". ")
                         .append(candidate.getName())
                         .append(" (")
                         .append(candidate.getCompositeScore())
                         .append(")");

            if (i < shortlistedArray.length - 1) {
                outputBuilder.append(" | ");
            }
        }

        return outputBuilder.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int candidateCount = scanner.nextInt();
            scanner.nextLine(); // Consume remaining newline

            Candidate[] candidatesArray = new Candidate[candidateCount];

            for (int i = 0; i < candidateCount; i++) {
                String name = scanner.next();
                double cgpa = scanner.nextDouble();
                int codingScore = scanner.nextInt();
                candidatesArray[i] = new Candidate(name, cgpa, codingScore);
            }

            String leaderboard = shortlistAndRank(candidatesArray);
            System.out.println(leaderboard);
        } catch (Exception e) {
            System.out.println("Error processing placement drive ranking: " + e.getMessage());
        }
    }
}