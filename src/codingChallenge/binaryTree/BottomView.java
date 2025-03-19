package codingChallenge.binaryTree;

import java.util.*;

public class BottomView {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // using DFS
    static class Pair {
        int data;
        int level;

        public Pair(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }

    private static void dfs(Node root, int col, int level, Map<Integer, Pair> map) {
        if (root == null)
            return;
        if (!map.containsKey(col) || map.get(col).level <= level)
            map.put(col, new Pair(root.data, level));
        dfs(root.left, col - 1, level + 1, map);
        dfs(root.right, col + 1, level + 1, map);
    }

    public static List<Integer> bottomViewDFS(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, Pair> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        for (int i : map.keySet())
            res.add(map.get(i).data);
        return res;
    }


    // using bfs
    static class TempNode {
        Node root;
        int col;

        public TempNode(Node root, int col) {
            this.root = root;
            this.col = col;
        }
    }

    private static List<Integer> bottomViewBFS(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TempNode> queue = new LinkedList<>();
        queue.add(new TempNode(root, 0));
        while (!queue.isEmpty()) {
            TempNode temp = queue.poll();
            map.put(temp.col, temp.root.data);
            if (temp.root.left != null)
                queue.add(new TempNode(temp.root.left, temp.col - 1));
            if (temp.root.right != null)
                queue.add(new TempNode(temp.root.right, temp.col + 1));
        }
        for (int i : map.keySet())
            res.add(map.get(i));
        return res;
    }
}