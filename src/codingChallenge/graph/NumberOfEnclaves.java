package codingChallenge.graph;

public class NumberOfEnclaves {

    private static boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        int[] dx = {0, -1, 1, 0};
        int[] dy = {-1, 0, 0, 1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
                return false;
            }
            if (grid[x][y] == 0 || visited[x][y])
                continue;
            if (!dfs(grid, x, y, visited))
                return false;
            grid[x][y] = 0;
        }
        return true;
    }

    private static void enclave(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (!visited[i][j] && grid[i][j] == 1)
                    if (dfs(grid, i, j, visited))
                        grid[i][j] = 0;
            }
        }
        for (int[] arr:grid)
            for (int i:arr)
                if (i==1)
                    count++;

    }
    static void print(int[][] grid) {
        for (int[] i : grid) {
            for (int ch : i)
                System.out.print(ch + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0},{1,1,1,0},{0,1,1,0},{0,0,0,0}};
        enclave(grid);
        print(grid);

    }
}
