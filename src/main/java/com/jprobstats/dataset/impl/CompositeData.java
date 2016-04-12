package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.Data;
import com.jprobstats.dataset.DataFactory;

/**
 *
 * @param <T>
 */
public class CompositeData<T> extends Data<T> {
	public final Data<T> front;
	public final Data<T> back;
	private final int size;

	private CompositeData(Data<T> a, Data<T> b) {
		front = a;
		back = b;
		size = a.size() + b.size();
	}

	public static <T> Data<T> concat(Data<T> a, Data<T> b) {
		int as = a.size();
		if (as == 0)
			return b;
		int bs = b.size();
		if (bs == 0)
			return a;
		return DataSet.concat(a, b);
	}

	@Override
	public T get(int i) {
		int fs = front.size();
		if (i < fs) {
			return front.get(i);
		}
		return back.get(i - fs);
	}

	@Override
	public int size() {
		return size;
	}
}
