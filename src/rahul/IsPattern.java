package rahul;

//leetcode 290
public class IsPattern {
    private static boolean isBadVersion(int n) {
        return n >= 2;
    }

    private static int check(int n) {
        if (n == 1 && isBadVersion(n)) return 1;
        int low = 1, high = n, mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {

        System.out.println(check(3));

    }

}

