package codingChallenge.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RatInMaze {
    private static void getAllPaths(int[][] maze, int r, int c, String s, List<String>res){
        maze[r][c] = 0;
        if(r == maze.length-1&&c == maze.length-1){
            res.add(s);
        }
        int[]dx = {0,0,-1,1};
        int[]dy = {1,-1,0,0};
        char[]ways = {'R','L','U','D'};
        for (int i = 0; i < 4; i++) {
            int row = r+dx[i];
            int col = c+dy[i];
            if (row<0||col<0||row>=maze.length||col>=maze.length||maze[row][col]==0)
                continue;
            getAllPaths(maze,row,col,s+ways[i],res);

        }
        maze[r][c] = 1;
    }

    public static void main(String[] args) {
        int[][]maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
//        boolean[][] visited = new boolean[maze.length][maze.length]; can be used
        List<String> res = new ArrayList<>();
        getAllPaths(maze,0,0,"",res);
        Collections.sort(res);
        System.out.println(res);
    }
}
