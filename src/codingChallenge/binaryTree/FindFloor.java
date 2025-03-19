package codingChallenge.binaryTree;

public class FindFloor {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    private static int findFloor(Node root, int key){
        if (root == null)
            return -1;
        if (root.data == key)
            return key;
        if (root.data>key)
            return findFloor(root.left,key);
        int floor = findFloor(root.right, key);

        return Math.max(floor, root.data);
    }
}
