package rahul;

import java.util.Scanner;

public class SmallestNumber {
    private int check(int n){
        if (n <= 1) return 0;
        return (int) Math.pow(10,String.valueOf(n).length()-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SmallestNumber s = new SmallestNumber();
        while (true){
            int a = scan.nextInt();
            System.out.println(s.check(a));
        }
    }

}
