package coidingChallenge.arrays;

public class RotateMatrix {
    private static void print(int[][]arr){
        for(int[] i:arr){
            for (int j:i)
                System.out.print(j+ " ");
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < len; i++) {
            int start = 0, end = len - 1;
            while (start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[][]matrix = {{1,2,3},{4,5,6},{7,8,9}};
        print(matrix);
        rotate(matrix);
        print(matrix);
    }
}
