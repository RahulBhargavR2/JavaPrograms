package rahul;

import java.util.*;

public class PrimeFactorsFast {
    static final int MAX = 1000001;

    static int[] spf = new int[MAX];

    private static void sieve() {
        spf[0] = 0;
        spf[1] = 1;
        for (int i = 2; i < MAX; i++) {
            // marking the smallest prime factor for every
            // number to be 1.
            spf[i] = 1;
        }
        for (int i = 2; i < MAX; i++) {
            if (spf[i] == 1) { // if the number is prime ,mark
                // all its multiples who haven't
                // gotten their spf yet
                for (int j = i; j < MAX; j += i) {
                    spf[j] = i;// if its smallest prime factor is
                    // 1 means its spf hasn't been
                    // found yet so change its spf to i
                }
            }
        }

    }


    static List<Integer> getFactorization(int x) {
        List<Integer> ret = new LinkedList<>();
        while (x != 1) {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }

    private static List<Integer> primeFactorization(int n){
        List<Integer> prime = new LinkedList<>();
        for(int i=2;i*i<=n;i++){
            while (n%i == 0){
                prime.add(i);
                 n = n/i;
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        sieve();
//        int n = scan.nextInt();
//        while(n-->0){
//            int num = scan.nextInt();
//            System.out.println(getFactorization(num));
//        }

    }

}
