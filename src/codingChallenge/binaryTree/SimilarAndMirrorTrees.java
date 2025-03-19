package codingChallenge.binaryTree;

public class SimilarAndMirrorTrees {
    static class Node{
        int data;
        Node left,right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
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

    private static boolean isSimilar(Node root1, Node root2){
        if (root1 == null || root2 == null)
            return root1 == root2;
        if (root1.data != root2.data)
            return false;
        return isSimilar(root1.left,root2.left) && isSimilar(root1.right,root2.right);
    }


    private static boolean isMirrorHelper(Node left, Node right){
        if (left==null || right== null)
            return left == right;
        if (left.data!=right.data)
            return false;
        return isMirrorHelper(left.left,right.right) && isMirrorHelper(left.right,right.left); // traverse in opposite direction
    }
    private static boolean isMirror(Node root){
        if(root == null)
            return true;
        return isMirrorHelper(root.left,root.right);
    }
}
