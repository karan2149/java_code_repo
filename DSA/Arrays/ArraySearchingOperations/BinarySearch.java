package Arrays.ArraySearchingOperations;
import java.util.*;

/*
 * Binary Search is an algorithm or searching technique 
 * that finds the position of a target value within 
 * sorted array.
 * 
 * Steps to follow 
 */
public class BinarySearch {
   static Scanner sc=new Scanner(System.in);

   private static int binarySearch(int[] array) {
   System.out.println("Enter the target Number ");
  int low=0;
  int high=array.length-1;
  int target=sc.nextInt();
  int size=array.length;
  
  while(low<=high){
    //find mid point :  mid index=lowIndex+((highIndex-lowIndex)/2)
    int midPoint=low+(high-low)/2 ;
    if(array[midPoint]==target){
      return midPoint;
    }
    if(target<array[midPoint]){
      high=midPoint-1;
        }
        if (target>array[midPoint]) {
          low=midPoint+1;
        }
  }
  return -1 ;
  }
  

 public static void main(String[] args) {
    int array[]={1,4,8,7,5,52,25};
   //sort the array
   Arrays.sort(array);
   //sortingTheArray(array);
   System.out.println("Array:");
   traversing(array);
 System.out.println();
   int binarySearch = binarySearch(array);
   System.out.println("found at index: "+binarySearch);   

 }  
 
 
public static void sortingTheArray(int array[]){
  for(int i=0;i<array.length;i++){
   for(int j=0;j<array.length-1;j++)
   if(array[j]>array[j+1]){
         int temp=array[j+1];
         array[j+1]=array[j];
         array[j]=temp;
   }
  }
 }
 public static void traversing(int[] array){
   for (int i : array) {
      System.out.print(i+"\t");
   }
 }
}
