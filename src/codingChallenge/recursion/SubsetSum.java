package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    private static void getSubsets(int[] arr, int sum, int curr, ArrayList<Integer> res) {
        if (curr == arr.length) {
            res.add(sum);
            return;
        }
        getSubsets(arr, sum + arr[curr], curr + 1, res);
        getSubsets(arr, sum, curr + 1, res);
    }

    public static ArrayList<Integer> subsetSum(int[] num) {
        // Write your code
        ArrayList<Integer> res = new ArrayList<>();
        getSubsets(num, 0, 0, res);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(subsetSum(arr));
    }
}
