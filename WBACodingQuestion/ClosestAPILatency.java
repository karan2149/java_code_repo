package WBACodingQuestion;
    import java.util.*;

//DONE-----------
/*
Unsorted: [6, 2, 4, 10]
Sorted:   [2, 4, 6, 10]

Differences between adjacent pairs:
  4-2 = 2
  6-4 = 2
  10-6 = 4

Minimum diff = 2
Pairs with diff 2 → [2,4] and [4,6]
Time Complexity O(nlogn)
*/
public class ClosestAPILatency {

    public static List<List<Integer>> closestPairs(int[] latencies) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: null or less than 2 elements — no pair possible
        if (latencies == null || latencies.length < 2) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(latencies);

        // Step 2: Find minimum difference among adjacent pairs
    
        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i < latencies.length - 1; i++) {
            long diff = (long) latencies[i + 1] - (long) latencies[i];
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        // Step 3: Collect all adjacent pairs matching minimum difference
        for (int i = 0; i < latencies.length - 1; i++) {
            long diff = (long) latencies[i + 1] - (long) latencies[i];
            if (diff == minDiff) {
                result.add(Arrays.asList(latencies[i], latencies[i + 1]));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Normal cases
        System.out.println(closestPairs(new int[]{6, 2, 4, 10}));
        // Expected: [[2,4],[4,6]]

        System.out.println(closestPairs(new int[]{4, -2, -1, 3}));
        // Expected: [[-2,-1],[3,4]]

    }
}

