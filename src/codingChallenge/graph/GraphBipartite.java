package codingChallenge.graph;

import java.util.Arrays;

public class GraphBipartite {
    /*
 works but... its lengthy and difficult to read and understand what's happening
 works by considering 2 sets if children of a node ends up in both the nodes then it's not bipartite
 take 2 sets add first node to set, then add all its children to second set now repeat the same with second set
 add all its children of nodes to set1 if any child can be divided into both sets then it's not bipartite
    private static boolean bfs(int[][]adj,boolean[]visited, int start){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        set1.add(0);
        visited[0] = true;
        int ite = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int ele = queue.poll();
                for (int e:adj[ele]){
                    if (!visited[e]){
                        if ((ite&1)==0){
                            if (set1.contains(e))
                                return true;
                            set2.add(e);
                        }
                        else {
                            if (set2.contains(e))
                                return true;
                            set1.add(e);
                        }
                    }
                    queue.add(e);
                }

            }
            ++ite;
        }
        return false;
    }
     */
    // based on coloring of nodes in opposite manner
    private static boolean dfs(int[][] mat, int color, int[] colors, int start) {
        colors[start] = color;
        for (int i : mat[start]) {
            if (colors[i] == -1) {
                if (!dfs(mat, 1 - color, colors, i)) // call with opposite of present color if not colored
                    return false;
            } else {
                if (colors[i] == color) // if colored and have same color as present one then it won't be bipartite
                    return false;
            }
        }
        return true;
    }

    private static boolean isGraphBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors, -1);
        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, 0, colors, i))
                    return false;
            }
        }
        return true;
    }
}
