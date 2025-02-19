package codingChallenge.greedy;

public class JumpGame {
    public static boolean canJump(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            int max = arr[i], pos = i;
            for (int j = i + 1; j < i + arr[i] && j < arr.length; j++) {
                if (arr[j] >= max) {
                    max = arr[j];
                    pos = j;
                }
            }
            i = i == pos ? arr[i] + pos : pos;
            if (i>=arr.length-1 || i + arr[i] >= arr.length-1)
                return true;
            if (arr[i] == 0)
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] arr = {3,2,1,0,4};
//        int[] arr = {2, 3, 1, 1, 4};
//        int[] arr = {1,1,2,2,0,1,1};
        int[] arr = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(arr));
    }
}
