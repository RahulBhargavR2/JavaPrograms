package codingChallenge.stack;

//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class MinStack {
    private static class Node {
        int data;
        int min;
        Node next;

        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
//        public Node(int data, int min,Node next) {
//            this.data = data;
//            this.min = min;
//            this.next = next;
//        }
    }

//    public void push(int x) {
//        if (head == null)
//            head = new Node(x, x, null);
//        else
//            head = new Node(x, Math.min(x, head.min), head);
//    }

    private Node head = null;
    public void push(int val) {
        Node n;
        if (head == null) {
            head = new Node(val, val);
        } else {
            n = new Node(val, val < head.min ? val : head.min);
            n.next = head;
            head = n;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.data;
    }

    public int getMin() {
        return head.min;
    }

    public static void main(String[] args) {

    }
}