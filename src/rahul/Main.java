package rahul;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int size = scan.nextInt();
            for (int i = 0; i < size; i++) {
                int ele = scan.nextInt();
                if(ele>20)
                    System.out.println("HOT");
                else
                    System.out.println("COLD");
            }
        }
    }
}
