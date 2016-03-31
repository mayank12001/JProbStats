package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.JProbStatsList;
import com.jprobstats.dataset.ListFactory;
/**
 * Combining two JProbStatsLists
 *
 * @param <T>
 */
public class CompositeList<T> extends JProbStatsList<T> {
	public final JProbStatsList<T> front;
	public final JProbStatsList<T> back;
	private final int size;

	private CompositeList(JProbStatsList<T> a, JProbStatsList<T> b) {
		front = a;
		back = b;
		size = a.size() + b.size();
	}
	// TODO when both list size exceeds tuple size we have to increase destination array.
	public static <T> JProbStatsList<T> concat(JProbStatsList<T> a, JProbStatsList<T> b) {
		int as=a.size(); if (as==0) return b;
		int bs=b.size(); if (bs==0) return a;
		if ((as+bs)<=ListFactory.MAX_TUPLE_BUILD_SIZE) {
			return Tuple.concat(a, b);
		}
		
	   return new CompositeList<T>(a,b);
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
