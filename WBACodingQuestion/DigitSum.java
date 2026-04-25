package WBACodingQuestion;
import java.util.*;

public class DigitSum {

    // Count numbers <= N with given digit sum
    static Map<String, Long> memo = new HashMap<>();

    static long countWays(String num, int pos, int sum, boolean tight) {
        if (sum < 0) return 0;

        if (pos == num.length()) {
            return sum == 0 ? 1 : 0;
        }

        String key = pos + "|" + sum + "|" + tight;
        if (!tight && memo.containsKey(key)) {
            return memo.get(key);
        }

        int limit = tight ? num.charAt(pos) - '0' : 9;
        long res = 0;

        for (int d = 0; d <= limit; d++) {
            res += countWays(num, pos + 1, sum - d, tight && (d == limit));
        }

        if (!tight) memo.put(key, res);

        return res;
    }

    // Count numbers in range [0, num] for each digit sum
    static Map<Integer, Long> getFrequency(String num) {
        Map<Integer, Long> freq = new HashMap<>();

        int maxSum = 9 * num.length();

        for (int s = 0; s <= maxSum; s++) {
            memo.clear();
            long count = countWays(num, 0, s, true);
            if (count > 0) {
                freq.put(s, count);
            }
        }

        return freq;
    }

    // subtract freq maps: high - low
    static Map<Integer, Long> subtract(Map<Integer, Long> high, Map<Integer, Long> low) {
        Map<Integer, Long> res = new HashMap<>();

        for (int key : high.keySet()) {
            long val = high.getOrDefault(key, 0L) - low.getOrDefault(key, 0L);
            if (val > 0) res.put(key, val);
        }

        return res;
    }

    public static long[] solve(long lowLimit, long highLimit) {

        Map<Integer, Long> highMap = getFrequency(String.valueOf(highLimit));
        Map<Integer, Long> lowMap = getFrequency(String.valueOf(lowLimit - 1));

        Map<Integer, Long> freq = subtract(highMap, lowMap);

        long max = 0;
        int count = 0;

        for (long val : freq.values()) {
            if (val > max) {
                max = val;
                count = 1;
            } else if (val == max) {
                count++;
            }
        }

        return new long[]{count, max};
    }

    public static void main(String[] args) {
        long low = 1, high = 12;
        long[] ans = solve(low, high);

        System.out.println(Arrays.toString(ans)); // [3, 2]
    }
}



/*
PS: Ticket 1  → digits: 1         → sum = 1   → coupon code = 1
Ticket 2  → digits: 2         → sum = 2   → coupon code = 2
Ticket 3  → digits: 3         → sum = 3   → coupon code = 3
Ticket 4  → digits: 4         → sum = 4   → coupon code = 4
Ticket 5  → digits: 5         → sum = 5   → coupon code = 5
Ticket 6  → digits: 6         → sum = 6   → coupon code = 6
Ticket 7  → digits: 7         → sum = 7   → coupon code = 7
Ticket 8  → digits: 8         → sum = 8   → coupon code = 8
Ticket 9  → digits: 9         → sum = 9   → coupon code = 9
Ticket 10 → digits: 1, 0      → sum = 1   → coupon code = 1
Ticket 11 → digits: 1, 1      → sum = 2   → coupon code = 2
Ticket 12 → digits: 1, 2      → sum = 3   → coupon code = 3

Coupon Code │ Tickets in this group    │ Count
────────────┼──────────────────────────┼──────
     1      │  Ticket 1,  Ticket 10    │  2
     2      │  Ticket 2,  Ticket 11    │  2
     3      │  Ticket 3,  Ticket 12    │  2
     4      │  Ticket 4               │  1
     5      │  Ticket 5               │  1
     6      │  Ticket 6               │  1
     7      │  Ticket 7               │  1
     8      │  Ticket 8               │  1
     9      │  Ticket 9               │  1

[number of codes with max, maximum winners]
         ↓                       ↓
        [3,                      2]
        
        
*/
