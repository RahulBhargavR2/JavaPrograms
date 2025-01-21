package dataStructures;

import static dataStructures.Priority.*;

@SuppressWarnings("unused")
enum Priority {
    MAX(10), MID(5), LOW(1);

    public final int Priority;

    Priority(int i) {
        this.Priority = i;
    }
}

@SuppressWarnings("unused")
public class PriorityQueue {
    static class Node {
        int data;
        int priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }

    }

    Node head = null;

    private void push(int data, int priority) {
    }

    private void show() {
        if (head == null) {
            System.out.println("No queue");
            return;
        }
        for (Node node = head; node != null; node = node.next) System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        PriorityQueue p = new PriorityQueue();
        p.push(10, MAX.Priority);
        p.push(11, MID.Priority);
        p.show();
    }
}



