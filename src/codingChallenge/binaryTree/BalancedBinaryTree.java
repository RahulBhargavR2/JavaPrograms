package codingChallenge.binaryTree;

public class BalancedBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    public static Node add(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) root.left = add(root.left, data);
        else root.right = add(root.right, data);
        return root;
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }


    private static int height(Node root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        return 1 + Math.max(left, right);

    }

    private static boolean isBalanced(Node root) {
        if (root == null)
            return true;
        isBalanced(root.left);
        isBalanced(root.right);
        int diff = Math.abs(height(root.left) - height(root.right));
        return diff < 2;
    }

    static boolean res;

    private static int height1(Node root) {
        if (root == null)
            return 0;
        int left = height1(root.left);
        int right = height1(root.right);
        if (Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right) + 1;
    }

    private static boolean isBalanced1(Node root) {
        if (root == null)
            return true;
        res = true;
        height1(root);
        return res;
    }

    public static void main(String[] args) {
//        int[] arr = {25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90};
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {20,10,30,25,35};
        Node root = null;

        for (int j : arr) {
            root = add(root, j);
        }

//        inorder(root);
        System.out.println(isBalanced(root));
    }
}
