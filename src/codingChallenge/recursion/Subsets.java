package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    private static void withoutDup(int[] arr, int curr, LinkedList<Integer> list, List<List<Integer>> res) {
        res.add(new LinkedList<>(list));
        for (int i = curr; i < arr.length; i++) {
            list.add(arr[i]);
            withoutDup(arr, i + 1, list, res);
            list.removeLast();
        }
    }

    private static void withDup(int[] arr, int curr, LinkedList<Integer> list, List<List<Integer>> res) {
        res.add(new LinkedList<>(list));
        for (int i = curr; i < arr.length; i++) {
            if (i > curr && arr[i] == arr[i - 1]) continue;
            list.add(arr[i]);
            withDup(arr, i + 1, list, res);
            list.removeLast();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        withDup(nums, 0, list, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2};
//        System.out.println(subsetsWithDup(arr));
    }
}
