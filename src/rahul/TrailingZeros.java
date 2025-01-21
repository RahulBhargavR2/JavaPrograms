package rahul;

import java.util.Scanner;

public class TrailingZeros {
    private static int findZeros(int n) {
        if (n < 0) return -1;
        int count = 0;

        for (int i = 5; n >= i; i *= 5) count += n / i;
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no");
        int num = scan.nextInt();
        System.out.println("No of trailing zeros in factorial of "+num+"is");
        System.out.println(findZeros(num));
    }
}
