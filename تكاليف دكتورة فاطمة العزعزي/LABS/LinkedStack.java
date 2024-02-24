import java.util.LinkedList;

public class LinkedStack <E> implements Stack<E>{
LinkedList<E>l= new LinkedList<>();

    @Override
    public int size() {
        return l.size();
    }

    @Override
    public boolean isEmpty() {
        return l.isEmpty();
    }

    @Override
    public void push(E e) {
l.addLast(e);
    }

    @Override
    public E pop() {
        return l.removeLast();
    }

    @Override
    public E top() {
        return l.getLast();
    }
}
