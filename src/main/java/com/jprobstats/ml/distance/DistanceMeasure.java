package com.jprobstats.ml.distance;

import java.io.Serializable;

import com.jprobstats.stats.exception.DimensionMismatchException;

/**
 * Base interface to measure the distance between two points.
 * 
 *
 */
public interface DistanceMeasure extends Serializable {
    /**
     * Computing distance between two points.
     * 
     * @param a array
     * @param b array
     * @return distance between two points.
     * @throws DimensionMismatchException if dimensions are differ.
     */
    double compute(double[] a, double[] b) throws DimensionMismatchException;
}
