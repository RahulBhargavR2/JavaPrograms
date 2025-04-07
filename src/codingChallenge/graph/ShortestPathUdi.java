package codingChallenge.graph;

import java.util.*;

// for a unit weight edge graph
public class ShortestPathUdi {

    //using normal BFS should be sufficient as the weight of edges are 1
    private static int[] findDistance(ArrayList<ArrayList<Integer>> adj, int src) {
        Queue<Integer> queue = new ArrayDeque<>();
        int v = adj.size(), currLevel = 0;
        int[] res = new int[v];
        Arrays.fill(res, Integer.MAX_VALUE);
        Arrays.fill(res, -1);

        res[src] = 0;
//        boolean[] visited = new boolean[v];
        queue.add(src);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : adj.get(curr)) {
                if (res[curr] + 1 < res[i]) {
                    res[i] = res[curr] + 1;
                    queue.add(i);
                }
            }
        }

//        while (!queue.isEmpty()){
//            int size = queue.size();
//            currLevel++;
//            for (int i = 0; i < size; i++) {
//                int curr = queue.poll();
//                for(int e:adj.get(curr)){
//                if (!visited[e]){
//                    queue.add(e);
//                    res[e] = currLevel;
//                }
//                }
//            }
//        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((int) 1e9);
        System.out.println(Integer.MAX_VALUE);
    }
}
