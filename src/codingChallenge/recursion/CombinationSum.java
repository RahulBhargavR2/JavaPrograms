package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private static void getCombinations1(int[] arr, int target, int sum, LinkedList<Integer> list, List<List<Integer>> result, int curr) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = curr; i < arr.length; i++) {
            if (sum + arr[i] > target)
                break;
            list.add(arr[i]);
            getCombinations1(arr, target, sum + arr[i], list, result, i);
            list.removeLast();

        }
    }

    private void getCombination2(int[] arr, int target, int sum, LinkedList<Integer> list, List<List<Integer>> result,
                                 int curr) {
        if (sum > target)
            return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = curr; i < arr.length; i++) {
            if (i > curr && arr[i] == arr[i - 1])
                continue;
            list.add(arr[i]);
            getCombination2(arr, target, sum + arr[i], list, result, i + 1);
            list.removeLast();

        }
    }

    // combinations of length equal to n in range of 0 to 9
    private static void getCombination3(int n, int target, int sum, List<Integer> list, List<List<Integer>> result,
                                        int curr) {
        if (sum > target)
            return;

        if (sum == target) {
            if (list.size() == n)
                result.add(new ArrayList<>(list));
            return;
        }
        for (int i = curr; i <= 9; i++) {
            list.add(i);
            getCombination3(n, target, sum + i, list, result, i + 1);
            list.remove(list.size() - 1);

        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int target = 7;
        int n = 3;
        getCombination3(n, target, 0, list, res, 1);
        System.out.println(res);
    }
}
