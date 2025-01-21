/* Modified Fibonacci
* given by Eg 5 digit
* 0 1
* third digit 0+1^2=1
* 0 1 1
* fourth digit 1+1^2=2
* 0 1 1 2
* fifth digit 1+2^2=5
* 0 1 1 2 5 etc
* */
import java.math.BigInteger;
import java.util.Scanner;

public class Modified_Fibonacci {
    static BigInteger[]cache;
    private static BigInteger fibonacci(int n) {
        if(n==0)
            return BigInteger.ZERO;
        if(n==1 || n==2)
            return BigInteger.ONE;
        if(cache[n]!=null)
            return cache[n];
        BigInteger NthFibonacci= fibonacci(n-1).multiply(fibonacci(n-1)).add( fibonacci(n-2));
        cache[n]=NthFibonacci;
        return NthFibonacci;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int i=scan.nextInt();
        cache=new BigInteger[i+2];
        for (int j=0;j<i;j++)
            System.out.println(fibonacci(j+1));
    }
}


