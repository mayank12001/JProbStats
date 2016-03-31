package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.JProbStatsList;

/**
 * Tuple :: A tuple is a finite ordered list of elements.
 *
 *
 * @param <T>
 */
public final class Tuple<T> extends JProbStatsList<T> {
	public final T[] data;

	// Empty Tuple for some special cases
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static final Tuple<?> EMPTY_TUPLE = new Tuple(new Object[0]);

	private Tuple(T[] values) {
		data = values;
	}
	@SuppressWarnings("unchecked")
	public static <T> Tuple<T> create(T[] values) {
		int n=values.length;
		if (n==0) return (Tuple<T>) EMPTY_TUPLE;
		T[] ndata=(T[]) new Object[n];
		System.arraycopy(values,0,ndata,0,n);
		return new Tuple<T>(ndata);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Tuple<T> create(T a) {
		T[] ndata=(T[])new Object[1];
		ndata[0]=a;
		return new Tuple<T>(ndata);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Tuple<T> create(T a, T b) {
		T[] ndata=(T[])new Object[2];
		ndata[0]=a;
		ndata[1]=b;
		return new Tuple<T>(ndata);
	}
	/**
	 * creating new array with given values.
	 * 
	 * @param values
	 * @param fromIndex
	 * @param toIndex
	 * @return new custom list object with new data.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Tuple<T> create(T[] values, int fromIndex, int toIndex) {
		int n = toIndex - fromIndex;
		if (n <= 0)
			return (Tuple<T>) EMPTY_TUPLE;
		T[] ndata = (T[]) new Object[n];
		for (int i = 0; i < n; i++) {
			ndata[i] = values[i + fromIndex];
		}
		return new Tuple<T>(ndata);
	}

	/**
	 * @return size of the data set.
	 */
	public int size() {
		return data.length;
	}

	/**
	 * @return value from data set based on given index.
	 */
	public T get(int i) {
		return data[i];
	}

	@SuppressWarnings("unchecked")
	public static <T> Tuple<T> concat(JProbStatsList<T> a, JProbStatsList<T> b) {
		int as=a.size();
		int bs=b.size();
		T[] ndata=(T[]) new Object[as+bs];
		for (int i=0; i<as; i++) {
			ndata[i]=a.get(i);
		}
		for (int i=0; i<bs; i++) {
			ndata[as+i]=b.get(i);
		}

		return new Tuple<T>(ndata);
	}
	
}
