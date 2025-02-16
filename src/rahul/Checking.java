package rahul;

import java.util.*;

public class Checking {


    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static ListNode oddEvenList(ListNode head) {
        if (!(head != null && head.next != null && head.next.next != null))
            return head;
        ListNode odd = head, evenTemp = head.next, even = head.next;
        while (even != null) {
            odd.next = even.next;
            // if(even.next.next == null){
            //     even.next = null;
            //     break;
            // }
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        System.out.println(head.val);
        odd.next = evenTemp;
        return head;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            int one = scan.nextInt();
            int two = scan.nextInt();
            sb.append("1".repeat( one / 2));
            sb.append("2".repeat(two));
            sb.append("1".repeat( one / 2));
            System.out.println(sb);
        }

    }
}
