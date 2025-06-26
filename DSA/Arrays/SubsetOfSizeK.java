package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * APPROACH FOR SUBSET K:
 * "I'm using a recursive backtracking approach.
 * I explore each element starting from a given index and try building a subset by including the current element.
 * If the subset reaches size k, I add it to the result.
 * Then I backtrack and try the next possible options.
 * <p>
 * Because I always advance the index, I avoid duplicates and ensure combinations are unique and in correct size.
 * The recursion stops early if a subset grows too large, making it efficient."
 * <p>
 * <p>
 * <p>
 * <p>
 * /** TIME COMPLEXITY: "Since we generate all size-k subsets, we make C(n, k) recursive calls.
 * where n= distinct integer and k = an Integer
 * For each subset, we copy it into the result — which takes O(k) time.
 * So the total time complexity is O(C(n, k) × k).
 * <p>
 * For SPACE COMPLEXITY, we store all the subsets in memory — each of size k, so that’s also O(C(n, k) × k).
 * The recursion stack uses up to O(k) space."
 **/

/**
 * APPROACH FOR ALL SUBSET
 *  * “I used a recursive backtracking approach to explore all subset possibilities.
 *  * At each index, I have two choices — include or exclude the current number.
 *  * This gives us 2ⁿ total combinations.
 *  * I add a copy of the current subset to the result each time.
 *  * TIME AND SPACE COMPLEXITY are both O(n × 2ⁿ) due to subset generation and storage.”
 *  * /
 */


public class SubsetOfSizeK {
    public static void main(String[] args) {
        //Input : array and size k
        int[] arr = {1, 2, 3};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of subset k= ");
        int k = sc.nextInt();
        List<List<Integer>> subsetOfSizeK = findSubsetOfSizeK(arr, k);
        System.out.println(subsetOfSizeK);
    }

    public static List<List<Integer>> findSubsetOfSizeK(int arr[], int k) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtrace(resultList, new ArrayList<>(), arr, 0, k);
        return resultList;
    }

    public static void backtrace(List<List<Integer>> resultSets, List<Integer> tempSet, int arr[], int start, int k) {
        // add the set to the result set
        //Here we take our result set and
        // start appending all of the subsets that we find one step at a time

        // Base case: if the subset is of size k, add it to result
        if (tempSet.size() == k) {
            resultSets.add(new ArrayList<>(tempSet));
            return;
        }

        /**
         *   /*  resultSets.add(new ArrayList<>(tempSet));
         *       THIS LINE IS USED WHEN WE JUST WANT THE SUBSETS
         *        */

        for (int i = start; i < arr.length; i++) {


            //Case for including the number
            tempSet.add(arr[i]);

            //Backtrack the new subset
            //again we were going back to look at the cases were we are not including the one
            backtrace(resultSets, tempSet, arr, i + 1, k);

            //Case of not including the number

            tempSet.remove(tempSet.size() - 1);


        }

        //Time complexity = O[n(2^n)]
        //Space complexity = O(n) - just taking up the stack space to store n elements

    }


}


