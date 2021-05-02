package relran;

import java.util.Arrays;

public class OurArrayList <E> implements OurList<E>{

    private static final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] source;

    public OurArrayList() {
        source = new Object[INITIAL_CAPACITY];
    }
    @Override
    public E get(int index) {
        sizeCheck(index);
        return (E) source[index];
    }
    void increaseCapacity() {
        int newCapacity = source.length * 2;
        Object[] newSource = new Object[newCapacity];
        System.arraycopy(source, 0, newSource, 0, source.length);
        source = newSource;
        //source = Arrays.copyOf(source,source.length*2);
    }

    @Override
    public void add(E elt) {
        if (size == source.length)
            increaseCapacity();

        source[size] = elt;
        size++;

    }

    @Override
    public E remove(int index) {

        sizeCheck(index);
        E oldValue = (E) source[index];
        int numMoved = size - index -1;
        if(numMoved > 0)
            System.arraycopy(source,index+1,source,index,numMoved);
        source[--size]= null;

        return oldValue;
    }

    private void sizeCheck(int index)  {

        if(index >= size || index < 0){
            throw  new IndexOutOfBoundsException("the index is out the list size.....");
        }
    }

    @Override
    public boolean remove(E elt) {

        for(int i = 0; i<source.length; i++){
            if((E)source[i] == elt) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E set(int index, E elt) {

        sizeCheck(index);
        E oldValue = (E) source[index];
        source[index] = (Object) elt;
        return oldValue;

    }

    @Override
    public boolean contains(E elt) {

        for(int i = 0; i < source.length; i++){
            if((E)source[i] == elt)
                return true;
        }
        return false;
    }
}
