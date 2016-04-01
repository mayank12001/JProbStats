package com.jprobstats.dataset;

import java.util.Iterator;
import java.util.ListIterator;

public abstract class Data<T> implements IData<T> {
    public abstract T get(int i);

    // inner class
    private class DataIterator implements ListIterator<T> {
        int i;

        public DataIterator() {
            i = 0;
        }

        public DataIterator(int index) {
            i = index;
        }

        public void add(T e) {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return (i < size());
        }

        public boolean hasPrevious() {
            return i > 0;
        }

        public T next() {
            return get(i++);
        }

        public int nextIndex() {
            int s = size();
            return (i < s) ? i + 1 : s;
        }

        public T previous() {
            return get(--i);
        }

        public int previousIndex() {
            return i - 1;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(T e) {
            throw new UnsupportedOperationException();
        }
    }

    public ListIterator<T> listIterator() {
        return new DataIterator();
    }

    public ListIterator<T> listIterator(int index) {
        return new DataIterator(index);
    }

    public Iterator<T> iterator() {
        return new DataIterator();
    }

    public Data<T> include(final T value) {
        return this.append(value);
    }

    public Data<T> append(T value) {
        return DataFactory.concat(this, value);
    }

}
