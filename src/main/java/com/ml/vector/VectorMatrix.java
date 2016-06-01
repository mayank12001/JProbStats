package com.ml.vector;

public class VectorMatrix {

    private final double[][] matrix;
    private int rows;
    private int columns;

    public VectorMatrix(double[][] ds) {
        rows = ds.length;
        columns = ds[0].length;
        for (int i =1; i<rows; i++) {
            double[] t = ds[i];
            if (columns != t.length) {
                throw new IllegalArgumentException("Element " + t + " is of varying length.");
            }
        }
        matrix = ds;        
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
