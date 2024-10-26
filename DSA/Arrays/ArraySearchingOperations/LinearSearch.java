package Arrays.ArraySearchingOperations;
import java.util.*;
public class LinearSearch {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        int array[]={1,2,3,4,5,10,12};
        linearSearch(sc, array);


    }

    private static void linearSearch(Scanner sc, int[] array) {
        System.out.println("Enter the target Number : ");
        int target=sc.nextInt();

        //Linear Search  , Time Complexity = Big O(1) if found at first and Big O(n) when value is lies at the end;
        for(int i=0;i<array.length;i++){
            if(array[i]==target){
                System.out.println("Target number is found at index : "+i);
            }
        }
    }
}
