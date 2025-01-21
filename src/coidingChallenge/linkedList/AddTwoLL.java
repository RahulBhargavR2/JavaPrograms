package coidingChallenge.linkedList;

public class AddTwoLL {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static int handleCarry(Node node, int carry) {
        while (node != null) {
            node.data += carry;
            carry = 0;
            if (node.data > 9) {
                carry = (node.data % 100) / 10;
                node.data = node.data % 10;
            }
            node = node.next;
        }
        return carry;
    }

    private static Node addTwoNumbers(Node l1, Node l2) {
        Node temp1 = l1, temp2 = l2;
        int carry = 0;
        while (temp1 != null && temp2 != null) {
            temp1.data += temp2.data + carry;
            carry = 0;
            if (temp1.data > 9) {
                carry = (temp1.data % 100) / 10;
                temp1.data = temp1.data % 10;
            }
            temp2.data = temp1.data;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        int check = 0;
        if (temp1 != null || temp2 != null) {
            // check = temp1!=null?handleCarry(temp1,carry):handleCarry(temp2,carry);
            if (temp1 != null) {
                check = handleCarry(temp1, carry);
            } else {
                check = handleCarry(temp2, carry);
                l1 = l2;
            }
            carry = 0;
        }
        if (check !=0 || carry != 0) {
            Node prev = l1;
            while (prev.next != null)
                prev = prev.next;
            prev.next = new Node(carry!=0?carry:check);
        }
        return l1;
    }

    private static void print(Node node){
        Node temp = node;
        while (temp!=null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node fir = new Node(9);
        fir.next = new Node(9);
        fir.next.next= new Node(1);

        Node sec = new Node(1);

        Node n = addTwoNumbers(fir,sec);
        print(n);
    }
}
