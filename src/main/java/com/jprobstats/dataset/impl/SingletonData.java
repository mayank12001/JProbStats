package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.Data;

/**
 * If given array size is 1 then we can create JProbStatsList with SingletonList.
 *
 * @param <T>
 */
public final class SingletonData<T> extends Data<T> {

    final T value;

    // Constructor
    private SingletonData(T object) {
        value = object;
    }

    public static <T> SingletonData<T> create(T object) {
        return new SingletonData<T>(object);
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

    public Data<T> front() {
        return this;
    }

    public T head() {
        return value;
    }
}
