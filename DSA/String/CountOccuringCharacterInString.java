package String;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.*;

public class CountOccuringCharacterInString {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String input = "my name is karan";
        String str = input.replaceAll(" ", "");
        System.out.println(
                "Choose from below option \n1.Count Occurering Character in String \n2.Count Occuring Word in String");

        int option = sc.nextInt();
        switch (option) {
            case 1:
                countOccuringCharacterInString(str);
                break;
            case 2:
                countOccuringWord(input);
                break;
            default:
                break;
        }

    }

    private static void countOccuringCharacterInString(String str) {
        /*
         * Using Java 8
         */
        System.out.println("given string : "+str);
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

    public static void countOccuringWord(String str) {
        System.out.println("-----------------------------------------------");
        System.out.println(str);
        HashMap<String, Integer> map = new HashMap<>();

        String[] strArray = str.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            String string = strArray[i];
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }
        System.out.println(map);
    }
}
