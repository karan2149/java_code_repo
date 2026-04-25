package WBACodingQuestion;

import java.util.*;
/*
a="1234", b="2341"

Similar check:
  a: 1→1, 2→1, 3→1, 4→1
  b: 2→1, 3→1, 4→1, 1→1
  Same frequencies → SIMILAR → count permutations of a

Count "1234":
  n=4, all digits appear once
  Total = 4! / (1!×1!×1!×1!) = 24
  No zeros → no subtraction
  Answer = 24 ✓
Walkthrough Example 2
a="1234", b="1213"

Similar check:
  a: 1→1, 2→1, 3→1, 4→1
  b: 1→2, 2→1, 3→1
  Different → NOT SIMILAR → count permutations of b

Count "1213":
  n=4, digit 1 appears twice
  Total = 4! / 2! = 24/2 = 12
  No zeros → no subtraction
  Answer = 12 ✓

*/
public class SimilarNumbers {

    // Precompute factorial up to 15 (max length)
    static long[] fact = new long[20];

    static {
        fact[0] = 1;
        for (int i = 1; i < 20; i++) {
            fact[i] = i * fact[i - 1];
        }
    }

    public static long countWays(String s) {
        int n = s.length();

        // Step 1: Count frequency of digits
        int[] freq = new int[10];
        for (char ch : s.toCharArray()) {
            freq[ch - '0']++;
        }

        // Step 2: Total permutations (with duplicates)
        long total = fact[n];
        for (int f : freq) {
            total /= fact[f];
        }

        // Step 3: Handle leading zero
        if (freq[0] > 0) {
            // Fix '0' at first position
            freq[0]--;

            long invalid = fact[n - 1];
            for (int f : freq) {
                invalid /= fact[f];
            }

            total -= invalid;
        }

        return total;
    }

    public static boolean isSimilar(String a, String b) {
        int[] f1 = new int[10];
        int[] f2 = new int[10];

        for (char ch : a.toCharArray()) f1[ch - '0']++;
        for (char ch : b.toCharArray()) f2[ch - '0']++;

        return Arrays.equals(f1, f2);
    }

    public static long solve(String a, String b) {
        if (isSimilar(a, b)) {
            return countWays(a);
        } else {
            return countWays(b);
        }
    }

    public static void main(String[] args) {
        String a = "1234";
        String b = "2341";

        System.out.println(solve(a, b)); // 24

        String a2 = "1234";
        String b2 = "1213";

        System.out.println(solve(a2, b2)); // 12
    }
}
