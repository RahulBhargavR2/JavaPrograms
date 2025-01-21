package DynamicProgramming;

import java.math.BigInteger;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Fibonacci {
    private static BigInteger[] cache;

    private static BigInteger fibonacci(int n) {
        if (n == 1 || n == 0)
            return BigInteger.valueOf(n);
        if (cache[n] != null)
            return cache[n];
        BigInteger NthFibonacci = fibonacci(n - 1).add(fibonacci(n - 2));
        cache[n] = NthFibonacci;
        return NthFibonacci;
    }
    private static long fib(long n){
        return fib(n,new HashMap<>());
    }

    private static long fib(long n, HashMap<Long, Long> hm){
        if (n == 0 || n == 1) return n;
        if (hm.containsKey(n)) return hm.get(n);

        long temp =  fib(n-1, hm) + fib(n-2, hm);
        hm.put(n,temp);
        return temp;
    }
    public static void main(String[] args) {
    }
}