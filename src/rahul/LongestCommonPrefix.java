package rahul;

import java.util.Scanner;

//Strings
public class LongestCommonPrefix {
    // A Utility Function to find the common prefix between
// strings- str1 and str2
    static String commonPrefixUtil(String str1, String str2) {
        StringBuilder result = new StringBuilder();
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i <= n1 - 1 &&
                j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result.append(str1.charAt(i));
        }
        return result.toString();
    }

    // A Divide and Conquer based function to find the
// longest common prefix. This is similar to the
// merge sort technique
    static String commonPrefix(String[] arr, int low, int high) {
        if (low == high) {
            return (arr[low]);
        }

        if (high > low) {
            // Same as (low + high)/2, but avoids overflow for
            // large low and high
            int mid = low + (high - low) / 2;

            String str1 = commonPrefix(arr, low, mid);
            String str2 = commonPrefix(arr, mid + 1, high);

            return commonPrefixUtil(str1, str2);
        }
        return "";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int len = scan.nextInt();
            String[] s = new String[len];
            for (int i = 0; i < len; i++) {
                s[i] = scan.next();
            }
            System.out.println(commonPrefix(s, 0, len - 1));
        }
    }
}
