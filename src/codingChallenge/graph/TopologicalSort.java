package codingChallenge.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    // take a non visited node and traverse recursively till a child that has no children appear
    // as we are using stack we can maintain the order that the parent will appear before the child
    // topological order can be defined as a edge u->v the  vertex u should always appear before v
    private static void dfs(ArrayList<ArrayList<Integer>> adj, Stack<Integer> st,
                            int start, boolean[] visited) {
        visited[start] = true;
        for (int i : adj.get(start)) {
            if (!visited[i])
                dfs(adj, st, i, visited);
        }
        st.push(start);
    }

    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(adj, st, i, visited);
        }
        ArrayList<Integer> res = new ArrayList<>(v);
        while (!st.isEmpty())
            res.add(st.pop());
        return res;
    }


    private static ArrayList<Integer> kahnsAlgo(ArrayList<ArrayList<Integer>> adj, int v) {
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int e : adj.get(i))
                inDegree[e]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int i : adj.get(curr)) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    queue.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
