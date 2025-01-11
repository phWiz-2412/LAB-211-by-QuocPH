import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Scanner;

public class LetterCharacterCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your content: ");
        String input = scanner.nextLine();

        Map<String, Integer> wordCount = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowerChar = Character.toLowerCase(c);
                charCount.put(lowerChar, charCount.getOrDefault(lowerChar, 0) + 1);
            }
        }

        System.out.println(wordCount);
        System.out.println(charCount);
    }
}
