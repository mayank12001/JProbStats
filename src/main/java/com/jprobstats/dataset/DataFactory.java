package com.jprobstats.dataset;

import com.jprobstats.dataset.impl.CompositeData;
import com.jprobstats.dataset.impl.DataSet;
import com.jprobstats.dataset.impl.SingletonData;

public class DataFactory<T> {
    // creating size of tuple
    public static final int TUPLE_BUILD_BITS = 5;
    public static final int MAX_TUPLE_BUILD_SIZE = 1 << TUPLE_BUILD_BITS;

    /**
     * <ul>
     * <li>Taking input as array.</li>
     * <li>By default index starts with 0 and toIndex will be length of given array.</li>
     * <li>Example :: Given array :: Integer[] {1,2,3,4,5,6}</li>
     * <li>JProbStatsList will contains all elements {1,2,3,4,5,6} from given array.</li>
     * </ul>
     * 
     * @param data
     * @return
     */
    public static <T> Data<T> createFromArray(T[] data) {
        return createFromArray(data, 0, data.length);
    }

    /**
     * <ul>
     * <p>
     * <li>Taking input as array,fromIndex and toIndex.</li>
     * <li>Example :: User given array:: Integer[] {1,2,3,4,5,6},fromIndex ::3 and toIndex ::5</li>
     * <li>JProbStatsList will contains {4,5} from given array.</li>
     * </p>
     * </ul>
     * 
     * @param data
     * @param fromIndex
     * @param toIndex
     * @return
     */
    public static <T> Data<T> createFromArray(T[] data, int fromIndex, int toIndex) {
        int n = toIndex - fromIndex;
        // TODO if given array size is more than tuple(finite size) then
        // create BlockList with infinite size
        if (n <= MAX_TUPLE_BUILD_SIZE) {
            // TODO if n==0 then return empty List(NullList).
            if (n < 2) {
                if (n < 0)
                    throw new IllegalArgumentException();
                if (n == 0)
                    throw new IllegalArgumentException("Given array is empty");
                if (n == 1)
                    return SingletonData.create(data[fromIndex]);
            }
            return DataSet.create(data, fromIndex, toIndex);
        }
        throw new IllegalArgumentException("Given array size is more than tuple size");
    }

    /**
     * adding single value to list using SingletonList
     * 
     * @param value
     * @return
     */
    public static <T> Data<T> create(T value) {
        return SingletonData.create(value);
    }

    public static <T> Data<T> concat(Data<T> a, T v) {
        return concat(a, DataFactory.create(v));
    }

    public static <T> Data<T> concat(Data<T> a, Data<T> b) {
        return CompositeData.concat(a, b);
    }

}
