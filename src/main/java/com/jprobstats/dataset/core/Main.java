package com.jprobstats.dataset.core;

import java.util.Iterator;

import com.jprobstats.dataset.DataFactory;
import com.jprobstats.dataset.DataList;

public class Main {

    private static final int Number = 0;

    public static void main(String[] args) {

        /**
         * As of now user can pass Array as input.
         * 
         */
        DataList<Integer> pl = DataFactory.createFromArray(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8});
        // here pl is the immutable object
        pl = pl.include(9);
        Iterator<Integer> it = pl.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

}
