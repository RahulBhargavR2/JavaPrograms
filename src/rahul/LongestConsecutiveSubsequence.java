package rahul;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LongestConsecutiveSubsequence {
    private static int longest1(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr)
            set.add(i);
        int count = 1, prev = Integer.MIN_VALUE, max = 0;
        for (int i : set) {
            if (i - prev == 1) {
                count++;
                prev = i;
                max = Math.max(max, count);
            } else {
                max = Math.max(max, count);
                count = 1;
                prev = i;
            }
        }
        return max;
    }


    private static int longest2(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return arr.length;
        Arrays.sort(arr);
        int ele = arr[0], count = 1, max = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == ele) continue;
            if (arr[i] - ele == 1) {
                count++;
                ele = arr[i];
                max = count > max ? count : max;
            } else {
                max = count > max ? count : max;
                count = 1;
                ele = arr[i];
            }
        }
        return max;
    }

    private static int longest3
            (int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        int max = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int len = 1;
                while (set.contains(i + len))
                    ++len;
                max = len > max ? len : max;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(longest2(arr));
    }
}
