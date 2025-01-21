package rahul;// Calculation of GCD and LCM using Euclid's algorithm

import java.util.Scanner;

public class LcmAndGcd {

    //modified by Gabriel lamme
    public static int gcd(int a, int b) {
        int r;
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int gcd2(int a, int b) {
        int min, max;
        if (a > b) {
            min = b;
            max = a;
        } else {
            min = a;
            max = b;
        }
        if (max % min == 0) return min;
        for (int i = min / 2; i > 0; i--) {
            if (max % i == 0 && min % i == 0) return i;
        }
        return 1;

    }

    private static int gcd1(int a, int b) {
        if (b == 0) return a;
        return gcd1(b, a % b);
    }

    private static int lcm(int a, int b) {
        int g = gcd(a, b);
        return (a * b) / g;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;
        System.out.println("Enter the two numbers ");
        a = scan.nextInt();
        b = scan.nextInt();
//        System.out.println(lcm(a,b));
        System.out.println(gcd2(a, b));
    }
}