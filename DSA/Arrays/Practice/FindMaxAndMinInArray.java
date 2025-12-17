package Arrays.Practice;
import java.util.* ;
/*
Finding maximum and minimum values for an array 
Following the iteration approach 
Time Complexity = O(N) since for loop is iterate N times 
*/


public class FindMaxAndMinInArray {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the size of an array : " );
            int N=sc.nextInt();
            int[] arr=new int[N];

            //taking entries in the array 
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }

            //printing the array 
            System.out.println("Printin the taken input array");
            for(int i=0;i<N;i++){
                System.out.println(arr[i]);
            }

            //finding the max and minimum in the array 
            int max=arr[0];
            int min=arr[0];

            for(int i=1;i<N;i++){   //Time Complexity O(N)
                if(max<arr[i]){
                    max=arr[i];
                }
                if(min>arr[i]){
                    min=arr[i];
                }
            }
            System.out.println("Max: "+max);
            System.out.println("Min: "+min);
    }   
}
