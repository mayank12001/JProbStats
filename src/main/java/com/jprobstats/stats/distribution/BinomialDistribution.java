package com.jprobstats.stats.distribution;

public class BinomialDistribution {

    private final int noOfTrails;
    private final double probOfSuccess;

    public BinomialDistribution(int noOfTrails, double probabilityOfSuccess) {
        this.noOfTrails = noOfTrails;
        this.probOfSuccess = probabilityOfSuccess;
    }

    public double getProbOfSuccess() {
        return probOfSuccess;
    }

    public int getNoOfTrails() {
        return noOfTrails;
    }

    public double getProbability(int x) {
        if (noOfTrails == 0) {
            return (x == 0) ? 0. : Double.NEGATIVE_INFINITY;
        }
        double ret;
        if (x < 0 || x > noOfTrails) {
            ret = Double.NEGATIVE_INFINITY;
        } else {
            ret = Math.exp(
                    SaddlePointExpansion.logBinomialProbability(x, noOfTrails, probOfSuccess, 1.0 - probOfSuccess));
        }
        return ret;

    }

    public double getNumericalMean() {
        return noOfTrails * probOfSuccess;
    }

    public double getNumericalVariance() {
        final double p = probOfSuccess;
        return noOfTrails * p * (1 - p);
    }
}
