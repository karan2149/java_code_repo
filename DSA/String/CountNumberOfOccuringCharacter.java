package String;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountNumberOfOccuringCharacter {

    public static void main(String[] args) {
        String input = "my name is karan";
        String str = input.replaceAll(" ", "");

        /*
         * Using Java 8
         */
        Map<Character, Long> map1 = str.chars() // Converting string to IntStream of chars
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Using Java 8: " + map1); // Groupby Character and Count
        System.out.println("-------------------------------------------------------");

        /*
         * Using Traditional Approach
         */
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) { // O(n)
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println("Traditional: " + map);
        System.out.println("------------------------------ \nDuplicates Only:");
        for (Character keyString : map.keySet()) {
            if (map.get(keyString) > 1) { // With this we can have the duplicate character only
                System.out.println(keyString + " = " + map.get(keyString));
            }
        }
    }
}
