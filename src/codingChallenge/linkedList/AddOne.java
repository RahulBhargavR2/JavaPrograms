package codingChallenge.linkedList;

public class AddOne {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static int addOne(Node head){
        if (head == null)
            return 1;
        int carry = addOne(head.next);
        head.data += carry;
        if(head.data<10)
            return 0;
        head.data = 0;
        return 1;
    }

    private static void print(Node head){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node fir = new Node(0);
        fir.next = new Node(0);
        fir.next.next= new Node(0);
        fir.next.next.next= new Node(0);
        int carry = addOne(fir);
        Node n = new Node(1);
        if (carry == 1){
            n.next = fir;
            fir = n;
        }
        System.out.println(carry);
        print(fir);
    }
}
