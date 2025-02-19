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
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0) {
            int size = scan.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                map.merge(scan.nextInt(), 1, Integer::sum);
            }
            int count = 0;
            for (int i : map.keySet()) {
                if (i == 0)
                    continue;
                if (map.get(i) == 1)
                    count++;
//                else map.merge(0, 1, Integer::sum);
            }
            System.out.println(map.containsKey(0) ? count + 1 : count);
        }

    }
}
