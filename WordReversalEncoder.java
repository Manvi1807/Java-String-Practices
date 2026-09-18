import java.util.Scanner;

public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        String[] wordsArray = sentence.split(" ");
        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 0; i < wordsArray.length; i++) {
            StringBuilder wordBuilder = new StringBuilder(wordsArray[i]);
            outputBuilder.append(wordBuilder.reverse());

            if (i < wordsArray.length - 1) {
                outputBuilder.append(" ");
            }
        }

        return outputBuilder.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputSentence = scanner.nextLine();
            String reversedOutput = reverseEachWord(inputSentence);
            System.out.println(reversedOutput);
        } catch (Exception e) {
            System.out.println("Error processing input: " + e.getMessage());
        }
    }
}