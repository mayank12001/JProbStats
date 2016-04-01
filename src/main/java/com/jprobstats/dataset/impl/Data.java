package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.DataList;

/**
 * Tuple :: A tuple is a finite ordered list of elements.
 *
 *
 * @param <T>
 */
public final class Data<T> extends DataList<T> {
	public final T[] data;

	// Empty Tuple for some special cases
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static final Data<?> EMPTY_TUPLE = new Data(new Object[0]);

	private Data(T[] values) {
		data = values;
	}
	@SuppressWarnings("unchecked")
	public static <T> Data<T> create(T[] values) {
		int n=values.length;
		if (n==0) return (Data<T>) EMPTY_TUPLE;
		T[] ndata=(T[]) new Object[n];
		System.arraycopy(values,0,ndata,0,n);
		return new Data<T>(ndata);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Data<T> create(T a) {
		T[] ndata=(T[])new Object[1];
		ndata[0]=a;
		return new Data<T>(ndata);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Data<T> create(T a, T b) {
		T[] ndata=(T[])new Object[2];
		ndata[0]=a;
		ndata[1]=b;
		return new Data<T>(ndata);
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
	public static <T> Data<T> create(T[] values, int fromIndex, int toIndex) {
		int n = toIndex - fromIndex;
		if (n <= 0)
			return (Data<T>) EMPTY_TUPLE;
		T[] ndata = (T[]) new Object[n];
		for (int i = 0; i < n; i++) {
			ndata[i] = values[i + fromIndex];
		}
		return new Data<T>(ndata);
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
	public static <T> Data<T> concat(DataList<T> a, DataList<T> b) {
		int as=a.size();
		int bs=b.size();
		T[] ndata=(T[]) new Object[as+bs];
		for (int i=0; i<as; i++) {
			ndata[i]=a.get(i);
		}
		for (int i=0; i<bs; i++) {
			ndata[as+i]=b.get(i);
		}

		return new Data<T>(ndata);
	}
	
}
