package rahul;

import java.util.Scanner;

public class DiceDeception {
    static Scanner scan = new Scanner(System.in);

    private static int maxPossible(int n, int noOfFlips) {
        int[] arr = new int[4];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int ele = scan.nextInt();
            if (ele >= 4) sum += ele;
            else arr[ele]++;
        }
        for (int i = 1; i < 4 && noOfFlips > 0; i++) {
            if (noOfFlips >= arr[i]) {
                sum += arr[i] * (7 - i);
                noOfFlips -= arr[i];
                arr[i] = 0;
            } else {
                sum += noOfFlips * (7 - i);
                arr[i] -= noOfFlips;
                noOfFlips = 0;
            }
        }
        for (int i = 0; i < 4; i++) {
            sum += arr[i] * i;
        }
        return sum;
    }

    public static void main(String[] args) {

        int n = scan.nextInt();
        while (n-- > 0) {
            int nop = scan.nextInt();
            int noOfFlip = scan.nextInt();

            System.out.println(maxPossible(nop, noOfFlip));

        }

    }
}
