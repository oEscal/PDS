package aula09.ex1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ListIterator;

public class VectorGeneric <T> {

    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem>=dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem );
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem - i - 1 > 0) // not last element
                    System.arraycopy(vec, i + 1, vec, i, nElem - i - 1);
                vec[--nElem] = null; // libertar último objecto para o GC
                return true;
            }
        }
        return false;
    }

    public int totalElem() {
        return nElem;
    }

    public T getElem(int i) {
        return (T) vec[i];
    }

    public Iterator<T> iterator() {
        return (this).new VectorIterator<T>();
    }

    public VectorListIterator<T> listIterator() {
        return (this).new VectorListIterator<T>();
    }


    private class VectorIterator<K> implements Iterator<K> {

        private int indice;

        VectorIterator() {
            indice = 0;
        }

        public boolean hasNext() {
            return (indice < nElem);
        }

        public K next() {
            if (hasNext())
                return (K)VectorGeneric.this.vec[indice++];
            throw new NoSuchElementException("only " + nElem + " elements");
        }

    }

    private class VectorListIterator<J> implements ListIterator<J> {

        private int index;

        public VectorListIterator() {
            this.index = 0;
        }

        public VectorListIterator(int index){
            this.index = index;
        }

        public boolean hasNext() {
            return (this.index < nElem);
        }

        public J next() {
            if (hasNext())
                return (J) vec[index++];
            throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public boolean hasPrevious() {
            return (index>=0);
        }

        @Override
        public J previous() {
            if (hasPrevious())
                return (J) vec[index--];
            throw new NoSuchElementException("no more elements");
        }

        @Override
        public int nextIndex() {
            if (index < nElem -1)
                return index;
            return nElem;
        }

        @Override
        public int previousIndex() {
            if (index > 0)
                return index;
            return -1;
        }

        @Override
        public void remove() { }

        @Override
        public void set(J j) {
            vec[index] = (T) j;
        }

        @Override
        public void add(J j) {
            //optional operation
        }
    }



}
