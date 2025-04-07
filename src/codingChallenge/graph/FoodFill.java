package codingChallenge.graph;

import java.util.Arrays;

public class FoodFill {
    private static void dfs(int[][] image, int r, int c, int color) {
        if (image[r][c] == color)
            return;
        int curr = image[r][c];
        image[r][c] = color;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int row = r + dx[i];
            int col = c + dy[i];
            if (row < 0 || col < 0 || row >= image.length || col >= image[0].length)
                continue;
            if (image[row][col] == curr)
                dfs(image, row, col, color);
        }
    }

//    private static void bfs(int[][]image, int r, int c, int color){
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{r,c});
//        while (!queue.isEmpty()){
//            int[] curr = queue.poll();
//            int x = curr[0], y = curr[1];
//            int[] dx = { 0, 0, 1, -1 };
//            int[] dy = { 1, -1, 0, 0 };
//            for (int i = 0; i < 4; i++) {
//                int row = x + dx[i];
//                int col = y + dy[i];
//                if (row < 0 || col < 0 || row >= image.length || col >= image[0].length)
//                    continue;
//
//                if (image[row][col] == image[x][y]){
//                    queue.add(new int[]{row,col});
//                }
//            }
//            image[x][y] = color;
//        }
//}

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color);
        return image;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        dfs(arr, 1, 1, 2);
        System.out.println(Arrays.deepToString(arr));
    }
}
