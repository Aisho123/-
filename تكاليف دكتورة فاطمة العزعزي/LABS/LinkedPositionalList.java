public class LinkedPositionalList <E> implements PositionalList<E>{
  private static class Node<E> implements Position<E>{
      E element;
      Node<E>prev;
      Node<E>next;

      public Node(E element, Node<E> prev, Node<E> next) {
          this.element = element;
          this.prev = prev;
          this.next = next;
      }

      public void setElement(E element) {
          this.element = element;
      }

      public Node<E> getPrev() {
          return prev;
      }

      public void setPrev(Node<E> prev) {
          this.prev = prev;
      }

      public Node<E> getNext() {
          return next;
      }

      public void setNext(Node<E> next) {
          this.next = next;
      }

      @Override
      public E getElement() {
          return element;
      }
  }
  private Node<E>header;
  private Node<E>trailer;
  private int size=0;
  public LinkedPositionalList()
  {
      header=new Node<>(null,null,null);
      trailer= new Node<>(null,header,null);
      header.setNext(trailer);
  }
  private Node<E>validate(Position<E>p)
  {
      if (!(p instanceof Node))
          throw new IllegalArgumentException("invalid pos");
      Node<E>n= (Node<E>) p;
      if (n.getNext()==null)
          throw new IllegalArgumentException("p is no loger exist");
      return n;
  }
  private Position<E>position(Node<E>n)
  {
      if (n==header||n==trailer)
          return null;
      return n;
  }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Position<E> first() {
        return position(header.next);
    }

    @Override
    public Position<E> last() {
        return position(trailer.prev);
    }

    @Override
    public Position<E> before(Position<E> p) {
      Node<E> n=validate(p);
        return position(n.prev);
    }

    @Override
    public Position<E> after(Position<E> p) {
        Node<E> n=validate(p);
        return position(n.next);
    }
private Position<E>addBetween(E e, Node<E>pr,Node<E>nx)
{
    Node<E>n= new Node<>(e,pr,nx);
    pr.setNext(n);
    nx.setPrev(n);
    size++;
    return n;
}
    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e,header,header.next);
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e,trailer.prev,trailer);
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) {
      Node<E>n=validate(p);
        return addBetween(e,n.prev,n);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) {
        Node<E>n=validate(p);
        return addBetween(e,n,n.next);
    }

    @Override
    public E set(Position<E> p, E e) {
        Node<E>n=validate(p);
       E old=n.element;
       n.setElement(e);
        return old;
    }

    @Override
    public E remove(Position<E> p) {
        Node<E>n=validate(p);
        Node<E>pr=n.prev;
        Node<E>nx=n.next;
        pr.setNext(nx);
        nx.setPrev(pr);
        size--;
        E del=n.element;
        n.setElement(null);
        n.setPrev(null);
        n.setNext(null);
        return del;
    }
}
