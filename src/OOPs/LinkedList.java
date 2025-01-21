package OOPs;

@SuppressWarnings({"checked","unused"})
public class LinkedList<E> implements List<E>{
    int size = 0;
    public int size(){return size;}

    private LinkedList() {
    }

    public boolean isEmpty(){return head == null;}

    public boolean contains(E ele){ return indexOf(ele) >=0;}

    public int indexOf(E e){
        int index = 0;
        for (Node<E> x = head;  x != null; x = x.next){
            if (e.equals(x.data)) return index;
            index++;
        }
        return -1;
    }

    public void add(E e){
        linkLast(e);
    }
    public void add(int index, E e){
        linkAfter(index, e);
    }

    public void addFirst(E e){linkFirst(e);}

    public void addLast(E e){linkLast(e);}

    public E get(int index){
        checkElementIndex(index);
        return node(index).data;
    }

    private void linkLast(E e){
        Node<E> node = new Node<>(e);
        if (isEmpty()) head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    private void linkFirst(E e){
        Node<E> node = new Node<>(e);
        if (isEmpty()){
            head = tail = node;
        }
        else {
            node.next = head;
            head = node;
        }
        size++;
    }
    private void linkAfter(int index, E e){
        Node<E> n = head;
        Node<E> ne = new Node<>(e);
        if (isEmpty()) head = tail = ne;
        else {
        while (index > 0){
            n = n.next;
            index--;
        }
        Node<E> prev = n;
        ne.next = n.next;
        prev.next = ne;
        }
        size++;
    }
    private Node<E> node(int index){
//        assert isElementIndex(index);
        if (isElementIndex(index)){
            Node<E> n = head;
            for (int i = 0; i < index; i++)
                n = n.next;
            return n;
        }
        else return null;
    }

    private boolean isElementIndex(int index){
        return index < size && index >= 0;
    }

    private void checkElementIndex(int index){
        if(!isElementIndex(index)) throw new IndexOutOfBoundsException();
    }

    Node<E> head;
    Node<E> tail;
     static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
            next = null;
        }
    }
}
