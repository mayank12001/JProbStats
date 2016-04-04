package com.jprobstats.dataset.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.jprobstats.dataset.Data;
import com.jprobstats.dataset.DataFactory;

public class Main {

	public static void main(String[] args) {

		/**
		 * As of now user can pass Array and List as input.
		 * 
		 */
		// Array as input
		Data<Integer> arrayData = DataFactory.createFromArray(new Integer[] { 1, 2, 3, 4, 5 });

		arrayData = arrayData.append(6);

		Iterator<Integer> it = arrayData.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		// List as input.
		Data<Integer> listData = DataFactory.createFromList(list);
		ListIterator<Integer> it1 = listData.listIterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
	}

}
