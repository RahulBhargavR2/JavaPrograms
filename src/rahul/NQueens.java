package rahul;

import java.util.Arrays;
import java.util.Scanner;

public class NQueens {
    private static int[][] board;

    private static void printBoard() {
        for (int[] arr : board) {
            for (int i : arr)
                System.out.print((i == 1) ? " Q " : " _ ");
            System.out.println();
        }
    }

    private static boolean isSafe(int row, int col) {
        int i, j;
        for (i = 0; i < row; i++) {
            if (board[row][i] == 1) return false;
        }
        //upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        //lower left diagonal
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    private static boolean queens(int col) {
        if (col >= board.length) return true;
        for (int i = 0; i < board.length; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;

                if (queens(col + 1)) return true;
                board[i][col] = 0;
            }
        }
        return true;

    }

    private static void queens() {
        if (queens(0))
            printBoard();
        else System.out.println("No solution");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        board = new int[n][n];
        for (int[] arr : board)
            Arrays.fill(arr, 0);
        queens();

    }
}
