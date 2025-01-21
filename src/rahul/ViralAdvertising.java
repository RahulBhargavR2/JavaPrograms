package rahul;

import java.util.Scanner;

public class ViralAdvertising {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n= scan.nextInt();
        int shared = 5;
        int cumulative = 0;
        for(int i = 0; i < n; i ++){
            int liked = shared / 2;
             shared= liked * 3;
            cumulative += liked;
        }
        System.out.println(cumulative);
    }
}
