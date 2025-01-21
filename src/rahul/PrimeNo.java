package rahul;

import java.io.IOException;
import java.util.Scanner;

public class PrimeNo {
    //according to mathematicians first factor lies at or before the square-root of a number
    //time comp is O(sqrt(n))
    private boolean prime(int n){
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime(int n){
        if(n == 1) return false;
        if(n == 2 || n == 3) return true;
        if(n % 2 == 0 || n % 3 == 0) return false;

        for(int i = 5; i <= Math.sqrt(n); i += 6)
            if(n % i == 0 || n % (i+2) == 0) return false;
        return true;
    }

    private void sieveOfEratosthenes(int n){
        boolean[] prime = new boolean[n+1];
        for (int i = 2; i <= Math.sqrt(n) ; i++) {
            if (!prime[i])
                for (int j = i * i; j <= n ; j+=i) prime[j] = true;
        }

        for(int i=0;i<n;i++)
            if (!prime[i]) System.out.println(i);
    }
    public static void main(String[]args)throws IOException
    {
//        InputStreamReader read=new InputStreamReader(System.in);
//        BufferedReader in=new BufferedReader(read);
//        String nu=in.readLine();
//        BigInteger big=new BigInteger(nu);
//        boolean b=big.isProbablePrime(1);
//        if(b)
//            System.out.println("prime");
//        else
//            System.out.println("not prime");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PrimeNo i = new PrimeNo();
        System.out.println(isPrime(n));
    }
}
