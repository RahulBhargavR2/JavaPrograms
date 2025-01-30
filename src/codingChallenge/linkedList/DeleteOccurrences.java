package codingChallenge.linkedList;

public class DeleteOccurrences {

    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
    }

    private static Node removeAllOccurrences(Node head, int val) {
        while (head != null && head.data == val)
            head = head.next;
        if (head == null)
            return null;
        head.prev = null;

        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                temp.prev.next = temp.next;
                if (temp.next != null)
                    temp.next.prev = temp.prev;
            }
            temp = temp.next;
        }
        return head;
    }

    static Node head = null, tail = null;

    private static void add(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = tail.next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 2, 4, 8, 10, 2, 2};
        for (int i : arr)
            add(i);
        removeAllOccurrences(head, 2);
    }
}
