import java.util.Iterator;

public class ArrayList <E>implements List<E>,Iterable<E>{
    private E[]data;
    private static final int CAP=16;
    private int size=0;
    public ArrayList(int c)
    {
        data= (E[]) new Object[c];
    }
    public ArrayList()
    {
        this(CAP);
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
protected void checkIndex(int i, int s)
{
if (i<0||i>=s)
    throw new IndexOutOfBoundsException("illegal index: "+i);
}
    @Override
    public E set(int i, E e) {
        checkIndex(i,size);
        E old=data[i];
        data[i]=e;
        return old;
    }

    @Override
    public E get(int i) {
        checkIndex(i,size);
        return data[i];
    }

    @Override
    public void add(int i, E e) {
checkIndex(i,size+1);
if (size==data.length)resize(2 * data.length);;
for (int k=size-1;k>=i;k--)
    data[k+1]=data[k];
data[i]=e;
size++;
    }

    @Override
    public E remove(int i) {
        checkIndex(i,size);
        E del=data[i];
        for (int k=i;k<size-1;k++)
            data[k]=data[k+1];
        data[size-1]=null;
        size--;
        return del;
    }
    protected void resize(int cap)
    {
        E []temp= (E[]) new Object[cap];
        for (int k=0; k<size;k++)
            temp[k]=data[k];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E>
    {
        int j=0;
        @Override
        public boolean hasNext() {
            return j<size;
        }

        @Override
        public E next() {
            if (j==size)throw new IllegalStateException("no Next element");
            return data[j++];
        }
    }
}
