package com.jprobstats.ml.util;

import com.jprobstats.ml.exception.NullArgumentException;

public class MathUtils {
    
    /**
     * Checks that an object is not null.
     *
     * @param o Object to be checked.
     * @throws NullArgumentException if {@code o} is {@code null}.
     */
    public static void checkNotNull(Object o)
        throws NullArgumentException {
        if (o == null) {
            throw new NullArgumentException("Given input is null");
        }
    }
    

}
