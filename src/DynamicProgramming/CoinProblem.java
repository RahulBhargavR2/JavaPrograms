package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CoinProblem {
    private static Map<Integer, Integer> map;

    private static int getMin(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        return Math.min(a, b);
    }

    private static int minimumCoin(int sum, int[] coins) {
        if (map.containsKey(sum))
            return map.get(sum);
        int ans;
        if (sum == 0)
            ans = 0;
        else {
            ans = 0;
            for (int coin : coins) {
                int sub = sum - coin;
                if (sub < 0)
                    continue;
                ans = getMin(ans, minimumCoin(sub, coins) + 1);
            }
        }
        map.put(sum, ans);
        return ans;
    }

    public static void main(String[] args) {
        map = new HashMap<>();
        int[] arr = {1, 4, 5};
        System.out.println(minimumCoin(13, arr));
    }
}
