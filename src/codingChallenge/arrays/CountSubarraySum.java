package codingChallenge.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraySum {
    public int subarraySum(int[] arr, int required) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0, 1);
        for (int j : arr) {
            sum += j;

            int remaining = sum - required;

            count += map.getOrDefault(remaining, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
