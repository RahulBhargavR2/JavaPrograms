package codingChallenge.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HandOfStraights {
    private static boolean canGroup(int[] arr, int groupSize) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.merge(i, 1, Integer::sum);
        int[] ele = new int[map.size()];
        int j = 0;
        for (int i : map.keySet())
            ele[j++] = i;
        Arrays.sort(ele);
        int count = 0;
        for (int value : ele) {
            int k;
            for (k = 0; k < groupSize; k++) {
                if (map.containsKey(value)) value++;
                else if (map.containsKey(value - 1)) value--;
                else break;
            }
            if (k == groupSize) count++;
        }
        System.out.println(count);
        return count >= groupSize || count * groupSize == groupSize;
    }

    private static boolean group(int[] arr, int groupSize) {
        if ((arr.length % groupSize) != 0)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr)
            map.merge(i, 1, Integer::sum);
        Arrays.sort(arr);
        for (int i : arr) {
            if (map.get(i) > 0) {
                for (int j = i; j < groupSize + i; j++) {
                    if (map.getOrDefault(j, 0) == 0)
                        return false;
                    map.put(j, map.get(j) - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {8,10,12};
        int g = 3;
        System.out.println(group(arr, g));
    }
}
