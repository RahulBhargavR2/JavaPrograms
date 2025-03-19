package codingChallenge.binaryTree;

public class IsBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static long prev = Long.MIN_VALUE;

    private static boolean isBST(Node root) {
        if (root == null)
            return true;
        boolean left = isBST(root.left);
        if (root.data > prev)
            return false;
        prev = root.data;
        boolean right = isBST(root.right);
        return left && right;
    }

    public static void main(String[] args) {

    }

}
