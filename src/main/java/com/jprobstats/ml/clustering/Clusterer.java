package com.jprobstats.ml.clustering;

import java.util.Collection;
import java.util.List;

import com.jprobstats.ml.distance.DistanceMeasure;
import com.jprobstats.ml.exception.DimensionMismatchException;
import com.jprobstats.ml.exception.MathIllegalArgumentException;

/**
 * Base class for clustering n-dimensional points.
 * 
 * @param <T>
 */

public abstract class Clusterer<T extends Clusterable> {

    private final DistanceMeasure measure;

    /**
     * Build a new clusterer with the given {@link DistanceMeasure}.
     *
     * @param measure the distance measure to use
     */

    public Clusterer(DistanceMeasure measure) {
        super();
        this.measure = measure;
    }

    /**
     * Calculates the distance between two {@link Clusterable} instances with the configured
     * {@link DistanceMeasure}.
     *
     * @param p1 the first clusterable
     * @param p2 the second clusterable
     * @return the distance between the two clusterables
     */
    protected double distance(final Clusterable p1, final Clusterable p2) throws DimensionMismatchException {
        return measure.compute(p1.getPoint(), p2.getPoint());
    }

    /**
     * Performs cluster analysis on the given {@link Clusterable} instance.
     * 
     * @param points
     * @return a list of clusters
     * @throws Exception
     */
    public abstract List<CentroidCluster<T>> cluster(Collection<T> points) throws MathIllegalArgumentException;

    /**
     * Returns the {@link DistanceMeasure} instance used by this clusterer.
     *
     * @return the distance measure
     */

    public DistanceMeasure getMeasure() {
        return measure;
    }

}
