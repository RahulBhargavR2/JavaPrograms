package codingChallenge.bitMaipulation;

import java.util.Scanner;

public class XOROfRange {

    private static int findXOR(int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++)
            res ^= i;
        return res;
    }

    private static int findXORBetter(int n) {
        switch (n % 4) {
            case 0 -> {
                return n;
            }
            case 1 -> {
                return 1;
            }
            case 2 -> {
                return n + 1;
            }
            case 3 -> {
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n--> 0) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            System.out.println(findXORBetter(end) ^ findXORBetter(start - 1));
        }
    }
}
