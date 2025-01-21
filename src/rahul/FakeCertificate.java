package rahul;

import java.util.Scanner;

public class FakeCertificate {
    private static int longest(String s) {
        int gmax = 0, countOne = 0, countZero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOne++;
                gmax = Math.max(gmax, countZero);
                countZero = 0;
            } else {
                countZero++;
                gmax = Math.max(gmax, countZero);
            }
        }
        return gmax + countOne;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int m = scan.nextInt();
            String s = scan.next();
            System.out.println(longest(s));
        }
    }
}
