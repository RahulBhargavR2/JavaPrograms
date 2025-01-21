package rahul;

import java.util.Scanner;

public class Streak{
    static Scanner scan = new Scanner(System.in);
    private static int str(int n){
        int streak = 0,max = -1;
        for (int i =0;i < n ;i++ ){
            int a = scan.nextInt();
            if(a == 0){
                if(streak > max) max = streak;
                streak = 0;
            }
            else streak++;
        }
        if(streak > max) max = streak;

        return max;
    }

    public static void main(String[] args) {
        int t = scan.nextInt();

        while(t-->0){
            int n = scan.nextInt();

            int om = str(n);

            int addy = str(n);

            if(addy == om) System.out.println("Draw");
            else if(addy > om) System.out.println("Addy");
            else System.out.println("Om");
        }

    }
}
