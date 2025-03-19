package codingChallenge.binaryTree;

public class MaxLength {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    static int maxLen = Integer.MIN_VALUE;

    private static int length(Node root) {
        if (root == null)
            return 0;
        int left = length(root.left);
        int right = length(root.right);
        maxLen = Math.max(maxLen, left + right);
        return Math.max(left, right) + 1;
    }

    private static int maxLength(Node root) {
        if (root == null)
            return 0;
        length(root);
        return maxLen;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        System.out.println(maxLength(root));
    }
}
