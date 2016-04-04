package com.jprobstats.dataset.impl;

import java.util.List;

import com.jprobstats.dataset.Data;
import com.jprobstats.dataset.DataFactory;

public final class SubList<T> extends Data<T> {

	private final Data<T> data;
	private final int offset;
	private final int length;

	public SubList(Data<T> source, int off, int len) {
		data = source;
		offset = off;
		length = len;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final SubList<?> EMPTY_SUBLIST = new SubList(DataFactory.emptyList(), 0, 0);

	@SuppressWarnings("unchecked")
	public static <T> SubList<T> create(List<T> source, int fromIndex, int toIndex) {
		if ((fromIndex < 0) || (toIndex > source.size()))
			throw new IndexOutOfBoundsException();
		int newSize = toIndex - fromIndex;
		if (newSize <= 0) {
			if (newSize == 0)
				return (SubList<T>) SubList.EMPTY_SUBLIST;
			throw new IllegalArgumentException();
		}
		return createLocal(DataFactory.createFromList(source), fromIndex, toIndex);
	}

	@SuppressWarnings("unchecked")
	public static <T> SubList<T> create(Data<T> source, int fromIndex, int toIndex) {
		if ((fromIndex < 0) || (toIndex > source.size()))
			throw new IndexOutOfBoundsException();
		int newSize = toIndex - fromIndex;
		if (newSize <= 0) {
			if (newSize == 0)
				return (SubList<T>) SubList.EMPTY_SUBLIST;
			throw new IllegalArgumentException();
		}
		if (source instanceof SubList<?>) {
			SubList<T> sl = (SubList<T>) source;
			return createLocal(sl.data, fromIndex + sl.offset, toIndex + sl.offset);
		}
		return createLocal(source, fromIndex, toIndex);
	}

	private static <T> SubList<T> createLocal(Data<T> source, int fromIndex, int toIndex) {
		return new SubList<T>(source, fromIndex, toIndex - fromIndex);
	}

	@Override
	public T get(int i) {
		if ((i < 0) || (i >= length))
			throw new IndexOutOfBoundsException();
		return data.get(i + offset);
	}

	@Override
	public int size() {
		return length;
	}

}
