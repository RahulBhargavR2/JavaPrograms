package codingChallenge.graph;

import java.util.*;

public class DetectCycleUnd {
    static class Node {
       int fir;
       int sec;

        public Node(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

    private static boolean checkForCycleBFS(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int start){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start,-1));
        visited[start] = true;
        while (!queue.isEmpty()){
            int ele = queue.peek().fir;
            int parent = queue.peek().sec;
            queue.poll();
            for (int i:adj.get(start)){
                if (!visited[i]) {
                    queue.add(new Node(i, ele));
                    visited[i] = true;
                }
                else if(parent != i)
                        return true;
            }
        }
        return false;
    }


    private static boolean checkForCycleDFS(ArrayList<ArrayList<Integer>> adj,boolean[]visited, int start, int parent){
        visited[start] = true;
        for (int i:adj.get(start)){
           if (!visited[i])
               if(checkForCycleDFS(adj,visited,i,start))
                   return true;
           else if (i!=parent)
               return true;
        }
        return false;
    }

    private static boolean detectCycle(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visited = new boolean[v];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i])
                if (checkForCycleBFS(adj, visited, i))
                    return true;
        }
        return false;
    }
}
