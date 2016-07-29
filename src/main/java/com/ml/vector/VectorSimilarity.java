package com.ml.vector;

public class VectorSimilarity {

    public double similarityByCosine(Vector v1, Vector v2) {
        double dotProduct = VectorUtil.dotProduct(v1, v2);
        double magnv1 = VectorUtil.magnitude(v1);
        double magnv2 = VectorUtil.magnitude(v2);
        return dotProduct / (magnv1 * magnv2);
    }

    public double similarityByMagnitude(Vector v1, Vector v2) {
        Vector diffVector = VectorUtil.differenceOfVector(v1, v2);
        return VectorUtil.magnitude(diffVector);
    }
}
