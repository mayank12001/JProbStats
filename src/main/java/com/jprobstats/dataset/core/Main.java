package com.jprobstats.dataset.core;

import java.util.Iterator;

import com.jprobstats.dataset.JProbStatsList;
import com.jprobstats.dataset.ListFactory;

public class Main {

	public static void main(String[] args) {

		/**
		 * As of now user can pass Array as input.
		 * 
		 */
		JProbStatsList<Integer> pl = ListFactory.createFromArray(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		// here pl is the immutable object
		pl = pl.include(9);
		Iterator<Integer> it = pl.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
