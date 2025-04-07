package codingChallenge.arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prod1 = 1, prod2 = 1, max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (prod1 == 0)
                prod1 = 1;
            if (prod2 == 0)
                prod2 = 1;
            prod1 *= nums[i];
            prod2 *= nums[n - i - 1];

            max = Math.max(max, Math.max(prod1, prod2));
        }
        return max;
    }
}
