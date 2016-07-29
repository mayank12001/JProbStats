package com.jprobstats.ml.clustering;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds all points of particular cluster.
 */

public class Cluster<T extends Clusterable> implements Serializable {


    private final List<T> points;
   
    /**
     * Build a cluster centered at a specified point.
     */
    public Cluster() {
        points = new ArrayList<T>();
    }

    /**
     * Add a point to this cluster.
     * @param point point to add
     */
    public void addPoint(final T point) {
        points.add(point);
    }

    public List<T> getPoints() {
        return points;
    }


}
