package codingChallenge.arrays;

public class RearrangeAlternatively {
    private static int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[]arr = new int[len];
        int pos =0,neg =1;
        for (int num : nums) {
            if (num > 0) {
                arr[pos] = num;
                pos += 2;
            } else {
                arr[neg] = num;
                neg += 2;
            }
        }
        return arr;
    }
}
