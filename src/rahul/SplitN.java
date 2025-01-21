package rahul;

import java.util.Scanner;

public class SplitN {
    /**<a href="https://www.codechef.com/problems/SPLITN">SplitN code chef</a><br>
     * <a href="https://www.geeksforgeeks.org/highest-power-2-less-equal-given-number/">GFG nearest power of 2</a>
     * */
    private static int nearPowerOf2(int x) {
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        return x ^ (x >> 1);
    }

    private static int check(int n) {
        if (n == 1 || (n & (n - 1)) == 0) return 0;
        int i = nearPowerOf2(n);
        return check(n-i)+1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int num = scan.nextInt();
            System.out.println(check(num));
        }
    }
}
