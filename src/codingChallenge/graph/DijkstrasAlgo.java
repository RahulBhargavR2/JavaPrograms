package codingChallenge.graph;

import java.util.*;

public class DijkstrasAlgo {
    static class Node {
        int v, weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }

    private static int[] dijkstras(ArrayList<ArrayList<Node>> adj, int src) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((v -> v.weight)));
        Map<Integer, Node> map = new HashMap<>();
        int v = adj.size();
        boolean[] visited = new boolean[v];
        queue.add(new Node(src, 0));
        // using map allows to access the node faster with its current and latest best path with the least weight
        map.put(src, new Node(src, 0));
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            visited[curr.v] = true;
            // get all the adjacent nodes of current element that is popped node
            for (Node n : adj.get(curr.v)) {
                if (!visited[n.v]) {
                    // if not visited and the node is first time
                    if (!map.containsKey(n.v))
                        map.put(n.v, new Node(n.v, curr.weight + n.weight));
                    else {
                        Node m = map.get(n.v);
                        if (curr.weight + n.weight < m.weight) {
                            m.v = curr.v;
                            m.weight = curr.weight + n.weight;
                        }
                    }
                    queue.add(new Node(n.v, curr.weight + n.weight));
                }
            }
        }
        int[] distance = new int[v];
        for (int i = 0; i < v; i++) {
            distance[i] = map.get(i).weight;
        }
        return distance;
    }
}
