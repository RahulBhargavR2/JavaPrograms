package rahul;

import java.util.Scanner;

public class MaxScore {
    static Scanner scan = new Scanner(System.in);
    private static int count(int n){
        int zero =0,one = 0;
        int si = scan.nextInt();
//            int[] arr = new int[si];
        for (int i =0;i<si;i++) {
            if(scan.nextInt() == 0) zero++;
            else one++;
        }
        if (one == si) return 0;
        if (zero == one) return one;
        return Math.min(one, zero);


    }
    public static void main(String[] args) {

        int n = scan.nextInt();
        while (n-->0){
            int si = scan.nextInt();
            System.out.println(count(si));
        }
    }
}
