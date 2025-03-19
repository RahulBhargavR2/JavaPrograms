package codingChallenge.binaryTree;

import java.util.*;

public class TopViewOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    record Pair(int data, int level) {

    }
//
//    static class Pair {
//        private final int data;
//        private final int level;
//
//        public int getData() {
//            return data;
//        }
//
//        public int getLevel() {
//            return level;
//        }
//
//        public Pair(int data, int level) {
//            this.data = data;
//            this.level = level;
//        }
//    }

    // checks if the horizontal distance from the root is new or first time its reaching this distance
    // if true add it to map along with its horizontal distance.
    private static void dfs(Node root, int horDist, int level, Map<Integer, Pair> topNodes) {
        if (root == null)
            return;
        // due to DFS lower node will be visited first rather than the topmost node so if you find a node with lower
        //level in same column you change it to the node with the lowest node;
        if (!topNodes.containsKey(horDist) || topNodes.get(horDist).level() > level)
            topNodes.put(horDist, new Pair(root.data, level));
        dfs(root.left, horDist - 1, level + 1, topNodes);
        dfs(root.right, horDist + 1, level + 1, topNodes);
    }

//    using level-order traversal
//    private static void bfs(Node root,Map<Integer,Integer> topNodes){
//
//    }

    private static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Map<Integer, Pair> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        for (int i : map.keySet())
            res.add(map.get(i).data());
        return res;
    }



    static class TempNode{
        Node root;
        int col;

        public TempNode(Node root, int col) {
            this.root = root;
            this.col = col;
        }
    }
    private static ArrayList<Integer> topViewBFS(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null)
            return arr;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<TempNode> queue = new LinkedList<>();
        queue.add(new TempNode(root,0));
        while (!queue.isEmpty()){
            TempNode temp = queue.poll();
            if (!map.containsKey(temp.col))
                map.put(temp.col,temp.root.data);
            if (temp.root.left!=null)
                queue.add(new TempNode(root.left,temp.col-1));
            if (temp.root.right!=null)
                queue.add(new TempNode(root.right,temp.col+1));
        }
        for (int i: map.keySet())
            arr.add(map.get(i));
        return arr;
    }

    public static void main(String[] args) {
    }
}
