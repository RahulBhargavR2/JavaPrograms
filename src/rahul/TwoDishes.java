package rahul;

import java.util.Scanner;

public class TwoDishes {
    private int dishChecker(int maxPossible, int sumOfDishes) {
        if (sumOfDishes <= maxPossible) return sumOfDishes;
        if (maxPossible % 2 == 0) return --maxPossible;
        else return maxPossible - 2;
//        return maxPossible;
    }

    public static void main(String[] args) {
        TwoDishes t = new TwoDishes();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int maxPos = scan.nextInt();
            int sumDish = scan.nextInt();
            System.out.println(t.dishChecker(maxPos, sumDish));
        }
    }
}
