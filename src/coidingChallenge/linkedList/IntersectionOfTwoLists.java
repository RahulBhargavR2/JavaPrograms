package coidingChallenge.linkedList;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLists {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        Set<Node> set = new HashSet<>();
        Node temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    private static Node getIntersectionNodeBetter(Node headA, Node headB) {
        Node temp1 = headA, temp2 = headB;

        while (temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }
        return temp1;
    }

}
