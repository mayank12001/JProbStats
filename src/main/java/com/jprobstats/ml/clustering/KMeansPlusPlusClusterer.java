package com.jprobstats.ml.clustering;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.jprobstats.ml.distance.DistanceMeasure;
import com.jprobstats.ml.distance.EuclideanDistance;
import com.jprobstats.ml.exception.DimensionMismatchException;
import com.jprobstats.ml.exception.NumberIsTooSmallException;
import com.jprobstats.ml.util.MathUtils;

public class KMeansPlusPlusClusterer<T extends Clusterable> extends Clusterer<T> {


    /** The number of clusters. */
    private final int k;
    /** Picking initial seeds */
    private final Random random;

    // Constructors
    // ------------------------------------------------------------------------

    public KMeansPlusPlusClusterer(final int k) {
        this(k, new EuclideanDistance());
    }

    public KMeansPlusPlusClusterer(final int k, final DistanceMeasure measure) {
        this(k, measure, new Random());
    }

    public KMeansPlusPlusClusterer(final int k, final DistanceMeasure measure, final Random random) {
        super(measure);
        this.k = k;
        this.random = random;

    }

    @Override
    public List<? extends Cluster<T>> cluster(Collection<T> points) throws DimensionMismatchException {

        // sanity checks
        MathUtils.checkNotNull(points);
        // number of clusters has to be smaller or equal the number of data points
        if (points.size() < k) {
            throw new NumberIsTooSmallException("Total number of points are less than total number of clusters.");
        }
        // create the initial clusters
        List<CentroidCluster<T>> clusters = chooseInitialCenters(points);
        int[] assignments = new int[points.size()];
        assignPointsToClusters(clusters, points, assignments);

        return clusters;
    }
    private void assignPointsToClusters(List<CentroidCluster<T>> clusters, Collection<T> points, int[] assignments) {
        for (final T point : points) {
            int clusterIndex = getNearestCluster(clusters, point);
            CentroidCluster<T> cluster = clusters.get(clusterIndex);
            cluster.addPoint(point);
        }

    }

    private int getNearestCluster(List<CentroidCluster<T>> clusters, T point) {
        double minDistance = Double.MAX_VALUE;
        int clusterIndex = 0;
        int nearCluster = 0;
        for (final CentroidCluster<T> cluster : clusters) {
            double d = distance(cluster.getCenter(), point);
            if (d < minDistance) {
                minDistance = d;
                nearCluster = clusterIndex;
            }
            clusterIndex++;
        }
        return nearCluster;
    }

  

    private List<CentroidCluster<T>> chooseInitialCenters(Collection<T> points) throws DimensionMismatchException {
        List<T> pointList = Collections.unmodifiableList(new ArrayList<T>(points));
        // The number of points in the list.
        final int numPoints = pointList.size();
        // selecting centroids
        List<CentroidCluster<T>> resultSet = new ArrayList<CentroidCluster<T>>();
        boolean[] taken = new boolean[pointList.size()];
        final int firstPointIndex = random.nextInt(numPoints);
        T firstPoint = pointList.get(firstPointIndex);
        resultSet.add(new CentroidCluster<T>(firstPoint));
        taken[firstPointIndex] = true;
        double[] minDistSquared = new double[numPoints];
        for (int i = 0; i < numPoints; i++) {
            if (i != firstPointIndex) {
                double d = distance(firstPoint, pointList.get(i));
                minDistSquared[i] = d * d;
            }
        }
        while (resultSet.size() < k) {

            // Sum up the squared distances for the points in pointList not
            // already taken.
            double distSqSum = 0.0;

            for (int i = 0; i < numPoints; i++) {
                if (!taken[i]) {
                    distSqSum += minDistSquared[i];
                }
            }

            // Add one new data point as a center. Each point x is chosen with
            // probability proportional to D(x)2
            final double r = random.nextDouble() * distSqSum;

            // The index of the next point to be added to the resultSet.
            int nextPointIndex = -1;

            // Sum through the squared min distances again, stopping when
            // sum >= r.
            double sum = 0.0;
            for (int i = 0; i < numPoints; i++) {
                if (!taken[i]) {
                    sum += minDistSquared[i];
                    if (sum >= r) {
                        nextPointIndex = i;
                        break;
                    }
                }
            }

            // If it's not set to >= 0, the point wasn't found in the previous
            // for loop, probably because distances are extremely small. Just pick
            // the last available point.
            if (nextPointIndex == -1) {
                for (int i = numPoints - 1; i >= 0; i--) {
                    if (!taken[i]) {
                        nextPointIndex = i;
                        break;
                    }
                }
            }

            // We found one.
            if (nextPointIndex >= 0) {

                final T p = pointList.get(nextPointIndex);

                resultSet.add(new CentroidCluster<T>(p));

                // Mark it as taken.
                taken[nextPointIndex] = true;

                if (resultSet.size() < k) {
                    // Now update elements of minDistSquared. We only have to compute
                    // the distance to the new center to do this.
                    for (int j = 0; j < numPoints; j++) {
                        // Only have to worry about the points still not taken.
                        if (!taken[j]) {
                            double d = distance(p, pointList.get(j));
                            double d2 = d * d;
                            if (d2 < minDistSquared[j]) {
                                minDistSquared[j] = d2;
                            }
                        }
                    }
                }

            } else {
                // None found --
                // Break from the while loop to prevent
                // an infinite loop.
                break;
            }



        }

        return resultSet;
    }
}
