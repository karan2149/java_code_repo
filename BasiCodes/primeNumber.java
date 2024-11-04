package BasiCodes;

import java.util.*;

public class primeNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // finding the prime number
        System.out.println("Choose option : \n 1.check a number is prime or not. \n 2.Find Prime Number till Nth term");

        int option = sc.nextInt();
        switch (option) {
            case 1:
                checkPrimeNuber();
                break;
            case 2:
                checkPrimeNuberJava8();
            default:
                break;
        }

    }

    public static void checkPrimeNuberJava8() {
        System.out.println("Enter the Nth term to find the prime numbers ");
        int n = sc.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < x.length; i++) {
            x[i] = i + 1;
        }
        for (int i : x) {
            System.out.print(i + " \t");
        }
        System.out.println();
        isPrime(x);

    }

    public static void isPrime(int x[]) {
        for (int i = 0; i < x.length; i++) {
            boolean isPrime = true;
            if (x[i] < 2) {
                continue;
            }
            for (int j = 2; j < x[i]; j++) {
                if (x[i] % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(x[i] + "\t");
            }
        }

    }

    private static void checkPrimeNuber() {
        System.out.println("Enter the number to check");
        int number = sc.nextInt();
        boolean flag = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("The number is prime");
        } else
            System.out.println("The number is not prime");
    }
}
