package codingChallenge.binaryTree;

public class FindCeil {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static int val = Integer.MAX_VALUE;

    private static void ceil(Node root, int key) {
        if (root == null)
            return;
        if (root.data >= key)
            val = Math.min(root.data, val);
        if (key < root.data)
            ceil(root.left, key);
        else ceil(root.right, key);
    }

    private static int findCeil(Node root, int key) {
        if (root == null)
            return -1;
        ceil(root, key);
        return val == Integer.MAX_VALUE ? -1 : val;
    }

    public static void main(String[] args) {

    }
}
