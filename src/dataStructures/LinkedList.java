
package dataStructures;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@SuppressWarnings("unused")

public class LinkedList //class named LinkedList
{
    public int SIZE = 0;

    static class Node {
        int data;//for storing value
        Node next;//reference of next node

        private Node(int data) {
            this.data = data;
            next = null;
        }
    }//made static so can be used without creation of instance of a class

    Node head, tail;

    private LinkedList() {
        head = tail = null;
    }

    //Method to add node at end of linked list
    private void addAtEnd(int data) {//method to accept data and create a new node and link it at the end of linked list
        Node node = new Node(data); // new node is created and data is passed to newly created node
        if (head == null)//checks if list is empty
        {
            head = node;//if so makes head as node
        } else {
            tail.next = node;
        }
        tail = node;
        SIZE++;
    }

    //Method to add node at beginning of linked list
    private void addAtFirst(int data) {//create a node and allocate the data,make the node as head
        Node node = new Node(data);
        //node is made head
//        noinspection StatementWithEmptyBody
        if (isEmpty())
            head = tail = node;
        else {
            node.next = head;//link created node to head
            head = node;
        }
        SIZE++;
    }

    private boolean isEmpty() {
        return head == null;
    }

    //Method to return size of Linked list
    private int size() {
        if (isEmpty()) return 0;

        Node n = head;
        int count = 0;
        while (n != null) {
            count++;
            n = n.next;
        }

        return count;
    }

    private int sizeOf() {
        return sizeOf(head);
    }

    private int sizeOf(Node node) {
        if (node == null) return 0;
        return 1 + sizeOf(node.next);
    }


    //Method to find weather given element is present in linked list or not
    private boolean contains(int data) {
        Node node = head;
        while (node != null) {
            if (node.data == data)
                return true;
            node = node.next;

        }
        return false;

    }

    private boolean containsRecursive(int data) {
        return containsRecursive(head, data);
    }

    private boolean containsRecursive(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;

        return containsRecursive(node.next, data);
    }

    //Method to add node at specified position of linked list
    private void insert(int pos, int data) {
        if(pos < 0 || pos >= size()) {
            System.out.println("Index of Of Bound");
            return;
        }
        if (pos == 0) {
            addAtFirst(data);
            return;
        }
        if (pos == size()-1){
            addAtEnd(data);
            return;
        }
        Node n = new Node(data);
        Node temp = head;
        while (--pos >= 0){
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
    }

    //method to return value stored in node from specified position
    private int get(int pos) {
        Node n = head;
        if (pos >= size())
            throw new IndexOutOfBoundsException();
        else {
            while (pos > 0) {
                n = n.next;
                pos--;
            }
            return n.data;
        }

    }

    //method to delete specified node
    private void delete(int pos) {
        Node n = head;
        if (pos == 0)
            head = n.next;
        else if (pos >= size() || pos < 0)
            throw new IndexOutOfBoundsException();
        else {
            while (pos > 1) {
                n = n.next;
                pos--;
            }
        }
        n.next = n.next.next;
        SIZE--;
    }

    //method to remove specific element
    private void remove(int ele) {
        boolean contain = false;
        Node node = head;
        Node oneNext = head.next;
        while (oneNext != null) {
            if (oneNext.data == ele) {
                node.next = oneNext.next;
                contain = true;
                break;
            }
            node = node.next;
            oneNext = oneNext.next;
        }
        if (!contain) System.out.println("Element " + ele + " dose not exists in list");
        else SIZE--;

    }

    private void printReverse(Node node) {
        if (isEmpty()) return;
        printReverse(node.next);
        System.out.println(node.data);
    }

    private void printReverse() {
        printReverse(head);
    }

    private void clearList() {
        head = null;
    }

    private void reverse() {
        Node prev = null;
        Node curr = head;
        Node nxt;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head = prev;
    }

    /*method to find loop  in LinkedList using Floyd’s Cycle-Finding Algorithm
     * implementation
     * 2 pointers are used
     * First pointer travel at one node at a time Second pointer travels 2 nodes at a time
     * if 2 pointer meet at a position the loop is present
     * */

    private void detectCycle(Node node) {
        Node slow = node, fast = node;
        int flag = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = 1;
                break;
            }
        }
        if (flag == 1) System.out.println("Cycle is present");
        else System.out.println("No Cycle found");
    }

    private boolean hasCycle() {
        Node slow = head, fast = head;
        int flag = 0;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
               return true;
            }
        }
        return false;
    }

    private void detectCycle() {
        detectCycle(head);
    }

    private int countOfLoop(Node node) {
        int count = 1;
        Node tem = node;
        while (tem.next != node) {
            count++;
            tem = tem.next;
        }
        return count;
    }

    private int sizeOfLoop(Node node) {
        Node slow = node, fast = node;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return countOfLoop(slow);
        }
        return 0;
    }

    private int sizeOfLoop() {
        return sizeOfLoop(head);
    }


    /**
     * <a href="https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/">Remove Loop Geeks for Geeks</a>
     */
    private void removeLoop() {
        if (!hasCycle()) return;
        int sizeOfLoop = sizeOfLoop();
        Node start = head, pointer = head;
        while (sizeOfLoop-->0){
            pointer = pointer.next;
        }
        while (start.next != pointer.next){
            start = start.next;
            pointer = pointer.next;
        }
        pointer.next = null;
    }

    private void removeLoopSet(Node node){
        if (!hasCycle()) return;
        Set<Node> set = new HashSet<>();
        Node temp = null;
        while (true){
            if (set.contains(node)){
                temp.next = null;
                return;
            }
            else {
                set.add(node);
                temp = node;
                node = node.next;
            }
        }
    }

    private void removeLoopSet(){
        removeLoopSet(head);
    }

    private void createLoop(int size){
        Node n = head;
        int si = size()-size;
        while (si-->0){
            n = n.next;
        }
        tail.next = n;
    }


    private void createList(int size) {
       createList(size,0,50);
    }

    private void createList(int size, int start,int end){
        while (size-- > 0) {
            addAtEnd(new Random().nextInt(start,end));
        }
    }


    private void sortedIntersection(Node x, Node y) {
        Node a = x, b = y;
        while (a != null && b != null) {
            if (a.data == b.data) addAtEnd(a.data);
            else if (a.data > b.data) b = b.next;
            else a = a.next;
        }
    }

    //removes duplicate elements from sorted list
    private void removeDuplicate() {
        Node node = head;
        while (node != null) {
            Node temp = node;
            while (temp != null && temp.data == node.data) {
                temp = temp.next;
            }
            node.next = temp;
            node = node.next;
        }
    }

    //Method to print the elements of linked list
    private void show() {

        if (isEmpty()) {
            System.out.println("Linked List is empty");
            return;
        }
        Node node;

//            while (node != null) {
//                System.out.print(node.data + " ");
//                node = node.next;
//            }
//            System.out.println();
        for (node = head; node != null; node = node.next)
            System.out.print(node.data + " ");
        System.out.println();
    }

    // printing using recursion
    private void show1(Node node) {
        if (isEmpty())
            return;
        System.out.print(node.data + " ");
        show1(node.next);
    }

    private void show1() {
        show1(head);
    }



    public static void main(String[] args) {//main method to call member methods
//        LinkedList list = new LinkedList();
//        list.createList(10,15,30);

        LinkedList ll = new LinkedList();
        ll.addAtEnd(4);
        ll.addAtEnd(5);
        ll.addAtEnd(1);
        ll.addAtEnd(9);
        Node temp = ll.head.next,t1=null;
        while(temp.next!=null) {
            temp.data = temp.next.data;
            t1 = temp;
            temp = temp.next;
        }
        t1.next = null;
        System.out.println(temp.data);
        ll.show();
    }
}