package codingChallenge.binaryTree;

public class InvertTree {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static void invert(Node root) {
        if (root == null)
            return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    private static void inorder(Node root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static Node add(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        } else if (data < root.data) root.left = add(root.left, data);
        else root.right = add(root.right, data);
        return root;
    }
    public static void main(String[] args) {
        int[] arr = {25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90};
        Node root  = null;
        for(int i:arr)
            root = add(root,i);
        inorder(root);
        invert(root);
        System.out.println();
        inorder(root);
    }

}
