package Arrays.Practice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * "I handled edge cases like null/empty input, extra spaces, and made the string case-insensitive.
 * I used both Java 8 Streams and traditional HashMaps to showcase modern and classic Java skills.
 * Time complexity is O(n), where n is the number of characters or words.
 * Space is O(k), where k is the number of unique characters or words."
 */

/**
 * "I chose LinkedHashMap because it maintains insertion order, which makes the character or word count output easier to understand and more aligned with the input string.
 * It’s especially helpful when the interviewer or user wants to see results in the same order they appear in the string."
 */

public class CountOccurringCharacterInString {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the input string:");
        String input = sc.nextLine();

        if (input == null || input.trim().isEmpty()) {
            System.out.println("⚠️ Input string is empty or null.");
            return;
        }

        input = input.trim().toLowerCase(); // Normalize case
        String cleanString = input.replaceAll("\\s+", ""); // Remove spaces for character count

        System.out.println("\nChoose an option:\n1. Count Occurring Characters\n2. Count Occurring Words");
        int option = sc.nextInt();
        sc.nextLine(); // Clear scanner buffer

        switch (option) {
            case 1:
                countCharacters(cleanString);
                break;
            case 2:
                countWords(input);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void countCharacters(String str) {
        System.out.println("\n🧵 Counting Characters in: \"" + str + "\"");

        // ✅ Java 8 Stream Approach
        Map<Character, Long> charCountJava8 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));
        System.out.println("\n🔹 Java 8 Count:");
        System.out.println(charCountJava8);

        // ✅ Traditional HashMap Approach
        Map<Character, Integer> charCountTraditional = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCountTraditional.put(c, charCountTraditional.getOrDefault(c, 0) + 1);
        }

        System.out.println("\n🔸 Traditional Count:");
        System.out.println(charCountTraditional);

        System.out.println("\n📌 Duplicate Characters:");
        charCountTraditional.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }

    private static void countWords(String input) {
        System.out.println("\n🧵 Counting Words in: \"" + input + "\"");

        String[] words = input.trim().split("\\s+");
        if (words.length == 0) {
            System.out.println("No words to count.");
            return;
        }

        // ✅ Traditional HashMap Word Count
        Map<String, Integer> wordCount = new LinkedHashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("\n🔹 Word Count:");
        System.out.println(wordCount);

        System.out.println("\n📌 Duplicate Words:");
        wordCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(entry.getKey() + " = " + entry.getValue()));
    }
}
