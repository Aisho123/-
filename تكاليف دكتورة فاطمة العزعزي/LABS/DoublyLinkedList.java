import java.util.Scanner;

public class DoublyLinkedList <E>{
    public static class Node<E>{
        E element;
        Node<E>pre;
        Node<E>next;

        public Node(E element, Node<E> pre, Node<E> next) {
            this.element = element;
            this.pre = pre;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPre() {
            return pre;
        }

        public void setPre(Node<E> pre) {
            this.pre = pre;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node <E>header;
    private Node <E>trailer;
    private int size=0;
    public DoublyLinkedList(){
        header=new Node<>(null,null,null);
        trailer=new Node<>(null,header,null);
        header.setNext(trailer);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return header.getNext().getElement();
    }
    public E last(){
        if (isEmpty())return null;
        return trailer.getPre().getElement();
    }
    private void addBetween(E e, Node<E>p,Node<E>n){
        Node<E>newst=new Node<>(e,p,n);
        p.setNext(newst);
        n.setPre(newst);
        size++;
    }
    public void addFirst(E ee){
        addBetween(ee,header,header.next);
    }
    public void addLast(E ee){
        addBetween(ee,trailer.pre,trailer);
    }
    private E remove(Node<E>x){
        Node<E>p=x.pre;
        Node<E>n=x.next;
        p.setNext(n);
        n.setPre(p);
        size--;
        return x.element;
    }
    public E removeFirst(){
        if(isEmpty())return null;
        return remove(header.next);
    }
    public E removeLast(){
        if(isEmpty())return null;
        return remove(trailer.pre);
    }

    public static void main(String[] args) {
        DoublyLinkedList<String>l= new DoublyLinkedList<>();
        Scanner in = new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("1 addFirst 2 addLast 3 removeFirst 4 removeLast 5 first" +
                    "6 last 7 size 8 view all 0 exit");
            choice= in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("input a name to add first");
                    l.addFirst(in.next());
                    System.out.println(l.first()+" is added successfully");
                    break;
                case 2:
                    System.out.println("input a name to add last");
                    l.addLast(in.next());
                    System.out.println(l.last()+" is added successfully");
                    break;
                case 3:
                    System.out.println(l.removeFirst()+" is removed successfully");
                    break;
                case 4:
                    System.out.println(l.removeLast()+" is removed successfully");
                    break;
                case 5:
                    System.out.println(l.first()+"  is the first name");
                    break;
                case 6:
                    System.out.println(l.last()+"  is the last name");
                    break;
                case 7:
                    System.out.println(l.size()+" is the size of this list");
                    break;
                case 8:
                    System.out.print("all names in this list are : ");
                    while (!l.isEmpty())
                        System.out.print(l.removeLast()+" ");
                    System.out.println();
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
