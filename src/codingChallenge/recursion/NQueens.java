package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


// to place n queens on a nXn chess board such no queen attack other queen, queen can move in all four directions
// right, left, up and down and also can travel diagonally.
public class NQueens {
    /*
    private static boolean isSafe(List<String> list, int n, int row, int col) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i).charAt(col) == 'Q') a++;
            if (list.get(row).charAt(i) == 'Q') b++;
        }
        int rl = row - Math.min(row, col), cl = col - Math.min(row, col); // from left to right
        int cr = col + Math.min(row, n - col - 1), rr = row - Math.min(row, n - col - 1);
        while (rl < n && cl < n) {
            if (list.get(rl).charAt(cl) == 'Q')
                c++;
            rl++;
            cl++;
        }
        while (rr < n && cr >= 0) {
            if (list.get(rr).charAt(cr) == 'Q')
                d++;
            rr++;
            cr--;
        }
        return a < 2 && b < 2 && c < 2 && d < 2;


    }

    private static boolean isSafe(List<String> list, int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (list.get(i).charAt(col) == 'Q')
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (list.get(i).charAt(row) == 'Q')
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (list.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static void generate(List<String> list, List<List<String>> res, int curr, int n) {
        if (curr == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(list.get(curr));
            String temp = list.get(curr);
            sb.replace(i, i + 1, "Q");
            list.set(curr, sb.toString());
            if (isSafe(list, n, curr, i))
                generate(list, res, curr + 1, n);
            list.set(curr, temp);
        }
    }

    private static List<List<String>> generate(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(".".repeat(n));
        }
        generate(list, res, 0, n);
        return res;
    }
*/

    private static boolean isSafe(char[][] board, int n, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i++, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    private static void generate(char[][] board, int n, List<List<String>> res, int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board)
                temp.add(new String(r));
            res.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(board, n, row, i)) {
                board[row][i] = 'Q';
                generate(board, n, res, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private static List<List<String>> generate(int n){
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i],'.');
        generate(board,n,res,0);
        return res;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the board size");
        int n = scan.nextInt();
        List<List<String>> result = generate(n);
        System.out.println(result);
    }
}