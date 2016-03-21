package com.jprobstats.stats.utils;

import java.util.List;

/**
 * 
 *
 */
public interface DoubleArray {
    
    int getNumElements();
    double getElement(int index);
    void setElement(int index,double value);
    void addElement(double value);
    void addElements(double[] data);
    double[] getElements();
    void clear();
}
