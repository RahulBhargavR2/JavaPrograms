package rahul;

import java.util.Scanner;

public class ChristmasDecoration {
    private static String check(int lea,int lar,int sma){
        if((lar/2)>= lea) return "YES";
        int posSm = Math.min(lar,sma/3);
        int rema = lar-posSm;
        int fi = posSm+rema/2;
        if(fi>=lea) return "YES";
        return "NO";
    }
    public static void main (String[] args)
    {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            int lea = scan.nextInt();
            int lar = scan.nextInt();
            int sma = scan.nextInt();
            System.out.println(check(lea,lar,sma));
        }


    }
}
