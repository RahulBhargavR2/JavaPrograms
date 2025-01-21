package rahul;

import java.util.Scanner;
//https://www.codechef.com/START135D
public class FootBallTies {


    private static int check(String s) {
        int max0 = 0, max1 = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '0'){
                while (i<n&&s.charAt(i) == '0') i++;
                max0++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1'){
                while (i<n&&s.charAt(i)=='1') i++;
                max1++;
            }
        }

        int count = 0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)!=s.charAt(i+1)) count++;
        }
        int ans = (count%2==0)?count/2:(count/2)+1;
        return Math.min(max0,max1);
    }



    public static void main(String[] args) {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int len = scan.nextInt();
            String s = scan.next();
            System.out.println(check(s));
        }

    }
}

