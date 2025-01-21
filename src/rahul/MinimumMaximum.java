 package rahul;

import java.util.Scanner;

public class MinimumMaximum {
    private static long minimum(long n){
        //all no fro, 1 to mid of n repeats twice for even
        //for odd mid of n repeats only once
        long dup = n;
        n = (n+1)/2;
        long sum = n*(n+1);
        if (dup % 2 == 0) return sum;
        return sum-n;
    }

    private static long maximum(long n){
        // eg 5
        // 1 2 3 4 5
        //max(1,2)+max(2,3)+max(3,4)+max(4,5)+max(1,5) = 2+3+4+5+5
        // everything remains same need to sum form 2 to n then add n
//        long ans = n*(n+1)/2;
//        ans -= 1;
//        ans += n;
        return (n*(n+1)/2)-n-1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            long a = scan.nextLong();
            System.out.println(maximum(a));
        }
    }
}
