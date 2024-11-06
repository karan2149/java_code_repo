package Arrays;

import java.util.*;

/*
 * Program is to reverse the array element from a given index/position
 * e.g i/p- javaprograming 11 then o/p javaprogramgni
 * Time Complexity - Big O(n) 
 * @Author - Karan Kumar
 */
public class ReverseTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the number of test cases");
        // int testCases=sc.nextInt();
        System.out.println("Enter the size of array and index from where you want to reverse");
        int size = sc.nextInt();
        int index = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("enter the elements of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int end = arr.length - 1;
        for (int i = index + 1; i < end; i++, end--) {
            int temp = arr[i];
            arr[i] = arr[end];
            arr[end] = temp;
        }
        for (int i : arr) {
            System.out.println(" " + i);
        }

    }
}
