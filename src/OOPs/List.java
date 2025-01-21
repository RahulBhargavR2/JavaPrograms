package OOPs;

public interface List<E> {
    int size();

    boolean isEmpty();

    boolean contains(E o);

    void add(E o);

    void add(int index, E o);

    int indexOf(E ele);

    void addFirst(E e);

    void addLast(E e);

    E get(int index);
}