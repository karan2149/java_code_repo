package WBACodingQuestion;

import java.util.*;

/*
Step 1: [10, 20, 7]  → max=20 → 20/2=10 → [10, 10, 7]
Step 2: [10, 10, 7]  → max=10 → 10/2=5  → [5, 10, 7]
Step 3: [5, 10, 7]   → max=10 → 10/2=5  → [5, 5, 7]
Step 4: [5, 5, 7]    → max=7  → 7/2=4   → [5, 5, 4]

Sum = 5+5+4 = 14 ✓
 */

public class MinimumSum {

    public static long minimumSum(int[] nums, int k) {

        // Edge case: null or empty array
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Max heap — largest element always at top
        // Collections.reverseOrder() makes PriorityQueue a max heap
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        // Add all elements to max heap
        for (int num : nums) {
            maxHeap.offer(num);
        }

        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Step 1: Remove largest element
            int largest = maxHeap.poll();

            // Step 2 & 3: Divide by 2 and take ceiling
            // ceiling(x/2) = (x+1)/2  for integers
            int reduced = (largest + 1) / 2;

            // Step 4: Put back reduced value
            maxHeap.offer(reduced);
        }

        // Sum all remaining elements
        // Use long to avoid integer overflow
        long sum = 0;
        for (int num : maxHeap) {
            sum += num;
        }

        return sum;
    
    //Second Approach
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b.compareTo(a));
    //     for(int i=0;i<n;i++){
    //         pq.add(sc.nextInt());
    //     }
    //     int k = sc.nextInt();

    //     for(int i=0;i<k;i++){
    //         if(pq.isEmpty()) break;

    //         int remove = pq.poll();
    //         pq.add((remove+1)/2);
    //     }
    //     System.out.println(pq.stream().mapToInt(Integer::intValue).sum());
    // }
    
    
    }

    public static void main(String[] args) {

        // Example 1
        System.out.println(minimumSum(new int[]{10, 20, 7}, 4));
        // → 14

        // Example 2
        System.out.println(minimumSum(new int[]{2, 3}, 1));
        // → 4

        // Edge case: k=0 no operations
        System.out.println(minimumSum(new int[]{10, 20, 7}, 0));
        // → 37

        // Edge case: single element
        System.out.println(minimumSum(new int[]{8}, 3));
        // → 1  (8→4→2→1)

        // Edge case: all same elements
        System.out.println(minimumSum(new int[]{4, 4, 4}, 3));
        // → 6  (4→2, 4→2, 4→2)

        // Edge case: large k — element reduces to 1 eventually
        System.out.println(minimumSum(new int[]{1, 1, 1}, 5));
        // → 3  (1 ceiling divided stays 1 forever)

        // Edge case: null input
        System.out.println(minimumSum(null, 3));
        // → 0
    }
}
