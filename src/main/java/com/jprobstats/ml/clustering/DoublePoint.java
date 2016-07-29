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

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < points.length; i++) {

            String s = Double.toString(points[i]);
            str.append(s);
            if (i != points.length - 1)
                str.append(",");
        }
        str.append("]");
        return str.toString();

    }

}
