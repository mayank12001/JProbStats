package com.jprobstats.ml.vector;

public class VectorUtil {

    private VectorUtil() {
        // Utility class
    }
    
    public static Vector differenceOfVector(Vector v1, Vector v2) {
        validateVectorDimensions(v1, v2);
        double[] vector1 = v1.getComponents();
        double[] vector2 = v2.getComponents();
        double[] result = new double[v1.legnth()];
        int index = 0;
        while (index < v1.legnth()) {
            result[index] = vector2[index] - vector1[index];
        }
        return new Vector(result);
    }

    public static Vector additionOfVector(Vector v1, Vector v2) {
        validateVectorDimensions(v1, v2);
        double[] vector1 = v1.getComponents();
        double[] vector2 = v2.getComponents();
        double[] result = new double[v1.legnth()];
        int index = 0;
        while (index < v1.legnth()) {
            result[index] = vector2[index] + vector1[index];
        }
        return new Vector(result);
    }

    private static void validateVectorDimensions(Vector v1, Vector v2) {
        if (v1.legnth() != v2.legnth()) {
            throw new RuntimeException("Vectors are of different dimensions");
        }
    }
    
    public static double magnitude(Vector vector) {
        double [] components = vector.getComponents();
        int length = vector.legnth();
        double sum = 0;
        for (int i=0; i<length; i++) {
            sum = sum + components[i]*components[i];
        }
        return Math.sqrt(sum);
    }
    
    public static double dotProduct(Vector v1, Vector v2) {
        int length = v1.legnth();
        if (length != v2.legnth()) {
            throw new IllegalArgumentException("Vectors are not of same dimension.");
        }
        double [] vector1 = v1.getComponents();
        double [] vector2 = v2.getComponents();
        double dotProduct = 0;
        for (int i=0; i<length; i++) {
            dotProduct += vector1[i]*vector2[i];
        }
        return dotProduct;
    }
}
