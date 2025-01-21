import java.util.Scanner;

public class Rec {
    static long[]arr;
    public static long fib(int n){
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        if(arr[n]!=0)
            return arr[n];
        else{
            long temp=(fib(n-1)+fib(n-2));
            arr[n]=temp;
            return temp;
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=scan.nextInt();
        arr=new long[n+1];
        System.out.println(fib(n));
    }
}
