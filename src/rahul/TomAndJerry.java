package rahul;

import java.util.Scanner;

public class TomAndJerry {
    private String checker(int a, int b, int c, int d, int k) {
        int aShifting = Math.abs(a - c);
        int bShifting = Math.abs(b - d);
        int sum = aShifting + bShifting;
        int remaining = k - sum;
        if (remaining < 0) return "NO";
        if (remaining % 2 == 0) return "YES";
        return "NO";

    }
    /*
    private boolean checker(int a, int b, int c, int d, int k){
        int remaining = k - Math.abs(a-c)+  Math.abs(b-d);
        return  remaining < 0 && remaining % 2 ==0;
    }
    */

    public static void main(String[] args) {
        TomAndJerry t = new TomAndJerry();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            int k = scan.nextInt();
            System.out.println(t.checker(a, b, c, d, k));
        }
    }
}
