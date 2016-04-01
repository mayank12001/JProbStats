package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.DataFactory;
import com.jprobstats.dataset.DataList;
/**
 * Combining two JProbStatsLists
 *
 * @param <T>
 */
public class CompositeDataList<T> extends DataList<T> {
	public final DataList<T> front;
	public final DataList<T> back;
	private final int size;

	private CompositeDataList(DataList<T> a, DataList<T> b) {
		front = a;
		back = b;
		size = a.size() + b.size();
	}
	// TODO when both list size exceeds tuple size we have to increase destination array.
	public static <T> DataList<T> concat(DataList<T> a, DataList<T> b) {
		int as=a.size(); if (as==0) return b;
		int bs=b.size(); if (bs==0) return a;
		if ((as+bs)<=DataFactory.MAX_TUPLE_BUILD_SIZE) {
			return Data.concat(a, b);
		}
		
	   return new CompositeDataList<T>(a,b);
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
