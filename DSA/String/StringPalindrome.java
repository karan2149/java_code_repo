package String;

import java.util.HashSet;
import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        //print each letter twice
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        String str=sc.nextLine();
               
        //------------------String is palindrome or not --
        boolean flag=true;
        int start=0,end=str.length()-1;
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                flag=false; 
            }
            start++;
            end-- ;
        }
        if(flag){
            System.out.println("given string is Palindrome");
        }
        else{
            System.out.println("given string is not Palindrome");
  
        }
    }
}               

