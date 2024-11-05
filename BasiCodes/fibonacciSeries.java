package BasiCodes;
import java.util.* ;
/*
 * Program for fibonacci series upto given range.
 */
public class fibonacciSeries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the range ");
        int range=sc.nextInt();
        int first=0,second=1,next;
        for(int i=1;i<=range;i++){
            System.out.print(first+" ");
                next=first+second;
                first=second ;
                second=next;
        }
    }
}
