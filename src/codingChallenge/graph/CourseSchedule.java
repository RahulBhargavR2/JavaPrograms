package codingChallenge.graph;

import OOPs.List;
import rahul.LinearSearch;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    private static boolean canFinish(int n, int[][] pre){
        int[] inDegree = new int[n];
        List<Integer>[] adj = new List[n];

        for (int i = 0; i < pre.length; i++) {
            int from = pre[i][1], to = pre[i][0];
            if (adj[from] == null)
                adj[from] = (List<Integer>) new LinkedList<Integer>();
            adj[from].add(to);
            inDegree[to]++;
        }
//        int[] res = new int[n];
//        int k=0;
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (inDegree[i]==0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int curr = queue.poll();
//            res[k++] = curr; for course schedule 2 problem
            if (adj[curr] != null) {
                for (int i=0;i< adj[curr].size();i++) {
                    int e = adj[curr].get(i);
                    inDegree[e]--;
                    if (inDegree[e]==0)
                       queue.add(e);
                }
            }
            ++count;
        }
        return count==n;
    }
}
