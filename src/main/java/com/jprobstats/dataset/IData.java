package com.jprobstats.dataset;

/**
 * we can add some more methods in future
 *
 * @param <T>
 */
public interface IData<T> {

	// access methods
	
	public T get(int i);
	public int size();

}
