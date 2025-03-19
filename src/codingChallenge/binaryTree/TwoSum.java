package codingChallenge.binaryTree;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    static class Node{
        int data;
        Node left,right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // using property of bst
    private static boolean search(Node root,int key){
        while (root!=null){
            if (root.data == key)
                return true;
            root = key<root.data?root.left:root.right;
        }
        return false;
    }

    private static boolean isPresent(Node root, Node topRoot, int target){
        if (root == null)
            return false;
        int diff = target - root.data;
        if(diff<root.data)
            if (search(topRoot.left,diff))
                return true;
        if (diff>root.data)
            if (search(topRoot.right,diff))
                return true;
        return isPresent(root.left,topRoot,target)||isPresent(root.right,topRoot,target);
    }
//    private static boolean isPresent(Node root, int target){
//        return isPresent(root,root,target);
//    }

    // using hashset

    private static boolean isPresent(Node root, Set<Integer>set,int target){
        if (root == null)
            return false;
        if (set.contains(target-root.data))
            return true;
        set.add(root.data);

        return isPresent(root.left,set,target) && isPresent(root.right,set,target);
    }

//    private static boolean isPresent(Node root,int target){
//        return isPresent(root,new HashSet<>(),target);
//    }

    public static void main(String[] args) {

    }
}
