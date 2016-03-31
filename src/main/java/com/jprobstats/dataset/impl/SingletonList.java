package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.JProbStatsList;

/**
 * If given array size is 1 then we can create JProbStatsList with
 * SingletonList.
 *
 * @param <T>
 */
public final class SingletonList<T> extends JProbStatsList<T> {

	final T value;

	// Constructor
	private SingletonList(T object) {
		value = object;
	}

	public static <T> SingletonList<T> create(T object) {
		return new SingletonList<T>(object);
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

	public JProbStatsList<T> front() {
		return this;
	}

	public T head() {
		return value;
	}
}
