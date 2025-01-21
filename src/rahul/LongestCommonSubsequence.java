package rahul;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {

    // takes 2^min(m,n)
    private static int maxSubsequence(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (s1.charAt((m - 1)) == s2.charAt(n - 1))
            return 1 + maxSubsequence(s1, s2, m - 1, n - 1);
        else
            return Math.max(maxSubsequence(s1, s2, m - 1, n), maxSubsequence(s1, s2, m, n - 1));

    }

    //optimized using dp part 1
    private static int maxSubsequenceDp(String s1, String s2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (s1.charAt((m - 1)) == s2.charAt(n - 1))
            dp[m][n] = 1 + maxSubsequenceDp(s1, s2, m - 1, n - 1, dp);
        else
            dp[m][n] = Math.max(maxSubsequenceDp(s1, s2, m - 1, n, dp),
                    maxSubsequenceDp(s1, s2, m, n - 1, dp));

        return dp[m][n];

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next(), s2 = scan.next();
        int m = s1.length(), n = s2.length();

        // normal
        System.out.println(maxSubsequence(s1, s2, m, n));

        // dp
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);
        System.out.println(maxSubsequenceDp(s1, s2, m, n, dp));
        for (int[] i : dp) {
            for (int j : i) System.out.print(j + " ");
            System.out.println();
        }
    }
}
