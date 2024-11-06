package String;

import java.util.*;

/*
 * Reverse each word in a given String
 * @Author- Karan Kumar
 * Time complexity O(n*m)
 */
public class reverseEachWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String s = sc.nextLine();
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            String string = str[i];
            for (int j = string.length() - 1; j >= 0; j--) {
                System.out.print(string.charAt(j));
            }
            System.out.print(" ");
        }

    }
}
