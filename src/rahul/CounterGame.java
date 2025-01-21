package rahul;

import java.util.Scanner;

public class CounterGame {
    private String counter(long num){
        int count = 0;
        while (num > 1){
            if ((num & (num - 1)) == 0) {
                num /= 2;
            }
            else {
                long a = (long)(Math.log10(num)/Math.log10(2));
                long c = (long)(Math.pow(2,a));
                num -= c;
            }
            count ++;
        }
        if (count % 2 == 0) return "Richard";
        return "Louise";
    }

    public static void main(String[] args) {
        CounterGame c = new CounterGame();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int a = scan.nextInt();
            System.out.println(c.counter(a));
        }
    }
}
