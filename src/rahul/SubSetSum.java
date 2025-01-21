package rahul;

public class SubSetSum {

    private static boolean isSubset(int[] arr, int n, int sum) {
        if (sum == 0) return true;
        if (n == 0) return false;

        if (arr[n - 1] > sum) return false;

        return isSubset(arr, n - 1, sum)
                || isSubset(arr, n - 1, sum - arr[n - 1]);
    }

    //dp
    private static boolean isSubsetDp(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
            }
        }
        for (boolean[] row : dp) {
            for (boolean ele : row) System.out.print(ele + " ");
            System.out.println();
        }
        return dp[n][sum];
    }

    //dp space opt
    private static boolean isSubsetDpSpace(int[] arr, int n, int sum) {
        // set default to false
        boolean[] dp = new boolean[sum + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = false;
        }
        // as sum is zero its true for first ele
        dp[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= arr[i]; j--) { //ignores if element is greater than sum
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[sum];
    }


    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int len = arr.length;
        // normal
        System.out.println(isSubset(arr, arr.length, sum));

        //dp
        System.out.println(isSubsetDp(arr, arr.length, sum));
        System.out.println(isSubsetDpSpace(arr, arr.length, sum));

    }
}
