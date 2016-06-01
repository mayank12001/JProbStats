package com.ml.vector;

public class Vector {

    private final double[] vector;
    private int length;

    /**
     * Constructs a <b>Zero</b> {@link Vector} of dimension one.
     */
    public Vector() {
        vector = new double[] {0};
        length = 1;
    }

    /**
     * Constructs a <b>Zero</b> {@link Vector} of specified dimension.
     * 
     * @param dimension - specifies the number of bases vectors, that will be the linear combination
     *        of the {@link Vector}.
     */
    public Vector(int dimension) {
        vector = new double[dimension];
        for (int i = 0; i < dimension; i++) {
            vector[i] = 0;
        }
        length = dimension;
    }

    public Vector(double... coefficients) {
        this.vector = coefficients;
        length = coefficients.length;
    }

    public double[] getComponents() {
        return vector;
    }

    public int legnth() {
        return length;
    }
}
