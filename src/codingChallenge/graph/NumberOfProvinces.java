package codingChallenge.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    private static void bfsProvince(int[][] ajd, boolean[] visited, int start) {
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < ajd.length; i++) {
                if (ajd[curr][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfsProvince(int[][] adj, boolean[] visited, int start) {
        visited[start] = true;
        for (int i = 0; i < adj.length; i++)
            if (!visited[i] && adj[start][i] == 1)
                dfsProvince(adj, visited, i);
    }

    private static int noOfProvinces(int[][] adj) {
        int v = adj.length;
        boolean[] visited = new boolean[v];
        int count = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                count++;
//                bfsProvince(adj, visited, i);
//                dfsProvince(adj, visited, i);
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
