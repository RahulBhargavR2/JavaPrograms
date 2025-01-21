package rahul;

import java.util.Scanner;

public class Prime {
    public static boolean isPrime(int n){
        for (int i = 2; i < Math.sqrt(n) ; i++) {
            if (n % i== 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter the range");
        int n = scan.nextInt();
//        boolean cond=false;
//
//        for (int j=3;j<n;j++) {
//            for (int i = 2; i <j/2; i++) {
//                if (j % i == 0) {
//                    cond = true;
//                    break;
//                }
//            }
//            if (!cond) System.out.println(j);
//            cond=false;
//        }
        boolean[]arr = new boolean[n];
        for(int i=0;i<n;i++){
            int num = scan.nextInt();
           arr[i] = isPrime(num);
        }

    }
}
