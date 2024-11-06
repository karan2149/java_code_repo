package Arrays;

import java.util.*;

/*
 * Program is to search for the pairs which sum is equivalent to the provided input
 * e.g i/p- {1,2,3,4,5,6} i/p2 -5  then o/p (1,4) (2,3)
 * Time Complexity - Big O(n*m) 
 * @Author - Karan Kumar
 */
public class ArraySumCombinationPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of test cases");
        // int testCases=sc.nextInt();
        System.out.println("Enter the size of array and sum of pair you want");
        int size = sc.nextInt();
        int sum = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("enter the elements of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[i] + arr[j] == sum) {
                    System.out.println(arr[i] + " " + arr[j]);
                }

            }
        }
    }

}
