package codingChallenge.graph;

import java.util.*;

public class ShortestPathInDAG {
    static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // brute force approach where all possible paths are explored and distance is updated
    private static void dfs(List<List<Node>> adj, int src, int currW, int[] distance) {
        for (Node i : adj.get(src)) {
            dfs(adj, i.vertex, currW + i.weight, distance);
        }
        distance[src] = Math.min(currW, distance[src]);
    }

    private static int[] findShortest(int v, int e, int[][] edges) {
        List<List<Node>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new LinkedList<>());
        }
        for (int i = 0; i < e; i++) {
            int from = edges[i][0], to = edges[i][1];
            adj.get(from).add(new Node(to, edges[i][2]));
        }
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        dfs(adj, 0, 0, distance);
        for (int i = 0; i < v; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        }
        return distance;
    }


    // optimal soln

    //    get the topological ordering of the graph
    private void topoSort(int node, ArrayList<ArrayList<Node>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).vertex;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Node(v, wt));
        }
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        int[] dist = new int[N];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        // for each node that is taken from stack, check for all its adjacent nodes and update the distance
        // from the current node to its adjacent node if the distance is smaller than the current distance of
        // destination node, if two paths leads to same node then we need to consider the smaller one
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).vertex;
                int wt = adj.get(node).get(i).weight;
                if (dist[node] + wt < dist[v]) { // if distance from current node is smaller than the previous distance
                    dist[v] = wt + dist[node]; // update its distance
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }


    public static void main(String[] args) {
    }
}

