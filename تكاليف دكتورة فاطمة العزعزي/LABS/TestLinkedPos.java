public class TestLinkedPos {
    public static void main(String[] args) {
        LinkedPositionalList<String>s= new LinkedPositionalList<>();
        Position<String>p1=s.addFirst("Fatima");
        s.addAfter(p1,"ayah");
        s.addBefore(p1,"yumna");
    }
}
