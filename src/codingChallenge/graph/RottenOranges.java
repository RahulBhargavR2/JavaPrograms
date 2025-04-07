package codingChallenge.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private static int countTimeDFS(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
                else if (grid[i][j] == 1)
                    ++freshCount;
            }
        }
        int iniRotten = queue.size();
        if (freshCount == 0)
            return 0;
        int count = 0, countMin=0;
        while (!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
//                if (y + 1 < n) {
//                    if (grid[x][y + 1] == 1) {
//                        grid[x][y + 1] = 2;
//                        queue.add(new int[]{x, y + 1});
//                    }
//                }
//                if (y - 1 >= 0) {
//                    if (grid[x][y - 1] == 1) {
//                        grid[x][y - 1] = 2;
//                        queue.add(new int[]{x, y - 1});
//                    }
//                }
//                if (x + 1 < m) {
//                    if (grid[x + 1][y] == 1) {
//                        grid[x + 1][y] = 2;
//                        queue.add(new int[]{x + 1, y});
//                    }
//                }
//                if (x - 1 >= 0) {
//                    if (grid[x - 1][y] == 1) {
//                        grid[x - 1][y] = 2;
//                        queue.add(new int[]{x - 1, y});
//                    }
//                }
                int[] aX={0,0,1,-1};
                int[] bY = {1,-1,0,0};
                for (int j = 0; j < 4; j++) {
                    int x = curr[0] + aX[i];
                    int y = curr[1] + bY[i];

                    if (x<0||y<0||x>=n||y>=n||grid[x][y] == 2||grid[x][y]==0)
                        continue;
                    grid[x][y] = 2;
                    queue.add(new int[]{x,y});

                }
            }
            if (!queue.isEmpty())
                countMin++;
        }
        return freshCount == count-iniRotten?countMin:-1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(countTimeDFS(grid));
    }
}
