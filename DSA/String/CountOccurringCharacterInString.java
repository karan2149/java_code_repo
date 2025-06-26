package String;

import java.util.*;
import java.util.stream.Collectors;

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
