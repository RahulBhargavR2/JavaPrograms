package codingChallenge.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPaths {
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static void allPaths(Node root, Stack<Integer> st, List<List<Integer>> res){
        if (root == null)
            return;
        st.push(root.data);
        if (root.right == null && root.left == null){
            res.add(new ArrayList<>(st));
            st.pop();
            return;
        }
        allPaths(root.left,st,res);
        allPaths(root.right,st,res);
        st.pop();
    }
    private static List<List<Integer>> Paths(Node root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<Integer> st = new Stack<>();
        allPaths(root,st,res);
        return res;
    }
}
