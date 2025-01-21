package coidingChallenge.linkedList;

public class RemoveDuplicates {

    static class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            this.prev = this.next = null;
        }
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

    static Node removeDuplicates(Node head) {
        // Code Here.
        Node temp = head;
        while (temp != null) {
            Node prev = temp;
            while (temp.next != null && temp.data == temp.next.data) {
                temp = temp.next;
            }
            prev.next = temp.next;
            if (temp.next != null) temp.next.prev = prev;
            temp = temp.next;
        }
        return head;
    }

    private static void print(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 4};
        for (int i : arr)
            add(i);
        Node temp = removeDuplicates(head);
        print(temp);
    }

}
