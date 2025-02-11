package dataStructures;

public class AVLTrees {
    // Node class to define the structure of the tree node
    static class Node {
        int data;
        int height;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.right = null;
            this.left = null;
        }
    }

//    Node node;

    int height(Node n) {
        return n == null ? 0 : n.height;
    }

    int max(int a, int b) {
        return Math.max(a, b);
    }

    private Node rightRotate(Node n) {
        Node leftOfUnbalanced = n.left;
        Node rightOfLeftOfUnbalanced = leftOfUnbalanced.right;
        //rotate right
        leftOfUnbalanced.right = n;
        n.left = rightOfLeftOfUnbalanced;

        leftOfUnbalanced.height = max(height(leftOfUnbalanced.right), height(leftOfUnbalanced.left)) + 1;
        n.height = max(height(n.right), height(n.left)) + 1;
        return leftOfUnbalanced;
    }

    private Node leftRotate(Node n) {
        Node rightOfUnbalanced = n.right;
        Node leftOfRightOfUnbalanced = rightOfUnbalanced.left;
        //rotate left
        rightOfUnbalanced.left = n;
        n.right = leftOfRightOfUnbalanced;

        rightOfUnbalanced.height = max(height(rightOfUnbalanced.right), height(rightOfUnbalanced.left)) + 1;
        n.height = max(height(n.right), height(n.left)) + 1;
        return rightOfUnbalanced;
    }

    private int getBalanceFactor(Node n) {
        if (n == null) return 0;
        return height(n.left) - height(n.right);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) node.left = insert(node.left, data);
        else if (data > node.data) node.right = insert(node.right, data);
        else return node;

        node.height = max(height(node.right), height(node.left)) + 1;

        int balanceFactor = getBalanceFactor(node);
        //left rotate
        if (balanceFactor < -1 && data > node.right.data)
            return leftRotate(node);
        //right rotate
        if (balanceFactor > 1 && data < node.left.data)
            return rightRotate(node);
        //left right rotate
        if (balanceFactor > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        //right left rotate
        if (balanceFactor < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private static void inorder(Node n) {
        if (n == null) return;
        inorder(n.left);
        System.out.println(n.data);
        inorder(n.right);
    }

    public static void main(String[] args) {
        AVLTrees tree = new AVLTrees();
        Node root = null;
        int[] arr = {10, 20, 30, 40, 50};
        for (int i : arr)
            root = tree.insert(root, i);
        inorder(root);
    }
}
