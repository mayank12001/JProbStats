package com.jprobstats.dataset;

import java.util.List;

import com.jprobstats.dataset.impl.CompositeData;
import com.jprobstats.dataset.impl.DataSet;
import com.jprobstats.dataset.impl.NullData;
import com.jprobstats.dataset.impl.SingletonData;

public class DataFactory<T> {

	public static <T> Data<T> create() {
		return emptyList();
	}

	@SuppressWarnings("unchecked")
	public static <T> Data<T> emptyList() {
		return (Data<T>) NullData.INSTANCE;
	}

	/**
	 * <ul>
	 * <li>Taking input as array.</li>
	 * <li>By default index starts with 0 and toIndex will be length of given
	 * array.</li>
	 * <li>Example :: Given array :: Integer[] {1,2,3,4,5,6}</li>
	 * <li>{@link Data} will contains all elements {1,2,3,4,5,6} from given
	 * array.</li>
	 * </ul>
	 * 
	 * @param data
	 * @return
	 */
	public static <T> Data<T> createFromArray(T[] data) {
		return createFromArray(data, 0, data.length);
	}

	/**
	 * <ul>
	 * <p>
	 * <li>Taking input as array,fromIndex and toIndex.</li>
	 * <li>Example :: User given array:: Integer[] {1,2,3,4,5,6},fromIndex ::3
	 * and toIndex ::5</li>
	 * <li>{@link Data} will contains {4,5} from given array.</li>
	 * </p>
	 * </ul>
	 * 
	 * @param data
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	public static <T> Data<T> createFromArray(T[] data, int fromIndex, int toIndex) {
		int n = toIndex - fromIndex;
		if (n < 2) {
			if (n < 0)
				throw new IllegalArgumentException();
			if (n == 0)
				return emptyList();
			if (n == 1)
				return SingletonData.create(data[fromIndex]);
		}
		return DataSet.create(data, fromIndex, toIndex);
	}

	/**
	 * <ul>
	 * <li>taking input as List</li>
	 * </ul>
	 * 
	 * @return
	 */
	public static <T> Data<T> createFromList(List<T> source) {

		return createFromList(source, 0, source.size());

	}

	private static <T> Data<T> createFromList(List<T> source, int fromIndex, int toIndex) {
		int maxSize = source.size();
		if ((fromIndex < 0) || (toIndex > maxSize))
			throw new IndexOutOfBoundsException();
		int newSize = toIndex - fromIndex;
		if (newSize < 2) {
			if (newSize < 0)
				throw new IllegalArgumentException();
			if (newSize == 0)
				return emptyList();
			if (newSize == 1)
				return SingletonData.create(source.get(fromIndex));
		}
		return DataSet.createFrom(source, fromIndex, toIndex);
	}

	/**
	 * adding single value to list using SingletonList
	 * 
	 * @param value
	 * @return
	 */
	public static <T> Data<T> create(T value) {
		return SingletonData.create(value);
	}

	public static <T> Data<T> concat(Data<T> a, T v) {
		return concat(a, DataFactory.create(v));
	}

	public static <T> Data<T> concat(Data<T> data, T[] values) {
		return concat(data, DataFactory.createFromArray(values));
	}

	public static <T> Data<T> concat(Data<T> data, List<T> values) {
		return concat(data, DataFactory.createFromList(values));
	}

	public static <T> Data<T> concat(Data<T> a, Data<T> b) {
		return CompositeData.concat(a, b);
	}

}
