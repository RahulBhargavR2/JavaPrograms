package coidingChallenge.math;

public class FindPow {
    public double myPow(double x, int n) {
        boolean isNegative = false;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double soln = 1;

        while (n != 0) {
            if ((n & 1) != 0)
                soln *= x;
            x *= x;
            n >>>= 1;
        }
        return soln;
    }

    public static void main(String[] args) {

    }
}
