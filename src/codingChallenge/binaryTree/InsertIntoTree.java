package codingChallenge.binaryTree;

public class InsertIntoTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public Node insertIntoBST(Node root, int val) {
        if (root == null)
            return new Node(val);
        Node curr = root, prev = null;
        while (curr != null) {
            prev = curr;
            if (val > curr.data)
                curr = curr.right;
            else curr = curr.left;
        }
        if (val > prev.data)
            prev.right = new Node(val);
        else prev.left = new Node(val);
        return root;
    }
}
