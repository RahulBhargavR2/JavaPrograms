package rahul;

import java.math.BigInteger;
@SuppressWarnings("unused")
public class Factorial {
    public static int factorial(int n){
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    private  int fact(int n){
        if (n == 0 || n == 1) return 1;
        else return n * fact(n-1);
    }

    private static BigInteger fact2(int n){
        if (n == 0 || n == 1) return BigInteger.ONE;
        else return BigInteger.valueOf(n).multiply(fact2(n-1));
    }
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println(fact2(26));
    }
}
