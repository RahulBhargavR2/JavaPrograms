package rahul;

public class Patterns {

//    *
//    * *
//    * * *
//    * * * *
    private static void rightTri(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//     * * * *
//     * * *
//     * *
//     *
    private static void invRightTri(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

//          *
//        * *
//      * * *
//    * * * *

    private static void leftTri(int n) {
        for (int i = 0; i < n; i++) {
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }
//        *
//       * *
//      * * *
//     * * * *
//    * * * * *

    private static void pyramid(int n) {
        for (int i = 0; i < n; i++) {
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print(" ");
            }
//            for (int j = 0; j <= 2*i; j++) {
//                if ((j&1) !=1)
//                    System.out.print("*");
//                else System.out.print(" ");
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }

    private static void diamond(int n) {
        //upper half
        for (int i = 0; i < n; i++) {
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
        //lower half
        for (int i = 1; i < n; i++) {
            for (int space = 0; space < i; space++) {
                System.out.print(" ");
            }
            for (int j = n - i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //hollow diamond
    private static void hollowDiamond(int n) {
        for (int i = 0; i < n; i++) {
            for (int space = 0; space < n - i - 1; space++) {
                System.out.print(" ");
            }
//            for (int j = 0; j <= i; j++) {
            System.out.print(i == 0 ? " * " : "* ");
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            System.out.print(i != 0 ? "* " : "");
//            }
            System.out.println();

        }
        //lower half
        for (int i = 1; i < n; i++) {
            for (int space = 0; space < i; space++) {
                System.out.print(" ");
            }
//            for (int j = n - i; j > 0; j--) {
            System.out.print(i == n - 1 ? " * " : "* ");
            for (int j = 2 * (n - i - 1); j > 0; j--) {
                System.out.print(" ");
            }
//            System.out.print(i);
            System.out.print(i == n - 1 ? "" : "* ");
//            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        hollowDiamond(4);
    }
}
