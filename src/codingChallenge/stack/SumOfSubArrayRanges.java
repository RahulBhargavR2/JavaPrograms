package codingChallenge.stack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SumOfSubArrayRanges {

    //bruteforce and easy solution
    public static long subArrayRanges1(int[] arr) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i], min = arr[i];
            for (int j = i; j < arr.length; j++) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                res += max - min;
            }
        }
        return res;
    }
    public static long subArrayRanges2(int[] arr) {
        int n = arr.length, j, k;
        long res = 0;
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && arr[s.peek()] > (i == n ? Integer.MIN_VALUE : arr[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                if (i == n)
                    System.out.println((i - j) * (j - k));
                res -= (long)arr[j] * (i - j) * (j - k);

            }

            s.push(i);
        }
        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && arr[s.peek()] < (i == n ? Integer.MAX_VALUE : arr[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long)arr[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(subArrayRanges2(new int[]{2,4,6,4,14,5,1,3}));
    }
}