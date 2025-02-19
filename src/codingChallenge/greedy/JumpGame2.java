package codingChallenge.greedy;

public class JumpGame2 {
    public static int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int count = 0;
        for (int i = 0; i < nums.length;) {
            count++;
            int max = -1;
            if (nums[i] + i >= nums.length-1)
                return count;
            for (int j = i+1; j < nums[i] + i+1; j++)
                max = Math.max(max, nums[j]);
            i += max;
        }
        return count;
    }

    public static void main(String[] args) {
        int[]arr = {2,3,1,1,4};
        System.out.println(jump(arr));
    }
}
