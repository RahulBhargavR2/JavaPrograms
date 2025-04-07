package codingChallenge.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DetectCycleDi {
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        int[] inDegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int e : adj.get(i))
                inDegree[e]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i : adj.get(curr)) {
                inDegree[i]--;
                if (inDegree[i] == 0)
                    queue.add(i);
            }
            count++;
        }

        for(int i:inDegree)
            if(i != 0 )
                return true;
        return false;

        // better approach
//        return count!=v;
    }

//    using DFS
    private static boolean isCyclic(ArrayList<ArrayList<Integer>>adj,int start,boolean[]visited,boolean[]atStack){
        if (atStack[start])
            return true;
        atStack[start] = true;
        visited[start] = true;
        for (int i:adj.get(start)){
            if (!visited[i] && isCyclic(adj,i,visited,atStack))
                return true;
            else if (atStack[i])
                    return true;
        }
        atStack[start] = false;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(List.of(1)));
        adj.add(new ArrayList<>(List.of(0)));
        adj.add(new ArrayList<>(List.of(1)));
        System.out.println(isCyclic(adj));
    }
}
