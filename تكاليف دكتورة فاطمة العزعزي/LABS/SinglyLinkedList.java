import java.util.Scanner;
public class SinglyLinkedList <E>{
    private static class Node<E>{
        E element;
        Node<E>next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E>head=null;
    private Node<E>tail=null;
    private int size=0;
    public SinglyLinkedList(){}
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if (isEmpty())return null;
        return head.getElement();
    }
    public E last(){
        if (isEmpty())return null;
        return tail.getElement();
    }
    public void addFirst(E e){
        head=new Node<E>(e,head);
        if(size==0)
            tail=head;
        size++;
    }
    public void addLast(E e){
        Node<E>n=new Node<E>(e,null);
        if(size==0)
            head=n;
        else
            tail.setNext(n);
        tail=n;
        size++;
    }
    public E removeFirst(){
        if(isEmpty())return null;
        E deleted=head.getElement();
        head=head.getNext();
        size--;
        if (size==0)
            tail=null;
        return deleted;
    }







    public static void main(String[] args) {
        SinglyLinkedList<Integer>l=new SinglyLinkedList<>();
        Scanner in= new Scanner(System.in);
        int choice;
        while (true)
        {
            System.out.println("1 add first 2 add last 3 remove first " +
                    "4 first 5 last 6 size 7 view all 0 exit");
            choice=in.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("input a number to add in the first");
                    l.addFirst(in.nextInt());
                    System.out.println(l.first()+" is added successfully");
                    break;
                case 2:
                    System.out.println("input a number to add in the last");
                    l.addLast(in.nextInt());
                    System.out.println(l.last()+" is added successfully");
                    break;
                case 3:
                    System.out.println(l.removeFirst()+ " is removed successfully");
                    break;
                case 4:
                    System.out.println(l.first()+ " is the first number");
                    break;
                case 5:
                    System.out.println(l.last()+ " is the last number");
                    break;
                case 6:
                    System.out.println("The size of this list is : "+l.size());
                    break;
                case 7:
                    System.out.println("All list elements are : ");
                    while (!l.isEmpty())
                    {
                        System.out.print(l.removeFirst()+ " ");
                    }
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }
}
