package Arrays;
/*
Given an array and will it K time in the clockwise direction
Time Complexity - O(N) and Space Complexity =  O(1)
*/

public class rotateTheArrayKTimes {
    public static void main(String[] args) {
        int[] a={-1,2,3,6,5,4,8};
        int k=3;
        int n=a.length;
        
        k = k % n; // important

        reverseIndex(0,n-1,a);
        reverseIndex(0,k-1,a);
        reverseIndex(k,n-1,a);

        //For Anticlockwise
        // reverseIndex(0, k - 1, a);   // reverse first k
        // reverseIndex(k, n - 1, a);   // reverse rest
        // reverseIndex(0, n - 1, a);   // reverse whole array


        for(int element:a){
            System.out.print(" "+element);
        } 
    }
      public static void reverseIndex(int start,int end ,int[] array){
            for (int i=start; i < end; i++, end--) {
            int temp = array[i];
            array[i] = array[end];
            array[end] = temp;
        }
        }
    
}
