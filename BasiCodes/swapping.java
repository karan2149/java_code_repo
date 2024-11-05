package BasiCodes;

import java.util.*;

/*
 * This program include swapping of two numbers and 
 * two string as well with or without using third variable
 */
public class swapping {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        swappingOfTwoNumbers();
    }

    public static void swappingOfTwoNumbers() {
        System.out.println("Enter the two number followed by enter");
        int num1 = sc.nextInt(); // 2
        int num2 = sc.nextInt(); // 3

        // without thrid variable
        System.out.println("Before swapping " + "num1: " + num1 + " and num2: " + num2);
        num1 = num1 + num2; // 5
        num2 = num1 - num2; // 5-3 = 2
        num1 = num1 - num2;

        System.out.println("After swapping " + "num1: " + num1 + " and num2: " + num2);

        // Using third variable
        // int temp=num2 ;
        // num2=num1;
        // num1=temp;

    }

}
