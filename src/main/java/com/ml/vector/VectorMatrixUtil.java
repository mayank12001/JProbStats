package com.ml.vector;

public class VectorMatrixUtil {

    private VectorMatrixUtil() {
        
    }
    
    public static VectorMatrix toMatrix(Vector... vectors) {

        double[][] matrix = new double[vectors.length][];
        int rowIndex = 0;
        while (rowIndex < vectors.length) {
            matrix[rowIndex] = vectors[rowIndex].getComponents();
            rowIndex++;
        }
        return new VectorMatrix(matrix);
    }

    public static VectorMatrix transpose(VectorMatrix vectorMatrix) {

        int rowIndex = vectorMatrix.getRows();
        int colIndex = vectorMatrix.getColumns();

        double[][] matrix = vectorMatrix.getMatrix();

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i + 1; j < colIndex; j++) {
                if (i != j) {
                    double temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return new VectorMatrix(matrix);
    }

    public static VectorMatrix toColumnMatrix(Vector... vectors) {
        VectorMatrix vectorMatrix = VectorMatrixUtil.toMatrix(vectors);
        return VectorMatrixUtil.transpose(vectorMatrix);
    }

    public static VectorMatrix toMatrix(int dimension, double... ds) {
        int totalComponents = ds.length;
        if (totalComponents % dimension != 0) {
            throw new IllegalArgumentException("Insufficient components to create valid vectors of given dimension");
        }
        int rows = totalComponents / dimension;
        int columns = dimension;
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = ds[i + j];
            }
        }
        Vector[] vectors = new Vector[rows];
        for (int i = 0; i < rows; i++) {
            vectors[i] = new Vector(matrix[i]);
        }
        return toMatrix(vectors);
    }
}
