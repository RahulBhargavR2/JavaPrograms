package codingChallenge.binaryTree;

//count nodes in complete Binary tree
public class CountNodes {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }


    private static int findLeftHeight(Node root){
        int h = 0;
        while (root!=null){
            root = root.left;
            h++;
        }
        return h;
    }

    private static int findRightHeight(Node root) {
        int h = 0;
        while (root != null) {
            root = root.right;
            h++;
        }
        return h;
    }
    // as it's a complete BT if height of left and right are same then its height is 2^n - 1.
    // if heights are not equal then we travers to left and right nodes and do the same.
    private static int countNodes(Node root){
        if (root == null)
            return 0;
        int lh = findLeftHeight(root.left);
        int rh = findLeftHeight(root.right);
        if(lh == rh)
            return (1<<lh) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
