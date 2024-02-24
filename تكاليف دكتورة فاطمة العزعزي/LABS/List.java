public interface List<E> {
    int size();
    boolean isEmpty();
    E set(int i,E e);
    E get(int i);
    void add(int i, E e);
    E remove(int i);
}
