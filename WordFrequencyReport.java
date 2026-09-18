import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        Set<String> stopWordsSet = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "").replace("!", "").replace("?", "");
        String[] wordsArray = cleanedText.split("\\s+");

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : wordsArray) {
            if (!word.isEmpty() && !stopWordsSet.contains(word)) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordCountMap.entrySet());

        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String feedbackText = scanner.nextLine();
            printFilteredWordFrequency(feedbackText);
        } catch (Exception e) {
            System.out.println("Error generating report: " + e.getMessage());
        }
    }
}