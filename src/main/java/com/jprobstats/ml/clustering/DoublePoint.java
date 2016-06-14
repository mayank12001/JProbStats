package com.jprobstats.ml.clustering;

import java.io.Serializable;

public class DoublePoint implements Clusterable, Serializable {

    private final double[] points;

    public DoublePoint(double[] points) {
        this.points = points;
    }

    @Override
    public double[] getPoint() {
        return points;
    }

}
