package com.jprobstats.dataset;

import java.util.Iterator;
import java.util.ListIterator;

public abstract class JProbStatsList<T> implements IJProbStatsList<T> {
	public abstract T get(int i);

	// inner class
	private class JProbStatsListIterator implements ListIterator<T> {
		int i;

		public JProbStatsListIterator() {
			i = 0;
		}

		public JProbStatsListIterator(int index) {
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
		return new JProbStatsListIterator();
	}

	public ListIterator<T> listIterator(int index) {
		return new JProbStatsListIterator(index);
	}

	public Iterator<T> iterator() {
		return new JProbStatsListIterator();
	}

	public JProbStatsList<T> include(final T value) {
		return this.append(value);
	}

	public JProbStatsList<T> append(T value) {
		return ListFactory.concat(this, value);
	}

}
