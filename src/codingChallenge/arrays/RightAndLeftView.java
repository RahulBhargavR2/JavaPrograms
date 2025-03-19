package codingChallenge.arrays;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightAndLeftView {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.data = data;
            this.right = this.left = null;
        }
    }


    private static List<Integer> rightView(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(queue.peek().data);
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                assert temp != null;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
        return res;
    }

    private static List<Integer> leftView(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node temp = null;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                assert temp != null;
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
            res.add(temp.data);
        }
        return res;
    }
}
