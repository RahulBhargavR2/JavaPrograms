package rahul;//Modified fibonacci whose starting 2 numbers of the series are given
import java.math.BigInteger;
import java.util.Scanner;

public class ModFib {
    static BigInteger[]cache;
    private static BigInteger fibonacci(int n,int q,int w) {
        cache[0]=BigInteger.valueOf(q);
        cache[1]=BigInteger.valueOf(w);
        if(cache[n]!=null)
            return cache[n];
        BigInteger NthFibonacci= fibonacci(n-1,q,w).multiply(fibonacci(n-1,q,w)).add( fibonacci(n-2,q,w));
        cache[n]=NthFibonacci;
        return NthFibonacci;
    }
    private static BigInteger fibonacci1(int n, int q, int w){
       BigInteger fib=BigInteger.ZERO,a=BigInteger.valueOf(q),b=BigInteger.valueOf(w);

        while(n--> 0){
            fib = a.add(b);
            a = b;
            b = fib;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the first and second elements of series");
        int q= scan.nextInt();
        int w= scan.nextInt();
        System.out.println("Enter the number to print n th element of the series");
        int i=scan.nextInt();
        cache=new BigInteger[i+2];

        System.out.println(fibonacci1(i,q,w));

    }
}