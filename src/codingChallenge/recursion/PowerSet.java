package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    private static void getSubset1(int[] arr, int curr, List<Integer> list, List<List<Integer>> res) {
        if (curr == arr.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[curr]);
        getSubset1(arr, curr + 1, list, res);
        list.remove(list.size() - 1);
        getSubset1(arr, curr + 1, list, res);
    }

    private static void getSubset2(int[] arr, int curr, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = curr; i < arr.length; i++) {
            list.add(arr[i]);
            getSubset2(arr, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] arr = {1, 2, 3};
//        getSubset1(arr, 0, list, res);
//        getSubset2(arr, 0, list, res);
        System.out.println(res);
    }
}
