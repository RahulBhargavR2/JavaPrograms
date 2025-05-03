package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    private static void withoutDup(int[] arr, LinkedList<Integer> list, List<List<Integer>> res) {
        if (list.size() == arr.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int j : arr) {
            if (list.contains(j))
                continue;
            list.add(j);
            withoutDup(arr, list, res);
            list.removeLast();
        }
    }

    private static List<List<Integer>> getPermutation(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        withoutDup(arr, list, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(getPermutation(arr));
    }
}
