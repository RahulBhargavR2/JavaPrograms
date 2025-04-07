package codingChallenge.graph;


import java.util.*;

public class MatrixFill01 {


    private static void bfs(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        while (!queue.isEmpty()){
            int i = queue.peek()[0];
            int j = queue.poll()[1];
            for (int k = 0; k < 4; k++) {
                int x = i+dx[k];
                int y = j+dy[k];
                if (x<0||y<0||x>=m||y>=n||visited[x][y])
                    continue;
                mat[x][y] = mat[i][j] + 1;
                queue.add(new int[]{x,y});
                visited[x][y] = true;

            }
        }
//        System.out.println(Arrays.deepToString(mat));

    }

    public static void main(String[] args) {
//        initializeMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
//        bfs(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        bfs(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 0}});
    }
}
