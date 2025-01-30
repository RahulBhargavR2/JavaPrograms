package codingChallenge.math;

public class PowerOf3 {
    private static boolean isPowerOf3(int n) {
        double soln = (int) (Math.log10(n) / Math.log10(3));
        return n == (int) Math.pow(3, soln);
    }

    public boolean isPowerOfThreeMath(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n % 3 != 0)
                return false;
            n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
    }
}
