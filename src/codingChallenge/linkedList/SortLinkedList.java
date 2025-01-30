package codingChallenge.linkedList;

public class SortLinkedList {

    private static Node findMid(Node node){
        if(node == null || node.next == null)
                return node;
        Node slow = node, fast = node.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static Node mergeSort(Node node){
        if(node == null || node.next == null)
            return node;
        Node mid = findMid(node);
        Node second = mid.next;
        mid.next = null;
        Node first = node;

        first = mergeSort(first);
        second = mergeSort(second);

        return merge(first,second);
    }

    private static Node merge(Node first, Node second){
        Node temp = new Node(-1), head = temp;
        while (first!=null && second != null){
            if (first.data<=second.data){
                temp.next = first;
                first = first.next;
            }
            else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        if(first == null)
            temp.next = second;
        else temp.next = first;
        return head.next;
    }

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private static void print(Node node){
        Node temp = node;
        while (temp!=null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        Node fir = new Node(4);
        fir.next = new Node(2);
        fir.next.next= new Node(1);
        fir.next.next.next= new Node(3);
//        fir.next.next.next.next = new Node(5);
//        fir.next.next.next.next.next= new Node(6);

        Node fin = mergeSort(fir);
        print(fin);
    }
}
