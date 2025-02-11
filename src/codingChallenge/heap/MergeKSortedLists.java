package codingChallenge.heap;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }

        ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    private static class HeapNode implements Comparable<HeapNode> {
        int i;
        ListNode node;

        public HeapNode(int i, ListNode node) {
            this.i = i;
            this.node = node;
        }

        @Override
        public int compareTo(@NotNull HeapNode o) {
//            return this.node.data > o.node.data ? 1 : this.node.data == o.node.data ? 0 : -1;
            return Integer.compare(this.node.data,o.node.data);
        }

    }

    //using same strategy as merge k arrays, add first elements of all lists
    private static ListNode mergeKLists(ListNode[] arr) {
        PriorityQueue<HeapNode> heap = new PriorityQueue<>();
        ListNode result = null, tail = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                continue;
            heap.add(new HeapNode(i, arr[i]));
            arr[i] = arr[i].next;//shift pointer to next
        }

        while (!heap.isEmpty()) {
            HeapNode temp = heap.poll();
            // add element to result
            if (tail == null) {
                result = tail = temp.node;
            } else {
                tail.next = temp.node;
                tail = temp.node;
            }
            // add next element from popped array to heap
            if (arr[temp.i] != null) {
                heap.add(new HeapNode(temp.i, arr[temp.i]));
                arr[temp.i] = arr[temp.i].next;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode[] arr = {new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };
        ListNode node = mergeKLists(arr);
        System.out.println(node);
    }
}
