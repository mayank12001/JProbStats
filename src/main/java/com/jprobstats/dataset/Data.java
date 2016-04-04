package com.jprobstats.dataset;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.jprobstats.dataset.impl.SubList;

/**
 * <h4>Creating Data Object::</h4>
 * <ul>
 * 
 * <li>Data<Integer> arrayTypeData = DataFactory.createFromArray(new Integer[] {
 * 1, 2, 3, 4, 5});</li>
 * <li>List<Integer> list = new ArrayList<Integer>();</li>
 * <li>list.add(10);</li>
 * <li>list.add(20);</li>
 * <li>list.add(30);</li>
 * <li>Data<Integer> listTypeData = DataFactory.createFromList(list);</li>
 * <li>Data<Integer> data = DataFactory.create(10);</li>
 * <li>Data<Integer> NullTypeData = DataFactory.create();</li>
 * </ul>
 *
 */
public abstract class Data<T> implements IData<T> {
	// inner class
	private class DataIterator implements ListIterator<T> {
		// TODO here "i" is not a immutable object.
		int i;

		public DataIterator() {
			i = 0;
		}

		public DataIterator(int index) {
			i = index;
		}

		@Override
		public boolean hasNext() {
			return (i < size());
		}

		@Override
		public boolean hasPrevious() {
			return i > 0;
		}

		@Override
		public T next() {
			return get(i++);
		}

		@Override
		public int nextIndex() {
			int s = size();
			return (i < s) ? i + 1 : s;
		}

		@Override
		public T previous() {
			return get(--i);
		}

		@Override
		public int previousIndex() {
			return i - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Method will return {@link DataIterator} object by default index starts
	 * with 0.
	 * 
	 * @return
	 */
	public ListIterator<T> listIterator() {
		return new DataIterator();
	}

	/**
	 * Method will return {@link DataIterator} object but iteration starts with
	 * given index.
	 * 
	 * @return
	 */
	public ListIterator<T> listIterator(int index) {
		if (index >= 0 && index < size())
			return new DataIterator(index);
		else
			throw new IndexOutOfBoundsException();
	}

	public Iterator<T> iterator() {
		return new DataIterator();
	}

	/**
	 * Appending at end of the array.
	 * 
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Data<T> append(final T... values) {
		if (values != null)
			return DataFactory.concat(this, values);
		else
			throw new NullPointerException();
	}

	public Data<T> append(List<T> values) {
		if (values != null)
			return DataFactory.concat(this, values);
		else
			throw new NullPointerException();

	}

	public Data<T> append(Data<T> values) {
		if (values != null)
			return DataFactory.concat(this, values);
		else
			throw new NullPointerException();

	}

	/**
	 * <h4>updating value at given index.</h4>
	 * <li>Example :: data :: 10 50 30 40</li>
	 * <li>if we update 50 with 20 at index 1 then result will be 10 20 30 40
	 * </li>
	 * 
	 * @param index
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Data<T> update(int index, T value) {
		if (index >= 0 && index < this.size()) {
			Data<T> firstPart = subList(0, index);
			Data<T> lastPart = subList(index + 1, size());
			return firstPart.append(value).append(lastPart);
		} else
			throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * <h4>inserting value at given index.</h4>
	 * <li>Example :: data :: 10 30 40 50</li>
	 * <li>if we insert 20 at index 1 then result will be 10 20 30 40 50</li>
	 * 
	 * @param index
	 * @param value
	 * @return
	 */

	@SuppressWarnings("unchecked")
	public Data<T> insert(int index, T value) {
		if (index >= 0 && index < this.size()) {
			Data<T> firstPart = subList(0, index);
			Data<T> lastPart = subList(index, size());
			return firstPart.append(value).append(lastPart);
		} else
			throw new ArrayIndexOutOfBoundsException();

	}

	public Data<T> subList(int fromIndex, int toIndex) {
		if ((fromIndex == 0) && (toIndex == size()))
			return this;
		if (fromIndex == toIndex)
			return DataFactory.emptyList();
		return SubList.create(this, fromIndex, toIndex);
	}

}
