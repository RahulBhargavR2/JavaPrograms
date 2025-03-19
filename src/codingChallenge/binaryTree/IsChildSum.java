package codingChallenge.binaryTree;

public class IsChildSum {
    static class Node{
        int data;
        Node right,left;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }

    private static boolean isChildSum(Node root){
        if (root == null)
            return true;
        if (root.left == null &&  root.right == null)
            return true;
        int left = root.left!=null?root.left.data:0;
        int right = root.right!=null?root.right.data:0;

        if (root.data != left+right)
            return false;
        return isChildSum(root.left) && isChildSum(root.right);
    }
}
