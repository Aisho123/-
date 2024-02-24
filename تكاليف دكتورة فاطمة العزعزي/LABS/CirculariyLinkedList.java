public class CirculariyLinkedList<E> {
    private static class Node<E>{
    E element;
    Node<E>next;
    public Node(E element,Node<E> next) {
        this.element = element;
        this.next = next;
    }
}
    private Node<E>tail=null;
    private int size=0;
    public CirculariyLinkedList() {}

    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public E first(){
        if (isEmpty())return null;
        return tail.next.element;
    }
    public E last(){
        if (isEmpty())return null;
        return tail.element;
    }
    public void rotate(){
        if (tail!=null)
        tail=tail.next;
    }
    public void addFirst(E e){
        if (size==0){
            tail=new Node<>(e,null);
            tail.next=tail;
        }
        else {
            Node<E>newest=new Node<>(e,tail.next);
            tail.next=newest;
        }
        size++;
    }
    public void addLast(E e){
        addFirst(e);
        tail=tail.next;
    }
    public E removeFirst(){
        if(isEmpty())return null;
        Node<E>newest=tail.next;
        if (newest==tail)return null;
        else tail.next=newest.next;
        size--;
        return newest.element;
    }


    public static void main(String[] args) {
        CirculariyLinkedList<Integer>l=new CirculariyLinkedList<>();
        l.addFirst(11);
        l.addLast(12);
        l.addLast(13);
        System.out.println(l.first()+"is the first element before rotation");
        l.rotate();
        System.out.println(l.first()+"is the first element after rotation");
        System.out.println("all elements are : ");
        for (int i = 0; i <l.size() ; i++) {
            System.out.println(l.first());
            l.rotate();

        }
    }
}
