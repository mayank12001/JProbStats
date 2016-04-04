package com.jprobstats.dataset.impl;

import com.jprobstats.dataset.Data;


public final class NullData<T> extends Data<T> {

	@SuppressWarnings("rawtypes")
	public static NullData<?> INSTANCE=new NullData();
	
	private NullData() {
		
	}
	@Override
	public T get(int i) {
		throw new IndexOutOfBoundsException();
	}

	@Override
	public int size() {
		return 0;
	}

}
