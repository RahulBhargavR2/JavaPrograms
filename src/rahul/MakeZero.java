package rahul;

import java.util.Scanner;

public class MakeZero {
    private static String checker(int n){
        if (n < 3 ) return "NO";

        while(n % 4 != 0 && n > 0) { n -= 3;}
        if (n % 4 == 0) return "YES";

        return "NO";

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n  = scan.nextInt();
        while (n-->0){
            int a = scan.nextInt();
            System.out.println(checker(a));

        }
    }
}
