package rahul;

import java.util.Scanner;

public class SaveThePrisoner {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i=0;i<n;i++) {
            int noOfPris = scan.nextInt();
            int noOfCandy = scan.nextInt();
            int starting = scan.nextInt();

           int saved = (noOfCandy + starting -1)% noOfPris;
            if (saved == 0) System.out.println(noOfPris);
            else
             System.out.println(saved);
        }
    }
}