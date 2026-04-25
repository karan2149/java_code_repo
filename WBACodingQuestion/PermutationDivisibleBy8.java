package WBACodingQuestion;

import java.util.*;

public class PermutationDivisibleBy8 {

    public static String check(String s) {
        int n = s.length();

        // Case 1: length 1
        if (n == 1) {
            int num = s.charAt(0) - '0';
            return (num % 8 == 0) ? "YES" : "NO";
        }

        // Case 2: length 2
        if (n == 2) {
            int a = Integer.parseInt(s);
            int b = Integer.parseInt("" + s.charAt(1) + s.charAt(0));

            if (a % 8 == 0 || b % 8 == 0) return "YES";
            return "NO";
        }

        // Case 3: length >= 3
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }

        // Check all 3-digit multiples of 8
        for (int i = 0; i < 1000; i += 8) {
            int[] temp = new int[10];

            int num = i;

            // Extract digits (handle leading zeros like 008)
            temp[num % 10]++;
            num /= 10;
            temp[num % 10]++;
            num /= 10;
            temp[num % 10]++;

            // Check if possible
            boolean possible = true;
            for (int d = 0; d < 10; d++) {
                if (temp[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) return "YES";
        }

        return "NO";
    }

    public static List<String> checkDivisibility(List<String> arr) {
        List<String> result = new ArrayList<>();

        for (String s : arr) {
            result.add(check(s));
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> arr = Arrays.asList("61", "75");
        List<String> ans = checkDivisibility(arr);

        for (String s : ans) {
            System.out.println(s);
        }
    }
}

/*
Given a number string:
→ Try ALL possible arrangements of its digits
→ Check if ANY arrangement is divisible by 8
→ If yes → "YES", otherwise → "NO"

Key Math Insight — Divisibility by 8
A number is divisible by 8 if and only if
its LAST 3 DIGITS are divisible by 8

Example:
  123456312 → last 3 digits = 312
  312 / 8 = 39 remainder 0 → divisible by 8 ✓

Why? Because 1000 is divisible by 8
  any number = (first digits × 1000) + last 3 digits
  1000 % 8 = 0
  so only last 3 digits matter
*/

