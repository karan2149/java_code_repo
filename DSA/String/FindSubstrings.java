package String;


/**
 * Approach (How You Should Explain It)
 * 🎤 What You Say to the Interviewer:
 *
 * "To generate all substrings, I use two nested loops.
 * The outer loop picks the start index, and the inner loop picks the end index.
 * For each pair (i, j), I extract the substring using s.substring(i, j).
 * This ensures we capture all contiguous substrings."
 *
 * ✅ 3. Time & Space Complexity
 * 🎤 Say This:
 *
 * The total number of substrings is n(n+1)/2 → O(n²)
 *
 * Each substring extraction takes O(k) time (because Java Strings are immutable)
 *
 * So total time complexity is:
 *
 * 𝑂 * (  𝑛 3 )
 * If storing substrings in a list, space complexity is O(n²)
 *
 * If only printing them, space complexity is O(1)
 */

public class FindSubstrings {
    public static void main(String[] args) {
        String input = "abc";

        System.out.println("All substrings of \"" + input + "\":");
        printAllSubstrings(input);
    }

    public static void printAllSubstrings(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(s.substring(i, j));  // O(n) per substring
            }
        }
    }

    /**
     * Using Java 8
     */

//    String input = "abc";
//
//        System.out.println("All substrings using Java 8:");
//        IntStream.range(0, input.length())
//                .forEach(i ->
//            IntStream.rangeClosed(i + 1, input.length())
//            .mapToObj(j -> input.substring(i, j))
//            .forEach(System.out::println)
//                 );


}
