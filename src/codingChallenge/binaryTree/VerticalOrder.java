package codingChallenge.binaryTree;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class VerticalOrder {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    //using normal method my own idea

    static class NormalNode implements Comparable<NormalNode> {
        Node root;
        int column;
        int level;

        public NormalNode(Node root, int column, int level) {
            this.root = root;
            this.column = column;
            this.level = level;
        }

        @Override
        public int compareTo(@NotNull NormalNode o) {
            return Integer.compare(this.root.data, o.root.data);
        }
    }

    private static List<List<Integer>> verticalOrder(Node root) {
        Queue<NormalNode> queue = new LinkedList<>();
        queue.add(new NormalNode(root, 0, 0));
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<NormalNode> res = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                NormalNode temp = queue.poll();
                if (temp.root.left != null)
                    queue.add(new NormalNode(temp.root.left, temp.column - 1, temp.level + 1));
                if (temp.root.right != null)
                    queue.add(new NormalNode(temp.root.right, temp.column + 1, temp.level + 1));
                res.add(temp);
            }
            Collections.sort(res);
            for (NormalNode t : res) {
                if (!map.containsKey(t.column))
                    map.put(t.column, new ArrayList<>(List.of(t.root.data)));
                else map.get(t.column).add(t.root.data);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i : map.keySet())
            result.add(map.get(i));
        return result;
    }


    // using priority Queue, slightly borrowed idea
    private static class PriorityNode {
        int data;
        int column;
        int level;

        public PriorityNode(int data, int column, int level) {
            this.data = data;
            this.column = column;
            this.level = level;
        }
    }

    private static List<List<Integer>> verticalOrder2(Node root) {
        PriorityQueue<PriorityNode> queue = new PriorityQueue<>((a, b) -> {
            if (a.column == b.column) {
                if (a.level == b.level)
                    return Integer.compare(a.data, b.data);
                return Integer.compare(a.level, b.level);
            }
            return Integer.compare(a.column, b.column);
        });
        int prev = Integer.MIN_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        while (!queue.isEmpty()) {
            PriorityNode temp = queue.poll();
            if (temp.column != prev) {
                prev = temp.column;
                col = new ArrayList<>(List.of(temp.data));
                result.add(col);
            } else col.add(temp.data);
        }

        return result;
    }
    //using DFS to add all nodes to priority queue along with  their row and column 
    private static void fill(PriorityQueue<PriorityNode> queue, Node root, int column, int level) {
        if (root == null)
            return;
        queue.add(new PriorityNode(root.data, column, level));
        fill(queue, root.left, column - 1, level + 1);
        fill(queue, root.right, column + 1, level + 1);
    }
}