package codingChallenge.recursion;

import java.util.Arrays;

public class WordSearch {
    private static boolean searchWord(char[][] board, String word, String target, int r, int c) {
        if (word.length() == target.length()) {
            return word.equals(target);
        }
        char ch = board[r][c];
        board[r][c] = '0';
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int row = r + dx[i];
            int col = c + dy[i];
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != target.charAt(word.length()))
                continue;

            if (searchWord(board, word + board[row][col], target, row, col))
                return true;

        }
        board[r][c] = ch;

        return false;
    }

    private static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j])
                    if (searchWord(board, board[i][j] + "", word, i, j))
                        return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = {{'a','a'}};
//        System.out.println(exist(board,"SEE"));
    }

}
