package codingChallenge.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Find Eventual Safe States
//https://leetcode.com/problems/find-eventual-safe-states/
public class SafeStates {
    private static boolean dfs(int[][] graph, List<Integer> res, int start,
                               boolean[] visited, boolean[] atStack) {
        //atStack to track weather the node is at stack before which concludes that there is a loop
        // and that node will not have a safe state as all the paths that leaves from that node should end up in
        // a terminal state, and having loop will never let that node go to a terminal node.
        if (atStack[start])
            return true;
        atStack[start] = visited[start] = true;
        for (int i : graph[start]) {
            if (!visited[i] && dfs(graph, res, i, visited, atStack))
                return true;
            else if (atStack[i])
                return true;
        }
        res.add(start);
        atStack[start] = false;
        return false;
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        int v = graph.length;
        boolean[] visited = new boolean[v];
        boolean[] atStack = new boolean[v];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(graph, res, i, visited, atStack);
        }
        Collections.sort(res);
        return res;
    }
}
