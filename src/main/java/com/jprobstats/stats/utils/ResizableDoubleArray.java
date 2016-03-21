package com.jprobstats.stats.utils;

import com.jprobstats.stats.descriptive.UnivariateStatistic;

public class ResizableDoubleArray implements DoubleArray {

    /** Default value for initial capacity. */
    // TODO in future we can expand the array size 
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /**
     * The internal storage array.
     */
    private double[] internalArray;
    private int numElements = 0;
    private int startIndex = 0;



    public ResizableDoubleArray() {
        internalArray = new double[DEFAULT_INITIAL_CAPACITY];
        numElements = 0;
        startIndex = 0;
    }


    @Override
    public int getNumElements() {
        return numElements;
    }


    @Override
    public double getElement(int index) {
        if (index >= numElements) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else if (index >= 0) {
            return internalArray[startIndex + index];
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }
    }


    // TODO if index is >= dataset length then we have to expand the array
    @Override
    public void setElement(int index, double value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (index + 1 > numElements) {
            numElements = index + 1;
        }
        internalArray[startIndex + index] = value;
    }

    // TODO if dataset length <= startIndex + numElements then we have to expand the array
    @Override
    public void addElement(double value) {
        if (internalArray.length <= startIndex + numElements) {
            throw new ArrayIndexOutOfBoundsException();
        }
        internalArray[startIndex + numElements++] = value;
    }


    @Override
    public void addElements(double[] values) {
        final double[] tempArray = new double[numElements + values.length];
        System.arraycopy(internalArray, startIndex, tempArray, 0, numElements);
        System.arraycopy(values, 0, tempArray, numElements, values.length);
        internalArray = tempArray;
        startIndex = 0;
        numElements += values.length;

    }


    @Override
    public double[] getElements() {
        final double[] elementArray = new double[numElements];
        System.arraycopy(internalArray, startIndex, elementArray, 0, numElements);
        return elementArray;
    }


    @Override
    public void clear() {
        numElements = 0;
        startIndex = 0;
    }
    
    public double compute(UnivariateStatistic stats) throws Exception {
        final double[] array;
        array = internalArray;
        return stats.evaluate(array);
    }

}
