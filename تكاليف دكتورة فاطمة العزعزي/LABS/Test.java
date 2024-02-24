public class Test {
    public static void main(String[] args) {
        LinkedPositionalList<Integer>l= new LinkedPositionalList<>();
      Position<Integer>p1=  l.addFirst(11);
        Position<Integer>p2=  l.addLast(12);
        Position<Integer>p3=  l.addAfter(p1,13);
        Position<Integer>p4=  l.addBefore(p2,14);
        System.out.println(p1.getElement());
        System.out.println(p2.getElement());
        System.out.println(p3.getElement());
        System.out.println(p4.getElement());


    }
}
