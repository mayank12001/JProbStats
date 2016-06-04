package com.jprobstats.ml.util;

import com.jprobstats.ml.exception.DimensionMismatchException;

public class MathArrays {
    /**
     * Private constructor.
     */
    private MathArrays() {}

    /**
     * Calculates the L<sub>2</sub> (Euclidean) distance between two points.
     * @param p1
     * @param p2
     * @return
     * @throws DimensionMismatchException
     */
    public static double distance(double[] p1, double[] p2) throws DimensionMismatchException {
        checkEqualLength(p1, p2);
        double sum = 0;
        for (int i = 0; i < p1.length; i++) {
            final double dp = p1[i] - p2[i];
            sum += dp * dp;
        }
        return Math.sqrt(sum);
    }

    /**
     * Check that both arrays have the same length.
     * @param a point 1 dimensions 
     * @param b point 2 dimensions
     * @throws DimensionMismatchException if arrays length differ.
     */
    public static void checkEqualLength(double[] a, double[] b) throws DimensionMismatchException {
        checkEqualLength(a, b, true);
    }

    /**
     * Check that both arrays have the same length.
     * @param a point 1 dimensions 
     * @param b point 2 dimensions 
     * @param abort Whether to throw an exception if the check fails.
     * @return {@code true} if the arrays have the same length.
     * @throws DimensionMismatchException if the lengths differ and {@code true} is ture.
     */
    private static boolean checkEqualLength(double[] a, double[] b, boolean abort) throws DimensionMismatchException {
        if (a.length == b.length) {
            return true;
        } else {
            if (abort) {
                throw new DimensionMismatchException("Dimensions of given points are not same.");
            }
            return false;
        }

    }

}
