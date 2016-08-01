package com.jprobstats.ml.distance;

import com.jprobstats.ml.util.MathArrays;
import com.jprobstats.stats.exception.DimensionMismatchException;

/**
 * Calculates Euclidean Distance between two points
 * <li>Euclidean Distance :: It is ordinary (Stright line) distance between two points in Euclidean
 * space.</li>
 * <li>Formula :: dist((x<sub>1</sub>, y<sub>1</sub>), (x<sub>2</sub>, y<sub>2</sub>)) = √(x<sub>2</sub> - x<sub>1</sub>)² + (y<sub>2</sub> - y<sub>1</sub>)²</li>
 * 
 */
public class EuclideanDistance implements DistanceMeasure {

    /**
     * Computing Euclidean distance between two points.
     * 
     * @param a array
     * @param b array
     * @return Euclidean distance between two points.
     * @throws DimensionMismatchException if dimensions are differ.
     */
    @Override
    public double compute(double[] a, double[] b) throws DimensionMismatchException {

        return MathArrays.distance(a, b);
    }

}
