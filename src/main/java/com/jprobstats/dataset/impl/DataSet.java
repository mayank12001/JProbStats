package com.jprobstats.dataset.impl;

import java.util.List;

import com.jprobstats.dataset.Data;

/**
 *
 *
 * @param <T>
 */
public final class DataSet<T> extends Data<T> {
	public final T[] data;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	static final DataSet<?> EMPTY_DATA = new DataSet(new Object[0]);

	private DataSet(T[] values) {
		data = values;
	}

	@SuppressWarnings("unchecked")
	public static <T> DataSet<T> create(T a) {
		T[] ndata = (T[]) new Object[1];
		ndata[0] = a;
		return new DataSet<T>(ndata);
	}

	@SuppressWarnings("unchecked")
	public static <T> DataSet<T> create(T a, T b) {
		T[] ndata = (T[]) new Object[2];
		ndata[0] = a;
		ndata[1] = b;
		return new DataSet<T>(ndata);
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
	public static <T> DataSet<T> create(T[] values, int fromIndex, int toIndex) {
		int n = toIndex - fromIndex;
		if (n <= 0) {
			if (n == 0)
				return (DataSet<T>) EMPTY_DATA;
			throw new IllegalArgumentException();
		}
		T[] ndata = (T[]) new Object[n];
		for (int i = 0; i < n; i++) {
			ndata[i] = values[i + fromIndex];
		}
		return new DataSet<T>(ndata);
	}

	/**
	 * Creating data set with given List
	 * 
	 * @param values
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> Data<T> createFrom(List<T> values, int fromIndex, int toIndex) {
		int n = toIndex - fromIndex;
		if (n <= 0) {
			if (n == 0)
				return (DataSet<T>) EMPTY_DATA;
			throw new IllegalArgumentException();
		}
		T[] ndata = (T[]) new Object[n];
		for (int i = 0; i < n; i++) {
			ndata[i] = values.get(i + fromIndex);
		}
		return new DataSet<T>(ndata);
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
	public T get(int index) {
		if (index >= 0 && index <this.size())
			return data[index];
		else
			throw new ArrayIndexOutOfBoundsException();
	}

	@SuppressWarnings("unchecked")
	public static <T> DataSet<T> concat(Data<T> a, Data<T> b) {
		int as = a.size();
		int bs = b.size();
		T[] ndata = (T[]) new Object[as + bs];
		for (int i = 0; i < as; i++) {
			ndata[i] = a.get(i);
		}
		for (int i = 0; i < bs; i++) {
			ndata[as + i] = b.get(i);
		}

		return new DataSet<T>(ndata);
	}

}
