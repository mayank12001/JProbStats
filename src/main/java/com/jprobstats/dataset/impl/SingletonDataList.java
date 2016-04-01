package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.DataList;

/**
 * If given array size is 1 then we can create JProbStatsList with SingletonList.
 *
 * @param <T>
 */
public final class SingletonDataList<T> extends DataList<T> {

    final T value;

    // Constructor
    private SingletonDataList(T object) {
        value = object;
    }

    public static <T> SingletonDataList<T> create(T object) {
        return new SingletonDataList<T>(object);
    }

    @Override
    public T get(int i) {
        if (i == 0)
            return value;
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return 1;
    }

    public boolean isEmpty() {
        return false;
    }

    public DataList<T> front() {
        return this;
    }

    public T head() {
        return value;
    }
}
