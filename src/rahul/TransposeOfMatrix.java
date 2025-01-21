package rahul;

import java.util.Scanner;
    public class TransposeOfMatrix {
     public static void main(String[] args) {
         Scanner scan = new Scanner(System.in);
         System.out.println("Enter the size of rows and columns");
         int m = scan.nextInt();
         int n = scan.nextInt();
         int[][] a = new int[m][n];
         System.out.println("Enter the elements into matrix");
         //loop to get elements of array
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 a[i][j] = scan.nextInt();
             }
         }
         //loop to print transpose of matrix
         System.out.println("Matrix after transposing");
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 System.out.print(a[j][i] + " ");
             }
             System.out.println();
         }
     }
}