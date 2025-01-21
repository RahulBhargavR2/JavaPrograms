package rahul;

import java.util.Scanner;

public class MatrixMultiplication{
    public void multiply(int[][] first, int[][] second,int[][]resultant) {
        for (int i = 0; i < resultant.length; i++)
            for (int j = 0; j < resultant[0].length; j++)
                for (int k = 0; k < first[0].length; k++)
                    resultant[i][j] += first[i][k] * second[k][j];

    }
    public void show(int[][]res){
        System.out.println("The resultant matrix is ");
        for(int[] row:res){
            for(int ele:row)
                System.out.print(ele+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter dimensions of first matrix");
        int n1 = scan.nextInt();
        int m1 = scan.nextInt();

        System.out.println("Enter dimensions of second matrix");
        int n2 = scan.nextInt();
        int m2 = scan.nextInt();

        if (n1 != m2) {
            System.out.println("Matrices cannot be multiplied");
            System.exit(0);
        }

        int[][] arr1 = new int[n1][m1];
        int[][] arr2 = new int[n2][m2];
        int[][]resultant = new int[n1][m2];

        System.out.println("Enter the first matrix");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                arr1[i][j] = scan.nextInt();
            }
        }
        System.out.println("Enter the Second matrix");
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                arr2[i][j] = scan.nextInt();
            }
        }

        MatrixMultiplication mat = new MatrixMultiplication();
        mat.multiply(arr1, arr2, resultant);
        mat.show(resultant);
    }
}