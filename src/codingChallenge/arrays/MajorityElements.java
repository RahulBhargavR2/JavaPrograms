package codingChallenge.arrays;

public class MajorityElements {
    public static int majorityElement(int[] nums) {
        int count = 0, maj = nums[0];
        for (int num : nums) {
            if (maj == num)
                count++;
            else {
                count--;
                if (count < 0) {
                    count = 1;
                    maj = num;
                }
            }
        }
        return maj;
    }
}
