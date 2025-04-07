package codingChallenge.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversals {
    // BFS for all connected nodes
    private static void bfs(List<List<Integer>> ajd, boolean[] visited, int start, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int i : ajd.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    //for disconnected nodes just call above bfs for all non-reachable nodes one by one
    private static List<Integer> bfs(List<List<Integer>> adj) {
        List<Integer> res = new LinkedList<>();
        int v = adj.size();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                bfs(adj, visited, i, res);
        }
        return res;
    }

    //DFS
    private static void dfs(List<List<Integer>> adj, List<Integer> res, boolean[] visited, int start){
        visited[start] = true;
        res.add(start);
        for (int i:adj.get(start)) {
            if (!visited[i])
                dfs(adj, res, visited, i);
        }
    }
    // for disconnected nodes
    private static List<Integer> dfs(List<List<Integer>> adj){
        int v = adj.size();
        boolean[] visited = new boolean[v];
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(adj,res,visited,i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}