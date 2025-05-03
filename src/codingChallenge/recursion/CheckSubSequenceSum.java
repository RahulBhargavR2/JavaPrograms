package codingChallenge.recursion;

public class CheckSubSequenceSum {
    private static boolean checkSubSequence(int[] arr, int curr, int sum, int target) {
        if (sum == target)
            return true;
        if (sum > target || curr >= arr.length)
            return false;

        return checkSubSequence(arr, curr + 1, sum + arr[curr], target) ||
                checkSubSequence(arr, curr + 1, sum, target);
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        int sum = 0;
        System.out.println(checkSubSequence(arr, 0, 0, target));
    }
}
