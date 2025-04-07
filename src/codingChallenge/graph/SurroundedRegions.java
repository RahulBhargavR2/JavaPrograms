package codingChallenge.graph;

import java.util.Arrays;

public class SurroundedRegions {
    private static boolean dfs(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
                return false;
            }
            if (board[x][y] == 'X' || visited[x][y])
                continue;
            if (!dfs(board, x, y, visited))
                return false;
            board[x][y] = 'X';
        }
        return true;
    }

    private static void surroundRegions(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == 'O')
                    if (dfs(board, i, j, visited))
                        board[i][j] = 'X';
            }
            print(board);

        }
    }

    static void print(char[][] board) {
        for (char[] i : board) {
            for (char ch : i)
                System.out.print(ch + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board = {{'O'}};
        print(board);
        surroundRegions(board);
    }
}
