package rahul;

import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unused")

public class Matrix {


    static Scanner scan = new Scanner(System.in);

    private static int[][] multiply(int[][] first, int[][] second) {
        int[][] resultant = new int[first.length][second[0].length];
        for (int i = 0; i < resultant.length; i++) {
            for (int j = 0; j < resultant[0].length; j++) {
                for (int k = 0; k < first[0].length; k++) {
                    resultant[i][j] += first[i][k] * second[k][j];
                }
            }
        }
        return resultant;
    }

    private static int[][] getIdentityMatrix(int order) {
        int[][] identity = new int[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = i; j < order; j++) {
                if (i == j) identity[i][j] = 1;
            }
        }
        return identity;
    }

    private static int[][] power(int[][] arr) {
        if (!isSquare(arr)) {
            System.out.println("Not a square matrix");
            System.exit(0);
        }
        System.out.println("Enter the power to be found");
        int n = scan.nextInt();
        if (n == 1) return arr;
        else {
            int[][] temp;
            temp = multiply(arr, arr);
            if (n == 2) return temp;
            for (int i = 2; i < n; i++) {
                temp = multiply(temp, arr);
            }
            return temp;
        }
    }

    private static boolean isSquare(int[][] a) {
        return a.length == a[0].length;
    }

    private void show(int[][] arr) {
        for (int[] ints : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();

        }
    }

    private static int[][] square(int[][] arr) {
        return multiply(arr, arr);
    }

    private static int[][] getFirst() {
        System.out.println("Enter dimensions of first matrix");
        int n1 = scan.nextInt();
        int m1 = scan.nextInt();
        int[][] arr1 = new int[n1][m1];
        System.out.println("Enter the first matrix");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                arr1[i][j] = scan.nextInt();
            }
        }
        return arr1;
    }

    private static int[][] getSecond() {
        System.out.println("Enter dimensions of second matrix");
        int n1 = scan.nextInt();
        int m1 = scan.nextInt();
        int[][] arr2 = new int[n1][m1];
        System.out.println("Enter the second matrix");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                arr2[i][j] = scan.nextInt();
            }
        }
        return arr2;
    }

    private static int[][] transpose(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = arr[j][i];
            }
        }
        return temp;
    }

    private static String orderOf(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        return Arrays.toString(new int[]{m, n});
    }

    private int[][] scalarMultiply(int[][] arr, int scalar) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] *= scalar;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        new Matrix().show(getFirst());

    }
}